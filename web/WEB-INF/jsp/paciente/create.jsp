<%-- 
    Document   : create
    Created on : 13-jul-2018, 9:13:39
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Paciente</title>
    </head>
    <body>
        <h1>Registrar Paciente</h1>
        <hr>
        <frm:form action="${pageContext.request.contextPath}/paciente/create.htm" method="POST" commandName="paciente">
            <fieldset>
                <label>C&eacute;dula: </label>
                <frm:input path="cedula" placeholder="Ingrese la cédula del paciente"></frm:input>
                    <br>
                    <label>Nombres: </label>
                <frm:input path="nombres" placeholder="Ingrese el nombre del paciente"></frm:input>
                <label>Apellidos: </label>
                 <br>
                <frm:input path="apellidos" placeholder="Ingrese el nombre del paciente"></frm:input>
                    <br>
                    <label>Fecha de Nacimiento: </label>
                <frm:input type="date" path="strFecha" placeholder="yyyy/MM/dd"></frm:input>
                    <br>
                    <label>Estatura: </label>
                <frm:input path="estatura" placeholder="Ingrese la estatura del paciente" min="100" max="230"></frm:input>
                    <br>
                    <label>Peso: </label>
                <frm:input path="peso" placeholder="Ingrese el peso del paciente" min="30" max="330"></frm:input>
                 <br>    
                <label>Telefono: </label>
                <frm:input path="telefono" placeholder="Ingrese # telefono"  max="10"></frm:input>
                 <br>
                <label>Observaciones: </label>
                <frm:input path="observaciones" placeholder="Ingrese una Observacion"></frm:input>
                    <br>
                <div>
                        
                            <a href="${pageContext.request.contextPath}/paciente/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
                            <button type="submit">Guardar</button>
       
                </div>
            </fieldset>
        </frm:form>
    </body>

</html>
