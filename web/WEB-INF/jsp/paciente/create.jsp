<%-- 
    Document   : create
    Created on : 13-jul-2018, 9:13:39
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
        <title>Registrar Paciente</title>
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
        <h1>Registrar Paciente</h1>
        <hr>
        </div>
        </div>
        <frm:form action="${pageContext.request.contextPath}/paciente/create.htm" method="POST" commandName="paciente">
            <fieldset>
                <label>C&eacute;dula: </label>
                <frm:input path="cedula" />   
                <small id="cedulaHelp" class="form-text text-muted">Ingrese la cédula del paciente</small><br>
                <frm:errors path="cedula" /> 
                <label>Nombres: </label>
                <frm:input path="nombres" />
                <small id="nombresHelp" class="form-text text-muted">Ingrese el nombre  paciente</small><br>
                <frm:errors path="nombres" /> 
                <label>Apellidos: </label>
                <frm:input path="apellidos"/>
                <small id="apellidosHelp" class="form-text text-muted">Ingrese el apellido paciente</small><br>    
                <frm:errors path="apellidos" /> 
                <br>
                    <label>Fecha de Nacimiento: </label>
                <frm:input type="date" path="strFecha" placeholder="yyyy/MM/dd"></frm:input>
                <frm:errors path="strFecha" />     
                <br>
                    <label>Estatura: </label>
                <frm:input path="estatura"  min="100" max="230"></frm:input>
                <small id="estaturaHelp" class="form-text text-muted">Ingrese la estatura del paciente</small><br>   
                <frm:errors path="estatura" /> 
                <br>
                    <label>Peso: </label>
                <frm:input path="peso" min="30" max="330"></frm:input>
                  <small id="pesoHelp" class="form-text text-muted">Ingrese el peso del paciente</small><br>   
                   <frm:errors path="peso" /> 
                   <br>
                <label>Telefono: </label>
                <frm:input path="telefono"   max="10"></frm:input>
                <small id="telefonoHelp" class="form-text text-muted">Ingrese # telefono</small><br>    
                <frm:errors path="telefono" /> 
                <br>
                <label>Observaciones: </label>
                <frm:input path="observaciones" />
                <small id="observacionHelp" class="form-text text-muted">Ingrese una Observacion</small><br>  
               <frm:errors path="observaciones" /> 
                <br>
                <div>
                        
                            <a href="${pageContext.request.contextPath}/paciente/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
                            <button type="submit">Guardar</button>
       
                </div>
            </fieldset>
        </frm:form>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="<c:url value="/container/js/bootstrap.min.js"/>"></script>
    </body>

</html>
