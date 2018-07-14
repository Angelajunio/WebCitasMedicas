<%-- 
    Document   : create
    Created on : 13-jul-2018, 15:08:23
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Especialidad</title>
    </head>
    <body>
        <h1>Registrar Especialidad</h1>
        <hr>
        <frm:form action="${pageContext.request.contextPath}/especialidad/create.htm" method="POST" commandName="especialidad">
            <fieldset>
                    <label>Nombre: </label>
                <frm:input path="nombre" placeholder="Ingrese el nombre la especialidad"></frm:input>
                <br>
                <label>Descripcion: </label>
                <frm:input path="descripcion" placeholder="Ingrese una descripcion"></frm:input>
                    <br>
                <div>
                        
                            <a href="${pageContext.request.contextPath}/especialidad/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
                            <button type="submit">Guardar</button>
       
                </div>
            </fieldset>
        </frm:form>
    </body>

</html>
