<%-- 
    Document   : update
    Created on : 13-jul-2018, 11:10:17
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/container/css/bootstrap.min.css"/>" rel="stylesheet">
       <title>Editar Paciente</title>
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
        <h1>Editar Paciente</h1>
        <hr/>
            </div>
        </div> 
        <hr>
        <frm:form action="${pageContext.request.contextPath}/paciente/update.htm" method="POST" commandName="paciente">
            <fieldset>
                <label>C&eacute;dula: </label>
                <frm:input path="cedula" 
                           value="${paciente.getCedula()}"
                           placeholder="Ingrese la cédula del paciente"></frm:input>
                    <br>
                    <label>Nombres: </label>
                <frm:input path="nombres" 
                           value="${paciente.getNombres()}"
                           placeholder="Ingrese el nombre del paciente"></frm:input>
                    <br>
                    <label>Apellidos: </label>
                <frm:input path="apellidos" 
                           value="${paciente.getApellidos()}"
                           placeholder="Ingrese el apellido del paciente"></frm:input>
                    <br>
                    <label>Fecha de Nacimiento: </label>
                <frm:input type="date" path="strFecha" 
                           value="${paciente.getFechaMostrar()}"
                           placeholder="yyyy/MM/dd"></frm:input>
                    <br>
                    <label>Estatura: </label>
                <frm:input path="estatura" 
                           value="${paciente.getEstatura()}"
                           placeholder="Ingrese la estatura del paciente" min="100" max="230"></frm:input>
                    <br>
                    <label>Peso: </label>
                <frm:input path="peso" 
                           value="${paciente.getPeso()}"
                           placeholder="Ingrese el peso del paciente" min="30" max="330"></frm:input>
                <br>
                    <label>Telefono: </label>
                    <frm:input path="telefono" 
                           value="${paciente.getTelefono()}"
                           placeholder="Ingrese el numero telefonico" min="30" max="330"></frm:input>
                    <br>
                    <label>Observaciones: </label>
                    <frm:input path="observaciones" 
                           value="${paciente.getObservaciones()}"
                           placeholder="Ingrese una Observacion"></frm:input>
                
                           
                           <frm:hidden path="pacienteid" 
                            value="${paciente.getPacienteid()}"></frm:hidden>
                    <div>
                       
                            <a href="${pageContext.request.contextPath}/paciente/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
                    
                    <button type="submit">Actualizar</button>
                </div>
            </fieldset>
        </frm:form>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="<c:url value="/container/js/bootstrap.min.js"/>"></script>
    </body>

</html>
