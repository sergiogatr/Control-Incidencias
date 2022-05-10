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
import org.japo.java.libraries.UtilesNotificaciones;
import org.japo.java.libraries.UtilesUsuarios;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public final class Notificacion implements Serializable {
 
    
    // Campos
    private int id;
    private Date fecha;
    private int autor;
    private String autorNombre;
    private int incidencia;
    private String incidenciaNombre;
    private String info;
    
    
    public Notificacion() {
        
        this.id = UtilesNotificaciones.DEF_ID;
        this.fecha = UtilesNotificaciones.DEF_FECHA;
        this.autor = UtilesUsuarios.DEF_ID;
        this.autorNombre = UtilesUsuarios.DEF_USER;
        this.incidencia = UtilesIncidencias.DEF_ID;
        this.incidenciaNombre = UtilesIncidencias.DEF_NOMBRE;
        this.info = UtilesNotificaciones.DEF_INFO;
        
    }
    
    

    public Notificacion(int id, Date fecha, int autor, String autorNombre,
            int incidencia, String incidenciaNombre, String info) {

        // Validación ID
        if (UtilesNotificaciones.validarId(id)) {
            this.id = id;
        } else {
            this.id = UtilesNotificaciones.DEF_ID;
        }
        
        
        // Validación Fecha
        if (UtilesNotificaciones.validarFecha(fecha)) {
            this.fecha = fecha;
        } else {
            this.fecha = UtilesNotificaciones.DEF_FECHA;
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
        
        
        // Validación Incidencia
        if (UtilesIncidencias.validarId(incidencia)) {
            this.incidencia = incidencia;
        } else {
            this.incidencia = UtilesIncidencias.DEF_ID;
        }
        
        
        // Validación Incidencia Nombre
        if (UtilesIncidencias.validarNombre(incidenciaNombre)) {
            this.incidenciaNombre = incidenciaNombre;
        } else {
            this.incidenciaNombre = UtilesIncidencias.DEF_NOMBRE;
        }
        
        
        // Validación Info
        if (UtilesNotificaciones.validarInfo(info)) {
            this.info = info;
        } else {
            this.info = UtilesNotificaciones.DEF_INFO;
        }
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (UtilesNotificaciones.validarId(id)) {
            this.id = id;
        } 
    }
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        if (UtilesNotificaciones.validarFecha(fecha)) {
            this.fecha = fecha;
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
    
    
    public int getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(int incidencia) {
        if (UtilesIncidencias.validarId(incidencia)) {
            this.incidencia = incidencia;
        } 
    }
    
    
    public String getIncidenciaNombre() {
        return incidenciaNombre;
    }

    public void setIncidenciaNombre(String incidenciaNombre) {
        if (UtilesIncidencias.validarNombre(incidenciaNombre)) {
            this.incidenciaNombre = incidenciaNombre;
        } 
    }

    
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        if (UtilesNotificaciones.validarInfo(info)) {
            this.info = info;
        }
    }
    
    
        @Override
    public boolean equals(Object o) {
        boolean testOK = false;
        if (o instanceof Notificacion) {
            Notificacion e = (Notificacion) o;
            testOK
                    = id == e.getId()
                    && fecha.equals(e.getFecha())
                    && autor == e.getAutor()
                    && autorNombre.equals(e.getAutorNombre())
                    && incidencia == e.getIncidencia()
                    && incidenciaNombre.equals(e.getIncidenciaNombre())
                    && info.equals(e.getInfo());
        }
        return testOK;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.fecha);
        hash = 37 * hash + this.autor;
        hash = 37 * hash + Objects.hashCode(this.autorNombre);
        hash = 37 * hash + this.incidencia;
        hash = 37 * hash + Objects.hashCode(this.incidenciaNombre);
        hash = 37 * hash + Objects.hashCode(this.info);
        return hash;
    }
    
}
