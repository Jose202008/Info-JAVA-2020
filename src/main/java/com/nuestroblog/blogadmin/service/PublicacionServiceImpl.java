package com.nuestroblog.blogadmin.service;

import com.nuestroblog.blogadmin.entity.Publicacion;
import com.nuestroblog.blogadmin.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PublicacionServiceImpl implements PublicacionService{

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Publicacion> findAll() {
        return publicacionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Publicacion> findAll(Pageable pageable) {
        return publicacionRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Publicacion save(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {publicacionRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Publicacion> findById(Long id) {
        return publicacionRepository.findById(id);
    }

    @Override
    public List<Publicacion> findByTitulo(String titulo) {
        return publicacionRepository.findByTitulo(titulo);
    }

    @Override
    public List<Publicacion> findByPublicado(Boolean publicado) {
        return publicacionRepository.findByPublicado(publicado);
    }

}
