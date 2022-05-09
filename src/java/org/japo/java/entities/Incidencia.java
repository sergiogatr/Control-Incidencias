/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.japo.java.libraries.UtilesIncidencias;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public final class Incidencia implements Serializable {
 
    
    // Campos
    private int id;
    private String nombre;
    private String info;
    private int estado;
    private Date creacion;
    private int autor;
    private int dependencia;
    private int especialidad;
    
    
    
    public Incidencia() {
        
        this.id = UtilesIncidencias.DEF_ID;
        this.nombre = UtilesIncidencias.DEF_NOMBRE;
        this.info = UtilesIncidencias.DEF_INFO;
        this.estado = UtilesIncidencias.DEF_ESTADO;
        this.creacion = UtilesIncidencias.DEF_CREACION;
        this.autor = UtilesIncidencias.DEF_AUTOR;
        this.dependencia = UtilesIncidencias.DEF_DEPENDENCIA;
        this.especialidad = UtilesIncidencias.DEF_ESPECIALIDAD;
        
    }
    
    

    public Incidencia(int id, String nombre, String info, int estado,
            Date creacion, int autor, int dependencia, int especialidad ) {

        // Validación ID
        if (UtilesIncidencias.validarId(id)) {
            this.id = id;
        } else {
            this.id = UtilesIncidencias.DEF_ID;
        }
        
        
        // Validación Nombre
        if (UtilesIncidencias.validarNombre(nombre)) {
            this.nombre = nombre;
        } else {
            this.nombre = UtilesIncidencias.DEF_NOMBRE;
        }
        
        
        // Validación Info
        if (UtilesIncidencias.validarInfo(info)) {
            this.info = info;
        } else {
            this.info = UtilesIncidencias.DEF_INFO;
        }
        
        
        // Validación Estado
        if (UtilesIncidencias.validarEstado(estado)) {
            this.estado = estado;
        } else {
            this.estado = UtilesIncidencias.DEF_ESTADO;
        }
        
        
        // Validación Creacion
        if (UtilesIncidencias.validarCreacion(creacion)) {
            this.creacion = creacion;
        } else {
            this.creacion = UtilesIncidencias.DEF_CREACION;
        }
        
        
        // Validación Autor
        if (UtilesIncidencias.validarAutor(autor)) {
            this.autor = autor;
        } else {
            this.autor = UtilesIncidencias.DEF_AUTOR;
        }
        
        
        // Validación Dependencia
        if (UtilesIncidencias.validarDependencia(dependencia)) {
            this.dependencia = dependencia;
        } else {
            this.dependencia = UtilesIncidencias.DEF_DEPENDENCIA;
        }
        
        
        // Validación Dependencia
        if (UtilesIncidencias.validarEspecialidad(especialidad)) {
            this.especialidad = especialidad;
        } else {
            this.especialidad = UtilesIncidencias.DEF_ESPECIALIDAD;
        }
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (UtilesIncidencias.validarId(id)) {
            this.id = id;
        } 
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (UtilesIncidencias.validarNombre(nombre)) {
            this.nombre = nombre;
        }
    }
    
    
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        if (UtilesIncidencias.validarInfo(info)) {
            this.info = info;
        }
    }
    
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        if (UtilesIncidencias.validarEstado(estado)) {
            this.estado = estado;
        } 
    }

    
    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        if (UtilesIncidencias.validarCreacion(creacion)) {
            this.creacion = creacion;
        }
    }
    
    
    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        if (UtilesIncidencias.validarAutor(autor)) {
            this.autor = autor;
        } 
    }
    
    
    public int getDependencia() {
        return dependencia;
    }

    public void setDependencia(int dependencia) {
        if (UtilesIncidencias.validarDependencia(dependencia)) {
            this.dependencia = dependencia;
        } 
    }

    
    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        if (UtilesIncidencias.validarEspecialidad(especialidad)) {
            this.especialidad = especialidad;
        } 
    }
    
    
        @Override
    public boolean equals(Object o) {
        boolean testOK = false;
        if (o instanceof Incidencia) {
            Incidencia e = (Incidencia) o;
            testOK
                    = id == e.getId()
                    && nombre.equals(e.getNombre())
                    && info.equals(e.getInfo())
                    && estado == e.getEstado()
                    && creacion.equals(e.getCreacion())
                    && autor == e.getAutor()
                    && dependencia == e.getDependencia()
                    && especialidad == e.getEspecialidad();
        }
        return testOK;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.nombre);
        hash = 11 * hash + Objects.hashCode(this.info);
        hash = 11 * hash + this.estado;
        hash = 11 * hash + Objects.hashCode(this.creacion);
        hash = 11 * hash + this.autor;
        hash = 11 * hash + this.dependencia;
        hash = 11 * hash + this.especialidad;
        return hash;
    }
     
}
