/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.bll.commands.usuario;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import org.japo.java.bll.commands.Command;
import org.japo.java.dll.usuario.DLLUsuario;
import org.japo.java.entities.Usuario;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public class CommandUsuarioConsulta extends Command {

    @Override
    public void process() throws ServletException, IOException {

        // Salida
        String out = "usuario/usuario-consulta";
        
        // Validar Sesión
        if (validarSesion(request)) {
            
            // Validar Acceso
            CommandUsuarioValidation validator = new CommandUsuarioValidation(
            config, request.getSession(false));
            
            if (validator.validarAccesoAdmin(request.getSession(false))) {
                // Capas de Datos
                DLLUsuario dllUsuario = new DLLUsuario(config);
                
                // Extraer ID
                String user = request.getParameter("user");
            
                // ID > Datos Usuario
                Usuario datos = dllUsuario.consultar(user);
                
                // Inyecta Datos > JSP
                request.setAttribute("usuarios", datos);
            
            } else {
                out = "message/acceso-denegado";
            }
            
        } else {
            out = "message/acceso-denegado";
        }
        
        // Redirección
        forward(out);
    }
}
