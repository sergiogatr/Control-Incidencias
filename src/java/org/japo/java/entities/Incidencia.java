/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.japo.java.libraries.UtilesDependencias;
import org.japo.java.libraries.UtilesEspecialidades;
import org.japo.java.libraries.UtilesIncidencias;
import org.japo.java.libraries.UtilesUsuarios;

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
    private String autorNombre;
    private int dependencia;
    private String dependenciaNombre;
    private int especialidad;
    private String especialidadNombre;
    
    
    
    public Incidencia() {
        
        this.id = UtilesIncidencias.DEF_ID;
        this.nombre = UtilesIncidencias.DEF_NOMBRE;
        this.info = UtilesIncidencias.DEF_INFO;
        this.estado = UtilesIncidencias.DEF_ESTADO;
        this.creacion = UtilesIncidencias.DEF_CREACION;
        this.autor = UtilesUsuarios.DEF_ID;
        this.autorNombre = UtilesUsuarios.DEF_USER;
        this.dependencia = UtilesDependencias.DEF_ID;
        this.dependenciaNombre = UtilesDependencias.DEF_NOMBRE;
        this.especialidad = UtilesEspecialidades.DEF_ID;
        this.especialidadNombre = UtilesEspecialidades.DEF_NOMBRE;
        
    }
    
    

    public Incidencia(int id, String nombre, String info, int estado,
            Date creacion, int autor, String autorNombre, 
            int dependencia, String dependenciaNombre, int especialidad,
            String especialidadNombre) {

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
        if (UtilesUsuarios.validarId(autor)) {
            this.autor = autor;
        } else {
            this.autor = UtilesUsuarios.DEF_ID;
        }
        
        
        // Validación Autor Nombre
        if (UtilesUsuarios.validarUser(autorNombre)) {
            this.autorNombre = autorNombre;
        } else {
            this.autorNombre = UtilesUsuarios.DEF_USER;
        }
        
        
        // Validación Dependencia
        if (UtilesDependencias.validarId(dependencia)) {
            this.dependencia = dependencia;
        } else {
            this.dependencia = UtilesDependencias.DEF_ID;
        }
        
        
        // Validación Dependencia Nombre
        if (UtilesDependencias.validarNombre(dependenciaNombre)) {
            this.dependenciaNombre = dependenciaNombre;
        } else {
            this.dependenciaNombre = UtilesDependencias.DEF_NOMBRE;
        }
        
        
        // Validación Dependencia
        if (UtilesEspecialidades.validarId(especialidad)) {
            this.especialidad = especialidad;
        } else {
            this.especialidad = UtilesEspecialidades.DEF_ID;
        }
        
        
        // Validación Dependencia Nombre
        if (UtilesEspecialidades.validarNombre(especialidadNombre)) {
            this.especialidadNombre = especialidadNombre;
        } else {
            this.especialidadNombre = UtilesEspecialidades.DEF_NOMBRE;
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
        if (UtilesUsuarios.validarId(autor)) {
            this.autor = autor;
        } 
    }
    
    
    public String getAutorNombre() {
        return autorNombre;
    }

    public void setAutorNombre(String autorNombre) {
        if (UtilesUsuarios.validarUser(autorNombre)) {
            this.autorNombre = autorNombre;
        } 
    }
    
    
    public int getDependencia() {
        return dependencia;
    }

    public void setDependencia(int dependencia) {
        if (UtilesDependencias.validarId(dependencia)) {
            this.dependencia = dependencia;
        } 
    }

    
    public String getDependenciaNombre() {
        return dependenciaNombre;
    }

    public void setDependenciaNombre(String dependenciaNombre) {
        if (UtilesDependencias.validarNombre(dependenciaNombre)) {
            this.dependenciaNombre = dependenciaNombre;
        } 
    }
    
    
    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        if (UtilesEspecialidades.validarId(especialidad)) {
            this.especialidad = especialidad;
        } 
    }
    
    
    public String getEspecialidadNombre() {
        return especialidadNombre;
    }

    public void setEspecialidadNombre(String especialidadNombre) {
        if (UtilesEspecialidades.validarNombre(especialidadNombre)) {
            this.especialidadNombre = especialidadNombre;
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
                    && autorNombre.equals(e.getAutorNombre())
                    && dependencia == e.getDependencia()
                    && dependenciaNombre.equals(e.getDependenciaNombre())
                    && especialidad == e.getEspecialidad()
                    && especialidadNombre.equals(e.getEspecialidadNombre());
        }
        return testOK;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.info);
        hash = 37 * hash + this.estado;
        hash = 37 * hash + Objects.hashCode(this.creacion);
        hash = 37 * hash + this.autor;
        hash = 37 * hash + Objects.hashCode(this.autorNombre);
        hash = 37 * hash + this.dependencia;
        hash = 37 * hash + Objects.hashCode(this.dependenciaNombre);
        hash = 37 * hash + this.especialidad;
        hash = 37 * hash + Objects.hashCode(this.especialidadNombre);
        return hash;
    }
 
}
