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
public final class UtilesNotificaciones {

    // Valores por Defecto
    public static final int DEF_ID = 0;
    public static final Date DEF_FECHA = new Date();
    public static final int DEF_AUTOR = UtilesUsuarios.DEF_ID;
    public static final int DEF_INCIDENCIA = UtilesIncidencias.DEF_ID;
    public static final String DEF_INFO = "Notifiacación Indefinida";

    // Expresiones Regulares ( Validación )
    public static final String REG_INFO = "[\\w áéíóúüñçÁÉÍÓÚÜÑÇ]{3,255}";

    private UtilesNotificaciones() {

    }

    public static final boolean validarId(int id) {
        return id >= DEF_ID;
    }

    public static final boolean validarFecha(Date fecha) {
        return fecha != null;
    }

    public static final boolean validarInfo(String info) {
        return info.matches(REG_INFO);
    }

}
