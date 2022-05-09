/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.japo.java.libraries.UtilesNotificaciones;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public final class Notificacion implements Serializable {
 
    
    // Campos
    private int id;
    private Date fecha;
    private int autor;
    private int incidencia;
    private String info;
    
    
    public Notificacion() {
        
        this.id = UtilesNotificaciones.DEF_ID;
        this.fecha = UtilesNotificaciones.DEF_FECHA;
        this.autor = UtilesNotificaciones.DEF_AUTOR;
        this.incidencia = UtilesNotificaciones.DEF_INCIDENCIA;
        this.info = UtilesNotificaciones.DEF_INFO;
        
    }
    
    

    public Notificacion(int id, Date fecha, int autor, int incidencia, String info) {

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
        if (UtilesNotificaciones.validarAutor(autor)) {
            this.autor = autor;
        } else {
            this.autor = UtilesNotificaciones.DEF_AUTOR;
        }
        
        
        // Validación Incidencia
        if (UtilesNotificaciones.validarIncidencia(incidencia)) {
            this.incidencia = incidencia;
        } else {
            this.incidencia = UtilesNotificaciones.DEF_INCIDENCIA;
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
        if (UtilesNotificaciones.validarAutor(autor)) {
            this.autor = autor;
        } 
    }
    
    
    public int getIncidencia() {
        return id;
    }

    public void setIncidencia(int incidencia) {
        if (UtilesNotificaciones.validarIncidencia(incidencia)) {
            this.incidencia = incidencia;
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
                    && incidencia == e.getIncidencia()
                    && info.equals(e.getInfo());
        }
        return testOK;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.fecha);
        hash = 61 * hash + this.autor;
        hash = 61 * hash + this.incidencia;
        hash = 61 * hash + Objects.hashCode(this.info);
        return hash;
    }
    
}
