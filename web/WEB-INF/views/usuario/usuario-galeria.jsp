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
    // Datos Inyectados
    List<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario | Galería</title>
        <link rel="stylesheet" href="public/css/usuario/usuario-galeria.css"/>
        <link rel="stylesheet" href="public/css/partials/header.css"/>
        <link rel="stylesheet" href="public/css/partials/footer.css"/>
        <link rel="icon" type="image/ico" href="public/img/favicon.ico"/>
    </head>
    <body>
        <%@include file="../partials/header.jspf" %>
        
        <div class="galeria">
        
            <% for (Usuario u : usuarios) { %>
        
            <div href="?cmd=usuario-consulta&id=<%= u.getId() %>" class="galeria">
            
                <a class="ficha">
                    <img src="<%= u.getAvatar() %>" alt="avatar"/>
                    <p class="id"><%= u.getId() %></p>
                    <p class="id"><%= u.getUser() %></p>
                    <p class="id"><%= u.getPerfilInfo() %></p>
                </a>
            
            <% }%>
            
            </div>
            
        </div>
        
        <%@include file="../partials/footer.jspf" %>
    </body>
</html>
