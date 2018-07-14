<%-- 
    Document   : retrieve
    Created on : 13-jul-2018, 11:10:43
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
        <h1>Datos del paciente ${paciente.getNombres()}</h1>
        <hr>
        <fieldset>
            <label>C&eacute;dula: </label>
            <span>${paciente.getCedula()}</span>
             <br>
            <label>Apellidos: </label>
            <span>${paciente.getApellidos()}</span>
            <br>
            <label>Fecha de nacimiento: </label>
            <span>${paciente.getFechaMostrar()}</span>
            <br>
            <label>Estatura: </label>
            <span>${paciente.getEstatura()}</span>
            <br>
            <label>Peso: </label>
            <span>${paciente.getPeso()}</span>
             <br>
            <label>Telefono: </label>
            <span>${paciente.getTelefono()}</span>
             <br>
            <label>Observaciones: </label>
            <span>${paciente.getObservaciones()}</span>
        </fieldset>
        <button type="reset">
            <a href="${pageContext.request.contextPath}/paciente/list.htm" style="text-decoration: none; color: black"/>Atr&aacute;s</a>
    </button>
</body>
</html>
