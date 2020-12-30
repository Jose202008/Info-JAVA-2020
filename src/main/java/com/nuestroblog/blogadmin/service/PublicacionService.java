package com.nuestroblog.blogadmin.service;

import com.nuestroblog.blogadmin.entity.Publicacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface PublicacionService {
    public Iterable<Publicacion> findAll();
    public Publicacion save(Publicacion publicacion);
    public void deleteById(Long id);
    public Optional<Publicacion> findById(Long id);
}