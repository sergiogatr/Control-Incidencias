/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.io.Serializable;
import java.util.Objects;
import org.japo.java.libraries.UtilesEspecialidades;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public final class Especialidad implements Serializable {
 
    
    // Campos
    private int id;
    private String nombre;
    private String info;
        
    
    // Constructores
    public Especialidad() {
        
        this.id = UtilesEspecialidades.DEF_ID;
        this.nombre = UtilesEspecialidades.DEF_NOMBRE;
        this.info = UtilesEspecialidades.DEF_INFO;
        
    }

    public Especialidad(int id, String nombre, String info) {

        // Validación ID
        if (UtilesEspecialidades.validarId(id)) {
            this.id = id;
        } else {
            this.id = UtilesEspecialidades.DEF_ID;
        }
        
        
        // Validación Nombre
        if (UtilesEspecialidades.validarNombre(nombre)) {
            this.nombre = nombre;
        } else {
            this.nombre = UtilesEspecialidades.DEF_NOMBRE;
        }
        
        
        // Validación Info
        if (UtilesEspecialidades.validarInfo(info)) {
            this.info = info;
        } else {
            this.info = UtilesEspecialidades.DEF_INFO;
        }
        
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (UtilesEspecialidades.validarId(id)) {
            this.id = id;
        } 
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (UtilesEspecialidades.validarNombre(nombre)) {
            this.nombre = nombre;
        }
    }

    
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        if (UtilesEspecialidades.validarInfo(info)) {
            this.info = info;
        }
    }
    
    
        @Override
    public boolean equals(Object o) {
        boolean testOK = false;
        if (o instanceof Especialidad) {
            Especialidad e = (Especialidad) o;
            testOK
                    = id == e.getId()
                    && nombre.equals(e.getNombre())
                    && info.equals(e.getInfo());
        }
        return testOK;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.info);
        return hash;
    }
    
    
}
