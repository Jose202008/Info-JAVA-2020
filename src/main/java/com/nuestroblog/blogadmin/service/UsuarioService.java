package com.nuestroblog.blogadmin.service;

import com.nuestroblog.blogadmin.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
 
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public Iterable<Usuario> findAll();
    public Page<Usuario> findAll(Pageable pageable);
    public Usuario save(Usuario usuario);
    public void deleteById (Long id);
    public Optional<Usuario> findById (Long id);
    public List<Usuario> findByCiudad(String ciudad);
}
