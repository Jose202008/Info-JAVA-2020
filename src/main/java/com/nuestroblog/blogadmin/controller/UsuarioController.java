package com.nuestroblog.blogadmin.controller;

import com.nuestroblog.blogadmin.entity.Usuario;
import com.nuestroblog.blogadmin.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
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

    //crear un usuario nuevo
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario)); }

    //obtener todos los usuarios
    @GetMapping()
    public ResponseEntity<?> getUsuario() {
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK); }

}
