/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.bll.commands.usuario;

import org.japo.java.bll.commands.visita.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.japo.java.bll.commands.Command;
import org.japo.java.dll.usuario.DLLUsuario;
import org.japo.java.entities.Usuario;
import org.japo.java.libraries.UtilesUsuarios;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public class CommandUsuarioLogout extends Command {

    @Override
    public void process() throws ServletException, IOException {

        // Salida
        String out = "controller?cmd=usuario-login";
        
        // Validar Usuario YA Identificado
        if (validarSesion(request)) {
            
            // Request > Session
            HttpSession sesion = request.getSession(false);
            
            // Cerrar Session Actual
            sesion.invalidate();
            
        }

        // Redirección
        forward(out);

    }

}
