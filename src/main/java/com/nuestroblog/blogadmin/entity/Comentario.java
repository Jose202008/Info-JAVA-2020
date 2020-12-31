package com.nuestroblog.blogadmin.entity;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
//import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private Long idPubli;
    @Column(nullable = false)
    private String autor;
//    @Size(max = 200)
    private String comentarios;
    @CreationTimestamp
    private LocalDateTime fechac;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getidPubli() { return idPubli; }
    public void setidPubli(Long idPubli) { this.idPubli = idPubli; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public LocalDateTime getFechac() { return fechac; }
    public void setFechac(LocalDateTime fechac) { this.fechac = fechac;
    }
}
