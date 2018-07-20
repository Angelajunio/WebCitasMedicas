<%-- 
    Document   : delete
    Created on : 18-jul-2018, 7:25:57
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
       <h1>Desea eliminar la cita ${cita.getCitaid()}?</h1>
        <hr/>
            <fieldset>
                <label>Fecha:</label>
                <span>  ${cita.getFechaDesc()}</span>
                <br>
                <label>Paciente:</label>
                <span> ${cita.getPacienteid().getNombres()}</span>
                <br>
                <label>Medico:</label>
                <span> ${cita.getMedicoid().getNombres()}</span>
                <br>
                <label>Hora:</label>
                <span> ${cita.getHora()} </span>
               <br>
               <label>Dia:</label>
                <span>   ${cita.getDia()}  </span>
               <br>
                <label>Observacion:</label>
                <span>${cita.getObservacion()}</span>
                 <br>
                <label>Realizada:</label>
                <span>${cita.getRealizada()}</span>
            </fieldset>
    <frm:form action="${pageContext.request.contextPath}/cita/delete.htm" 
        method="POST" commandName="cita"> 
        <frm:hidden path="citaid"/>
        <div>
            <a href="${pageContext.request.contextPath}/cita/list.htm">Cancelar</a>
                    <button type="submit">Eliminar</button>
        </div>
    </frm:form>

    </body>
</html>
