<%-- 
    Document   : list
    Created on : 13-jul-2018, 12:03:15
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medicos</title>
    </head>
    <body>
        <h1>Listado de M&eacute;dicos</h1>
        <hr>
        <table>
            <thead>
                <tr>
                    <th>C&eacute;dula</th>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>C&oacute;digo</th>
                    <th>
                        <a href="${pageContext.request.contextPath}/medico/create.htm">Crear</a>
                    </th>
                    <!--Completar resto de datos-->
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.medicos}" var="m">
                    <tr>
                        <td>
                            ${m.getCedula()}
                        </td>
                        <td>
                            ${m.getNombres()}
                        </td>
                        <td>
                            ${m.getCorreo()}
                        </td>
                        <td>
                            ${m.getCodigo()}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/medico/retrieve/${m.getMedicoid()}.htm">Ver</a> |
                            <a href="${pageContext.request.contextPath}/medico/update/${m.getMedicoid()}.htm">Editar</a> |
                            <a href="${pageContext.request.contextPath}/medico/delete/${m.getMedicoid()}.htm">Eliminar</a>
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
