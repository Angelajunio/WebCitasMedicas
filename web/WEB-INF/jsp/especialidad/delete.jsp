
<%-- 
    Document   : delete
    Created on : 13-jul-2018, 15:19:22
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Especialidad</title>
    </head>
    <body>
        <h1>Desea eliminar especialidad ${especialidad.getNombre()}</h1>
        <hr>
        <fieldset>
            <label>Nombre: </label>
            <span>${especialidad.getNombre()}</span>
            <br>
            <label>Descripcion: </label>
            <span>${especialidad.getDescripcion()}</span>
            <br>
            
        </fieldset>
        <frm:form action="${pageContext.request.contextPath}/especialidad/delete.htm" method="POST" commandName="especialidad">
            <frm:hidden path="especialidadid"/>
             <br>
            <div>
               
                    <a href="${pageContext.request.contextPath}/especialidad/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
               
                <button type="submit">Eliminar</button>
            </div>
        </frm:form>
</body>
</html>
