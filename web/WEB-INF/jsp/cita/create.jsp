<%-- 
    Document   : create
    Created on : 18-jul-2018, 7:25:36
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Registrar Citas</title>
    </head>
    <body>
        <h1>Registrar Cita</h1>
        <hr>
        <frm:form action="${pageContext.request.contextPath}/cita/create.htm" method="POST" commandName="cita">
            <fieldset>
                <label>Fecha: </label>
                <frm:input type="date" path="strFecha"></frm:input>
                    <br>
                    <label>Paciente: </label>
                <frm:select path="idpaciente"> <%--Terapia--%>
                    <frm:option value="0" label="--Seleccione--"/>
                    <frm:options items="${listPaciente}"
                                 itemLabel="nombre"
                                 itemValue="pacienteId"/> <%--Paciente--%>
                </frm:select>
                <br>
                <label>M&eacute;dico: </label>
                <frm:select path="idmedico"> <%--Terapia--%>
                    <frm:option value="0" label="--Seleccione--"/>
                    <frm:options items="${listMedico}"
                                 itemLabel="nombre"
                                 itemValue="medicoId"/> <%--Paciente--%>
                </frm:select>
                <br>
                 <label>Hora: </label>
                <frm:input path="hora" placeholder="Ingrese la hora"></frm:input>
                    <br>
                   <label>Dia: </label>
                <frm:input path="dia" placeholder="Ingrese el dia"></frm:input>
                <br>
                <label>Observacion: </label>
                <frm:input path="observacion" placeholder="Ingrese una observacion"></frm:input>
                    <br>
                    <label>Realizada: </label>
                <frm:input path="realizada" placeholder="Ingrese si se realizo o no"></frm:input>
                    <br>
                <button type="reset">
                    <a href="${pageContext.request.contextPath}/cita/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
                </button>
                <button type="submit">Guardar</button>
            </div>
        </fieldset>
    </frm:form>
</body>
</html>
