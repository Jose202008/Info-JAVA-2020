package com.nuestroblog.blogadmin.service;

import com.nuestroblog.blogadmin.entity.Usuario;
import com.nuestroblog.blogadmin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id); }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Long id) {
        return userRepository.findById(id);
    }
    
}
