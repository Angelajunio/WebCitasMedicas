<%-- 
    Document   : update
    Created on : 13-jul-2018, 12:04:31
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Medico</title>
    </head>
    <body>
        <h1>Actualizar Medico</h1>
        <hr>
        <frm:form action="${pageContext.request.contextPath}/medico/update.htm" method="POST" commandName="medico">
            <fieldset>
                <label>Apellidos:</label>
                <span> ${medico.getApellidos()}</span>
                <br>
                <label>Correo:</label>
                <span> ${medico.getCorreo()}</span>
                <br>
                    <label>Especialidad:</label>
                <span>${medico.getEspecialidadId().getNombre()}</span>
                <br>
                <label>Horario:</label>
                <span>${medico.getHorarioId().getHorainicial()}</span>
                <br>
                
                
                <frm:hidden path="medicoId"></frm:hidden>
                <frm:hidden path="idespecialidad"></frm:hidden>
                <frm:hidden path="idhorario"></frm:hidden>
                <button type="reset">
                    <a href="${pageContext.request.contextPath}/medico/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
                </button>
                <button type="submit">Guardar</button>
            </div>
        </fieldset>
    </frm:form>
</body>
</html>
