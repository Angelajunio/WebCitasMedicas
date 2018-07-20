<%-- 
    Document   : retrieve
    Created on : 13-jul-2018, 12:05:00
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Datos medico</title>
    </head>
    <body>
        <h1>Datos del medico ${medico.getNombres()}</h1>
        <hr>
        <fieldset>
        
            <label>Apellidos:</label>
                <span> ${medico.getApellidos()}</span>
                <br>
                <label>Correo:</label>
                <span> ${medico.getCorreo()}</span>
                <br>
                <label>Especialidad:</label>
                <span>${medico.getEspecialidadid().getNombre()}</span>
                <br>
                <label>Horario:</label>
                <span>${medico.getHorarioid().getHorainicial()}</span>
                <br>
         
        </fieldset>
        <button type="reset">
            <a href="${pageContext.request.contextPath}/medico/list.htm" style="text-decoration: none; color: black"/>Atr&aacute;s</a>
    </button>
</body>
</html>
