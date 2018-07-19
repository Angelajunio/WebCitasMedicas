<%-- 
    Document   : update
    Created on : 13-jul-2018, 15:19:34
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Editar Especialidad</title>
    </head>
    <body>
        <h1>Editar Especialidad</h1>
        <hr>
        <frm:form action="${pageContext.request.contextPath}/especialidad/update.htm" method="POST" commandName="especialidad">
            <fieldset>
              
                    <label>Nombre Especialidad: </label>
                <frm:input path="nombre" 
                           value="${especialidad.getNombre()}"
                           placeholder="Ingrese el nombre de la especialidad"></frm:input>
                    <br>
                    <label>Descripcion: </label>
                <frm:input path="descripcion" 
                           value="${especialidad.getDescripcion()}"
                           placeholder="Ingrese una descripcion"></frm:input>
                   
                           <frm:hidden path="especialidadid" 
                            value="${especialidad.getEspecialidadid()}"></frm:hidden>
                    <div>
                       
                            <a href="${pageContext.request.contextPath}/especialidad/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
                    
                    <button type="submit">Actualizar</button>
                </div>
            </fieldset>
        </frm:form>
    </body>
</html>
