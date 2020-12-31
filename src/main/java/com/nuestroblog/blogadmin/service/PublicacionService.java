package com.nuestroblog.blogadmin.service;

import com.nuestroblog.blogadmin.entity.Publicacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface PublicacionService {
    public Iterable<Publicacion> findAll();
    public Page<Publicacion> findAll(Pageable pageable);
    public Publicacion save(Publicacion publicacion);
    public void deleteById(Long id);
    public Optional<Publicacion> findById(Long id);
    public List<Publicacion> findByTitulo(String titulo);
    public List<Publicacion> findByPublicado(Boolean publicado);
}
