package com.nuestroblog.blogadmin.repository;

import com.nuestroblog.blogadmin.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByCiudad(String ciudad);
    List<Usuario> findByFechaIsAfter(LocalDate fecha);
}
