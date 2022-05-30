/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.bll.commands.usuario;

import org.japo.java.bll.commands.visita.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.japo.java.bll.commands.Command;
import org.japo.java.dll.usuario.DLLUsuario;
import org.japo.java.dll.perfil.DLLPerfil;
import org.japo.java.entities.Perfil;
import org.japo.java.entities.Usuarios;
import org.japo.java.libraries.UtilesUsuarios;

/**
 *
 * @author Sergio García Trincado - elfragger@gmail.com
 */
public class CommandUsuarioModificacion extends Command {

    @Override
    public void process() throws ServletException, IOException {

        // Nombre de la Pagina de Salida
        String out;

        try {
            // Obtener ID Categorias requerido
            int id = Integer.parseInt(request.getParameter("id"));
        
            // Obtener Operación
            String op = request.getParameter("op");
            
            Usuarios u;

            switch (op) {
                // Invoca Formulario de Captura de Datos
                case "captura":
                
                    // Capas de Datos
                    DLLUsuario dllUsuario = new DLLUsuario(config);
                
                    // ID > Categorias a Modificar
                    u = dllUsuario.obtenerUsuariosID(id);

                    request.setAttribute("usuarios", u);
                    out = "usuario/usuario-modificacion";
                    break;
                
                // Datos Petición > Base de Datos + Respuesta    
                case "proceso":
                    // Hacer proceso
                    out = modificarDatosFormulario();
                    break;
                default:
                    // Page404
                    out = "message/operacion-desconocida";
            }
        
        } catch (Exception e) {
            // Recurso Inexistente
            out = "message/operacion-desconocida";
        }

        forward(out);
    }

    private String modificarDatosFormulario() {
        // Página de Retorno
        String out;

        try {
            // Obtener Parametros
            int id = Integer.parseInt(request.getParameter("id"));
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String avatar = request.getParameter("avatar");
            int perfil = Integer.parseInt(request.getParameter("perfil"));
            
            // Instanciar Categorias
            Usuarios u = new Usuarios(id, user, pass, avatar, perfil);

            // Capas de Datos
            DLLUsuario dllUsuario = new DLLUsuario(config);
            
            // Formulario > Usuario Insertado 
            boolean insertadoOK = dllUsuario.modificar(u);
            
            // Validar
            if (insertadoOK) {
                out = "main/main-admin";
            } else {
                out = "message/operacion-desconocida";
            }
        } catch (Exception e) {
            out = "message/operacion-desconocida";
        }

        return out;
    }

}
