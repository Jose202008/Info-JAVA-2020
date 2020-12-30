package com.nuestroblog.blogadmin.controller;

import com.nuestroblog.blogadmin.entity.Usuario;
import com.nuestroblog.blogadmin.repository.UsuarioRepository;
import com.nuestroblog.blogadmin.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuario")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //ALTA de usuario
    @PostMapping // ~ /api/v1/usuario
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario)); 
    }

    //CONSULTA - obtener todos los usuarios de la tabla
    @GetMapping() // ~ /api/v1/usuario
    public ResponseEntity<?> getUsuario() {
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK); 
    }

    //BAJA de usuario indicando id por path
    @DeleteMapping("/{usuarioId}") // ~ /api/v1/usuario/1
    public ResponseEntity<?> deleteUsuario (@PathVariable Long usuarioId) {
        usuarioService.deleteById(usuarioId);
        return ResponseEntity.ok().build(); 
    }

    //MODIFICACIÓN de un usuario indicando id por path
    @PutMapping("/{usuarioId}") // ~ /api/v1/usuario/1
    public ResponseEntity<?> editUsuario (@RequestBody Usuario usuarioDetails, @PathVariable Long usuarioId) {
        Optional<Usuario> usuario = usuarioService.findById(usuarioId);
        if (!usuario.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        if (usuarioDetails.getNombre() != null) {
            usuario.get().setNombre(usuarioDetails.getNombre());
        }
        if (usuarioDetails.getApellido() != null) {
            usuario.get().setApellido(usuarioDetails.getApellido());
        }
        if (usuarioDetails.getEmail() != null) {
            usuario.get().setEmail(usuarioDetails.getEmail());
        }
        if (usuarioDetails.getPassword() != null) {
            usuario.get().setPassword(usuarioDetails.getPassword());
        }
        if (usuarioDetails.getCiudad() != null) {
            usuario.get().setCiudad(usuarioDetails.getCiudad());
        }
        if (usuarioDetails.getProvincia() != null) {
            usuario.get().setProvincia(usuarioDetails.getProvincia());
        }
        if (usuarioDetails.getPais() != null) {
            usuario.get().setPais(usuarioDetails.getPais());
        }
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
    public ResponseEntity<?> buscarUsuariosPorFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        List<Usuario> usuario = usuarioService.findByFechaIsAfter(fecha);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
