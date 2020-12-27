package com.nuestroblog.blogadmin.service;

import com.nuestroblog.blogadmin.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {
    public Iterable<Usuario> findAll();
    public Page<Usuario> findAll(Pageable pageable);
    public Usuario save(Usuario usuario);
}
