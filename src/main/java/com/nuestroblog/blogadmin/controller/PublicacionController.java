package com.nuestroblog.blogadmin.controller;

import com.nuestroblog.blogadmin.entity.Publicacion;
import com.nuestroblog.blogadmin.repository.PublicacionRepository;
import com.nuestroblog.blogadmin.service.PublicacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/publicacion")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    //CONSULTA - obtener todas las publicaciones
    @GetMapping() // ~ /api/v1/publicacion
    public ResponseEntity<?> getPublicacion() {
        return new ResponseEntity<>(publicacionService.findAll(), HttpStatus.OK);
    }

    //ALTA de publicacion nueva
    @PostMapping // ~ /api/v1/publicacion
    public ResponseEntity<?> crearPublicacion(@RequestBody Publicacion publicacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(publicacionService.save(publicacion));
    }

    //BAJA de publicacion indicando id por path
    @DeleteMapping("/{publicacionId}")
    public ResponseEntity<?> deletePublicacion(@PathVariable Long publicacionId) {
        publicacionService.deleteById(publicacionId);
        return ResponseEntity.ok().build();
    }

    //MODIFICACIÓN de una publicación indicando id por path
    @PutMapping("/{publicacionId}")
    public ResponseEntity<?> editPublicacion(@RequestBody Publicacion publicacionDetails, @PathVariable Long publicacionId) {
        Optional<Publicacion> publicacion = publicacionService.findById(publicacionId);
        if (!publicacion.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        if (publicacionDetails.getTitulo() != null) {
            publicacion.get().setTitulo(publicacionDetails.getTitulo());
        }
        if (publicacionDetails.getDescripcion() != null) {
            publicacion.get().setDescripcion(publicacionDetails.getDescripcion());
        }
        if (publicacionDetails.getContenido() != null) {
            publicacion.get().setContenido(publicacionDetails.getContenido());
        }
        if (publicacionDetails.getAutor() != null) {
            publicacion.get().setAutor(publicacionDetails.getAutor());
        }
        if (publicacionDetails.getPublicado() != null) {
            publicacion.get().setPublicado(publicacionDetails.getPublicado());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(publicacionService.save(publicacion.get()));
    }


}
