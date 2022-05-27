/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.bll.commands.usuario;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;
import org.japo.java.entities.Usuario;
import org.japo.java.libraries.UtilesPerfiles;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
final class CommandUsuarioValidation {

    CommandUsuarioValidation(ServletConfig config, HttpSession session) {
    }

    boolean validarAccesoAdmin(HttpSession sesion) {
        
        // Semáforo
        boolean checkOK;
        
        try {
            // Sesión > Usuario
            Usuario usuario = (Usuario) sesion.getAttribute("usuario");
            
            // Usuario > Perfil
            int perfil = usuario.getPerfil();
            
            // Validar Perfil Admin
            checkOK = perfil >= UtilesPerfiles.ADMIN_CODE;
        } catch (NullPointerException e) {
            checkOK = false;
        }
        
        // Rertorno: true | false
        return checkOK;
    }
    
}
