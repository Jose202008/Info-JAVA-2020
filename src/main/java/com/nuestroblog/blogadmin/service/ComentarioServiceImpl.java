package com.nuestroblog.blogadmin.service;

import com.nuestroblog.blogadmin.entity.Comentario;
import com.nuestroblog.blogadmin.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class ComentarioServiceImpl implements ComentarioService{

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Comentario> findAll(Pageable pageable) {
        return comentarioRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Optional<Comentario> findById(Long id) {
        return comentarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Comentario save(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    @Transactional
    public void deleteById(Long id) { comentarioRepository.deleteById(id);
    }
}
