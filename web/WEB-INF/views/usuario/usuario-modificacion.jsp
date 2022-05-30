<%-- 
    Document   : visita-landing
    Created on : 22 mar. 2022, 10:25:48
    Author     : Sergio García Trincado - elfragger@gmail.com
--%>

<%@page import="org.japo.java.entities.Usuarios"%>
<%@page import="org.japo.java.entities.Perfil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.japo.java.libraries.UtilesUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
        // Obtener Productos
        Usuarios u = (Usuarios) request.getAttribute("usuarios");
    %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario | Modificación</title>
        <link rel="stylesheet" href="public/css/usuario/usuario-modificacion.css"/>
        <link rel="stylesheet" href="public/css/partials/header.css"/>
        <link rel="stylesheet" href="public/css/partials/footer.css"/>
        <link rel="icon" type="image/ico" href="public/img/favicon.ico"/>
    </head>
    <body>
        <%@include file="../partials/header.jspf" %>
        <div id="container">
            
            
            
            <h1>Modificar</h1>
            <form action="?cmd=usuario-modificacion&op=proceso&id=<%= u.getId()%>" method="post" accept-charset="ISO-8859-1">
                <div class="fieldset">
                   <label for="user">User</label>
                   <input type="text" id="user" name="user" pattern="<%= UtilesUsuarios.REG_USER %>" value="<%= u.getUser()%>"> 
                </div>
                <div class="fieldset">
                    <label for="pass">Password</label>
                    <input type="password" id="pass" name="pass" pattern="<%= UtilesUsuarios.REG_PASS %>" value="<%= u.getPass()%>">  
                </div>
                <div class="fieldset">
                   <label for="avatar">Avatar</label>
                   <input type="text" id="avatar" name="avatar" value="<%= u.getAvatar()%>"> 
                </div>
                <div class="fieldset">
                    <label for="perfil">Perfil</label>
                    <input type="number" id="perfil" name="perfil" value="<%= u.getPerfil()%>">
                </div>
                <div class="buttonset">
                    <input type="submit" value="Enviar">
                    <input type="reset" value="Restaurar">
                </div>
            </form>
        </div>
        <%@include file="../partials/footer.jspf" %>
    </body>
</html>
