<%-- 
    Document   : delete
    Created on : 13-jul-2018, 12:04:11
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Desea eliminar al medico ${medico.getNombres()}</h1>
        <hr/>
            <fieldset>
                <label>Apellidos:</label>
                <span> ${m.getApellidos()}</span>
                <br>
                <label>Correo:</label>
                <span> ${m.getCorreo()}</span>
                <br>
                <label>Especialidad:</label>
                <span>${m.getEspecialidadId().getNombre()}</span>
                <br>
                <label>Horario:</label>
                <span>${m.getHorarioId().getHorainicial()}</span>
                <br>
                
            </fieldset>
    <frm:form action="${pageContext.request.contextPath}/medico/delete.htm" 
        method="POST" commandName="medico"> 
        <frm:hidden path="medicoId"/>
        <div>
            <a href="${pageContext.request.contextPath}/medico/list.htm">Cancelar</a>
                    <button type="submit">Eliminar</button>
        </div>
    </frm:form>

    </body>
</html>
