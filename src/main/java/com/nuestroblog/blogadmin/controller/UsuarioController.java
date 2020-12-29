package com.nuestroblog.blogadmin.controller;

import com.nuestroblog.blogadmin.entity.Usuario;
import com.nuestroblog.blogadmin.repository.UsuarioRepository;
import com.nuestroblog.blogadmin.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuario")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //Alta de usuario
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario)); 
    }

    //Consultar todos los usuarios de la tabla
    @GetMapping()
    public ResponseEntity<?> getUsuario() {
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK); 
    }

    //Baja de usuario indicando id por path
    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<?> deleteUsuario (@PathVariable Long usuarioId) {
        usuarioService.deleteById(usuarioId);
        return ResponseEntity.ok().build(); 
    }

    //Modificación de un usuario indicando id por path
    @PutMapping("/{usuarioId}")
    public ResponseEntity<?> editUsuario (@RequestBody Usuario usuarioDetails, @PathVariable Long usuarioId) {
        Optional<Usuario> usuario = usuarioService.findById(usuarioId);
        if (!usuario.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuario.get().setNombre(usuarioDetails.getNombre());
        usuario.get().setApellido(usuarioDetails.getApellido());
        usuario.get().setEmail(usuarioDetails.getEmail());
        usuario.get().setPassword(usuarioDetails.getPassword());
        usuario.get().setCiudad(usuarioDetails.getCiudad());
        usuario.get().setProvincia(usuarioDetails.getProvincia());
        usuario.get().setPais(usuarioDetails.getPais());
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get())); 
    }

    //Consulta usuarios por ciudad
    @GetMapping("/de") // ~ /api/v1/usuario/de?ciudad=Resistencia
    public ResponseEntity<?> usuarioPorCiudad (@RequestParam String ciudad) {
        List<Usuario> usuario = usuarioService.findByCiudad(ciudad);
        System.out.println(usuario.get(0).getNombre());
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    //Consulta todos los usuarios creados despues de una fecha dada
    @GetMapping("/desde") // ~ /api/v1/usuario/desde?fecha=2020/12/28
    public ResponseEntity<?> buscarUsuariosPorFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime fecha) {
        List<Usuario> usuario = usuarioService.findByFechaIsAfter(fecha);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
