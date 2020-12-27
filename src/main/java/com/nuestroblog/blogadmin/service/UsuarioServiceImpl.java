package com.nuestroblog.blogadmin.service;

import com.nuestroblog.blogadmin.entity.Usuario;
import com.nuestroblog.blogadmin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Usuario> findAll() {
        return userRepository.findAll(); }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
        return userRepository.findAll(pageable); }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return userRepository.save(usuario); }

}
