<%-- 
    Document   : visita-landing
    Created on : 22 mar. 2022, 10:25:48
    Author     : Sergio García Trincado - elfragger@gmail.com
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.japo.java.entities.Usuario"%>
<%@page import="org.japo.java.libraries.UtilesUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

 Usuario d = (Usuario) request.getAttribute("usuarios");

%>
        
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario | Consulta <%= d.getUser()%></title>
        <link rel="stylesheet" href="public/css/usuario/usuario-consulta.css"/>
        <link rel="stylesheet" href="public/css/partials/header.css"/>
        <link rel="stylesheet" href="public/css/partials/footer.css"/>
        <link rel="icon" type="image/ico" href="public/img/favicon.ico"/>
    </head>
    <body>
        <%@include file="../partials/header.jspf" %>
        
        <div class="container" id="container">
        
            <div id="ficha">
            
                <div class="ficha">
                    <img alt="avatar" src="<%= d.getAvatar()%>"/>
                    <p class="id"><%= d.getId()%></p>
                    <p class="id"><%= d.getUser()%></p>
                    <p class="id"><%= d.getPerfilInfo()%></p> 
                    <a href="?cmd=usuario-modificacion&op=captura&id=<%= d.getId()%>">Modificar</a>
                    <a href="?cmd=usuario-borrado&user=<%= d.getUser()%>">Borrar</a>
                </div>
                
            </div>          
            
        </div>
        
        <%@include file="../partials/footer.jspf" %>
    </body>
</html>
