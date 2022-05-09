/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.util.Objects;
import org.japo.java.libraries.UtilesPerfiles;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public final class Perfil {
    
    
    // CAMPOS
    private int id;
    private String nombre;
    private String info;

    
    // Constructores
    public Perfil() {
        
        this.id = UtilesPerfiles.DEF_ID;
        this.nombre = UtilesPerfiles.DEF_NOMBRE;
        this.info = UtilesPerfiles.DEF_INFO;
        
    }
    
    public Perfil(int id, String nombre, String info) {
        
        // Validación ID
        if (UtilesPerfiles.validarId(id)) {
            this.id = id;
        } else {
            this.id = UtilesPerfiles.DEF_ID;
        }
        
        
        // Validación Nombre
        if (UtilesPerfiles.validarNombre(nombre)) {
            this.nombre = nombre;
        } else {
            this.nombre = UtilesPerfiles.DEF_NOMBRE;
        }
        
        
        // Validación Info
        if (UtilesPerfiles.validarInfo(info)) {
            this.info = info;
        } else {
            this.info = UtilesPerfiles.DEF_INFO;
        }
        
    }

    
    // Campos Encapsulados
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (UtilesPerfiles.validarId(id)) {
            this.id = id;
        } 
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (UtilesPerfiles.validarNombre(nombre)) {
            this.nombre = nombre;
        }
    }

    
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        if (UtilesPerfiles.validarInfo(info)) {
            this.info = info;
        }
    } 

    
    @Override
    public boolean equals(Object o) {
        boolean testOK = false;
        if (o instanceof Perfil) {
            Perfil p = (Perfil) o;
            testOK
                    = id == p.getId()
                    && nombre.equals(p.getNombre())
                    && info.equals(p.getInfo());
        }
        return testOK;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.info);
        return hash;
    }
    
}
