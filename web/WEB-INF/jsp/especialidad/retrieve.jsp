<%-- 
    Document   : retrieve
    Created on : 13-jul-2018, 15:19:51
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Datos Paciente</title>
    </head>
    <body>
        <h1>Datos del paciente ${especialidad.getNombre()}</h1>
        <hr>
        <fieldset>
            <label>Nombre: </label>
            <span>${especialidad.getNombre()}</span>
            <br>
            <label>Descripcion: </label>
            <span>${especialidad.getDescripcion()}</span>
            <br>
         
        </fieldset>
        <button type="reset">
            <a href="${pageContext.request.contextPath}/especialidad/list.htm" style="text-decoration: none; color: black"/>Atr&aacute;s</a>
    </button>
</body>
</html>
