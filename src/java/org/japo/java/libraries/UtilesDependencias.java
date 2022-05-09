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
public final class UtilesDependencias {

    // Valores por Defecto
    public static final int DEF_ID = 0;
    public static final String DEF_NOMBRE = "Indefinido";
    public static final String DEF_INFO = "No se, no esta Carlos Baute";
    public static final String DEF_CODIGO = "Código Base";

    // Expresiones Regulares ( Validación )
    public static final String REG_NOMBRE = "[\\w]{3,30}";
    public static final String REG_INFO = "[\\w áéíóúüñçÁÉÍÓÚÜÑÇ]{3,100}";
    public static final String REG_CODIGO = "[\\w áéíóúüñçÁÉÍÓÚÜÑÇ]{3,10}";

    private UtilesDependencias() {

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
    
    public static final boolean validarCodigo(String codigo) {
        return codigo.matches(REG_CODIGO);
    }

}
