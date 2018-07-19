<%-- 
    Document   : update
    Created on : 18-jul-2018, 7:26:44
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <label>Observaci&oacute;n: </label>
                <frm:textarea path="observacion"></frm:textarea>
                    <br>
                    <label>Duraci&oacute;n</label>
                <frm:input path="duracion" type="number" min="5"></frm:input>
                <br>
                <label>Realizada</label>
                <frm:checkbox path="realizada"></frm:checkbox>
                
                <frm:hidden path="citaId"></frm:hidden>
                <frm:hidden path="strFecha"></frm:hidden>
                <frm:hidden path="idmedico"></frm:hidden>
                <frm:hidden path="idpaciente"></frm:hidden>
                <button type="reset">
                    <a href="${pageContext.request.contextPath}/terapia/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
                </button>
                <button type="submit">Guardar</button>
            </div>
        </fieldset>
    </frm:form>
</body>
</html>
