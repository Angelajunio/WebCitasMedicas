<%-- 
    Document   : update
    Created on : 18-jul-2018, 7:26:44
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Actualizar Cita</title>
    </head>
    <body>
        <h1>Actualizar Cita</h1>
        <hr>
        <frm:form action="${pageContext.request.contextPath}/cita/update.htm" method="POST" commandName="cita">
            <fieldset>
                <label>Fecha: </label>
                <span>${cita.getFechaDesc()}</span>
                    <br>
                    <label>Paciente: </label>
                    <span>${cita.getPacienteId().getNombre()}</span>
                <br>
                <label>Hora: </label>
                <frm:input path="hora" 
                           value="${cita.getHora()}"
                           placeholder="Ingrese la hora "></frm:input>
                    <br>
                    <label>Dia:</label>
                <frm:input path="dia" 
                           value="${cita.getDia()}"
                           placeholder="Ingrese el dia"></frm:input>
                <br>
                <label>Observacion</label>
                 <frm:input path="observaciones" 
                           value="${cita.getObservacion()}"
                           placeholder="Ingrese una Observacion"></frm:input>
                <br>
                <label>Realizada</label>
                <frm:checkbox path="realizada"></frm:checkbox>
                
                <frm:hidden path="citaId"></frm:hidden>
                <frm:hidden path="strFecha"></frm:hidden>
                <frm:hidden path="idmedico"></frm:hidden>
                <frm:hidden path="idpaciente"></frm:hidden>
                <frm:hidden path="observacion"></frm:hidden>
                <frm:hidden path="hora"></frm:hidden>
                 <frm:hidden path="dia"></frm:hidden>
                <frm:hidden path="realizada"></frm:hidden>
                <button type="reset">
                    <a href="${pageContext.request.contextPath}/cita/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
                </button>
                <button type="submit">Guardar</button>
            </div>
        </fieldset>
    </frm:form>
</body>
</html>
