package com.nuestroblog.blogadmin.entity;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    private String descripcion;
    private String contenido;
    @CreationTimestamp
    private LocalDateTime fechap;
    @Column(nullable = false)
    private String autor;
    private Boolean publicado;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public LocalDateTime getFechap() { return fechap; }
    public void setFechap( LocalDateTime fechap) { this.fechap = fechap; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public Boolean getPublicado() { return publicado; }
    public void setPublicado(Boolean publicado) { this.publicado = publicado; }

}
