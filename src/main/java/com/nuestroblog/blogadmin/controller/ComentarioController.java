package com.nuestroblog.blogadmin.controller;

import com.nuestroblog.blogadmin.entity.Comentario;
import com.nuestroblog.blogadmin.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    //ALTA de comentario
    @PostMapping // ~ /api/v1/comentario
    public ResponseEntity<?>crearComentario(@RequestBody Comentario comentario) {
        return new ResponseEntity<>(comentarioService.save(comentario), HttpStatus.CREATED);
    }

    //BAJA de un comentario segun id
    @DeleteMapping("/{comentarioId}") // ~ /api/v1/comentario/1
    public ResponseEntity<?> deleteComentario (@PathVariable Long comentarioId) {
        comentarioService.deleteById(comentarioId);
        return ResponseEntity.ok().build();
    }

    //MODIFICACION de un comentario segun id
    @PutMapping("/{comentarioId}") // ~ /api/v1/comentario/1
    public ResponseEntity<?> editComentario (@RequestBody Comentario comentariosDetails, @PathVariable Long comentarioId) {
        Optional<Comentario> comentario = comentarioService.findById(comentarioId);
        if(!comentario.isPresent()){
            return ResponseEntity.notFound().build();
        }
        comentario.get().setAutor(comentariosDetails.getAutor());
        comentario.get().setComentarios(comentariosDetails.getComentarios());
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.save(comentario.get()));
    }

    //CONSULTA - Obtener todos los comentarios
    @GetMapping() // ~ /api/v1/comentario
    public ResponseEntity<?> getComentarios() {
        return new ResponseEntity<>(comentarioService.findAll(), HttpStatus.OK);
    }
}
