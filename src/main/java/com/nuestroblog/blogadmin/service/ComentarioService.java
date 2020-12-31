package com.nuestroblog.blogadmin.service;

import com.nuestroblog.blogadmin.entity.Comentario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface ComentarioService {
    public Iterable<Comentario> findAll();
    public Page<Comentario> findAll(Pageable pageable);
    public Optional<Comentario> findById(Long id);
    public Comentario save(Comentario comentario);
    public void deleteById(Long id);
}
