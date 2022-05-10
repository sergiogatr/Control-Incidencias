/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.util.Objects;
import org.japo.java.libraries.UtilesDependencias;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public final class Dependencia {
    
    
    // CAMPOS
    private int id;
    private String nombre;
    private String info;

    
    // Constructores
    public Dependencia() {
        
        this.id = UtilesDependencias.DEF_ID;
        this.nombre = UtilesDependencias.DEF_NOMBRE;
        this.info = UtilesDependencias.DEF_INFO;
        
    }
    
    public Dependencia(int id, String nombre, String info) {
        
        // Validación ID
        if (UtilesDependencias.validarId(id)) {
            this.id = id;
        } else {
            this.id = UtilesDependencias.DEF_ID;
        }
        
        
        // Validación Nombre
        if (UtilesDependencias.validarNombre(nombre)) {
            this.nombre = nombre;
        } else {
            this.nombre = UtilesDependencias.DEF_NOMBRE;
        }
        
        
        // Validación Info
        if (UtilesDependencias.validarInfo(info)) {
            this.info = info;
        } else {
            this.info = UtilesDependencias.DEF_INFO;
        }
        
    }

    
    // Campos Encapsulados
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (UtilesDependencias.validarId(id)) {
            this.id = id;
        } 
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (UtilesDependencias.validarNombre(nombre)) {
            this.nombre = nombre;
        }
    }
    

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        if (UtilesDependencias.validarInfo(info)) {
            this.info = info;
        }
    }

    @Override
    public boolean equals(Object o) {
        boolean testOK = false;
        if (o instanceof Dependencia) {
            Dependencia p = (Dependencia) o;
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
        hash = 43 * hash + this.id;
        hash = 43 * hash + Objects.hashCode(this.nombre);
        hash = 43 * hash + Objects.hashCode(this.info);
        return hash;
    }

}
