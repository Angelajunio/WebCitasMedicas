<%-- 
    Document   : list
    Created on : 14-jul-2018, 13:31:25
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Horario</title>
    </head>
    <body>
        <h1>Listado de horario</h1>
        <hr>
        <table border="1">
            <thead>
                <tr>
                    <th>Dias</th>
                    <th>Hora Inicial</th>
                    <th>Hora Final</th>
                   
                    <th>
                        <a href="${pageContext.request.contextPath}/horario/create.htm">Crear</a>
                    </th>
                    <!--Completar resto de datos-->
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.horarios}" var="m">
                    <tr>
                        <td>
                            ${m.getDias()}
                        </td>
                        <td>
                            ${m.getHorainicial()}
                        </td>
                        <td>
                            ${m.getHorafinal()}
                        </td>
                        
                        <td>
                            <a href="${pageContext.request.contextPath}/horario/retrieve/${m.getHorarioid()}.htm">Ver</a> |
                            <a href="${pageContext.request.contextPath}/horario/update/${m.getHorarioid()}.htm">Editar</a> |
                            <a href="${pageContext.request.contextPath}/horario/delete/${m.getHorarioid()}.htm">Eliminar</a>
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
