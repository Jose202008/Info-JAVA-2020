package com.nuestroblog.blogadmin.repository;

import com.nuestroblog.blogadmin.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
}
