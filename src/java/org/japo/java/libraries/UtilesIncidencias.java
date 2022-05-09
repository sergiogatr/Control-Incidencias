/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public final class UtilesIncidencias {

    // Valores por Defecto
    public static final int DEF_ID = 0;
    public static final String DEF_NOMBRE = "Incidencia";
    public static final String DEF_INFO = "Incidencia Indefinida";
    public static final int DEF_ESTADO = 0;
    public static final Date DEF_CREACION = Date.from(Instant.MIN);
    public static final int DEF_AUTOR = 0;
    public static final int DEF_DEPENDENCIA = 0;
    public static final int DEF_ESPECIALIDAD = 0;
   

    // Expresiones Regulares ( Validación )
    public static final String REG_NOMBRE = "[\\w]{3,30}";
    public static final String REG_INFO = "[\\w áéíóúüñçÁÉÍÓÚÜÑÇ]{3,255}";

    private UtilesIncidencias() {

    }

    public static final boolean validarId(int id) {
        return id >= DEF_ID;
    }
    
    public static final boolean validarNombre(String nombre) {
        return nombre.matches(REG_NOMBRE);
    }

    public static final boolean validarInfo(String info) {
        return info.matches(REG_INFO);
    }
    
    public static final boolean validarEstado(int estado) {
        return estado >= DEF_ESTADO;
    }
    
    public static final boolean validarCreacion(Date creacion) {
        return creacion != DEF_CREACION;
    }
    
    public static final boolean validarAutor(int autor) {
        return autor >= DEF_AUTOR;
    }
    
    public static final boolean validarDependencia(int dependencia) {
        return dependencia >= DEF_DEPENDENCIA;
    }

    public static final boolean validarEspecialidad(int especialidad) {
        return especialidad >= DEF_ESPECIALIDAD;
    }
}
