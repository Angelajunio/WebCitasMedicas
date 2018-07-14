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
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Listado de Especialidades</h1>
        <hr>
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    
                    <th>
                        <a href="${pageContext.request.contextPath}/especialidad/create.htm">Crear</a>
                    </th>
                    <!--completar con otros datos-->
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.especialidades}" var="p">
                    <tr>
                       
                        <td>
                            ${p.getNombre()}
                        </td>
                        <td>
                            ${p.getDescripcion()}
                        </td>
                        
                        <td>
                            <a href="${pageContext.request.contextPath}/especialidad/retrieve/${p.getEspecialidadid()}.htm">Ver</a> |
                            <a href="${pageContext.request.contextPath}/especialidad/update/${p.getEspecialidadid()}.htm">Editar</a> |
                            <a href="${pageContext.request.contextPath}/especialidad/delete/${p.getEspecialidadid()}.htm">Eliminar</a>
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
