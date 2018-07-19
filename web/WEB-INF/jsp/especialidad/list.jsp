<%-- 
    Document   : list
    Created on : 13-jul-2018, 14:38:50
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Especialidad</title>
    </head>
    <body>
        <h1>Listado de Especialidad</h1>
        <hr>
        <table border="1">
            <thead>
                <tr>
                    <th>Nombre:</th>
                    <th>Descripcion:</th>
                        
                    <th>
                        <a href="${pageContext.request.contextPath}/especialidad/create.htm">Crear</a>
                    </th>
                    <!--Completar resto de datos-->
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.especialidades}" var="m">
                    <tr>
                        <td>
                            ${m.getNombre()}
                        </td>
                        <td>
                            ${m.getDescripcion()}
                        </td>
  
                        
                        <td>
                            <a href="${pageContext.request.contextPath}/especialidad/retrieve/${m.getEspecialidadid()}.htm">Ver</a> |
                            <a href="${pageContext.request.contextPath}/especialidad/update/${m.getEspecialidadid()}.htm">Editar</a> |
                            <a href="${pageContext.request.contextPath}/especialidad/delete/${m.getEspecialidadid()}.htm">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button type="reset">
            <a href="${pageContext.request.contextPath}/index.htm" style="text-decoration: none; color: black">Atr&aacute;s</a>
        </button>
    </body>       

</html>
