/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public final class UtilesEspecialidades {

    // Valores por Defecto
    public static final int DEF_ID = 0;
    public static final String DEF_NOMBRE = "Indefinida";
    public static final String DEF_INFO = "Especialidad Indefinida";

    // Expresiones Regulares ( Validación )
    public static final String REG_NOMBRE = "[\\w áéíóúüñçÁÉÍÓÚÜÑÇ]{3,50}";
    public static final String REG_INFO = "[\\w áéíóúüñçÁÉÍÓÚÜÑÇ]{3,255}";

    private UtilesEspecialidades() {

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

}
