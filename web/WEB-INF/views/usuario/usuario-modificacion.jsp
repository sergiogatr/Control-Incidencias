<%-- 
    Document   : visita-landing
    Created on : 22 mar. 2022, 10:25:48
    Author     : Sergio García Trincado - elfragger@gmail.com
--%>

<%@page import="org.japo.java.entities.Perfil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.japo.java.libraries.UtilesUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
        // Obtener Usuarios
        List<Perfil> listaPrf = (ArrayList<Perfil>) request.getAttribute("lista-perfiles");
    %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario | Modificación</title>
        <link rel="stylesheet" href="public/css/usuario/usuario-insercion.css"/>
        <link rel="stylesheet" href="public/css/partials/header.css"/>
        <link rel="stylesheet" href="public/css/partials/footer.css"/>
        <link rel="icon" type="image/ico" href="public/img/favicon.ico"/>
    </head>
    <body>
        <%@include file="../partials/header.jspf" %>
        <div id="container">
            
            
            
            <h1>Insertar</h1>
            <form action="?cmd=usuario-insercion&op=proceso" method="post" accept-charset="ISO-8859-1">
                <div class="fieldset">
                   <label for="id">Id</label>
                   <input type="number" id="id" name="id"> 
                </div>
                <div class="fieldset">
                   <label for="user">User</label>
                   <input type="text" id="user" name="user" pattern="<%= UtilesUsuarios.REG_USER %>"> 
                </div>
                <div class="fieldset">
                    <label for="pass">Password</label>
                    <input type="password" id="pass" name="pass" pattern="<%= UtilesUsuarios.REG_PASS %>" value="123456">  
                </div>
                <div class="fieldset">
                   <label for="avatar">Avatar</label>
                   <input type="text" id="avatar" name="avatar" value="data:image/jpeg;base64,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"> 
                </div>
                <div class="fieldset">
                    <label for="perfil">Perfil</label>
                    <select name="perfil">
                        <% for (Perfil p : listaPrf) {%>
                        <option value="<%= p.getId()%>"><%= p.getInfo()%></option>
                        <% }%>
                    </select>
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
