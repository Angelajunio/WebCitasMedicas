<%-- 
    Document   : list
    Created on : 17-jul-2018, 23:54:18
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Citas</title>
    </head>
    <body>
        <h1>Listado de Citas</h1>
        <hr>
        <table>
            <thead>
                <tr>
                    <th>Fecha</th>
                    <th>Paciente</th>
                    <th>Medico</th>
                    <th>Hora</th>
                    <th>Dia</th>
                    <th>Observacion</th>
                    <th>Realizada</th>
                    <th>
                        <a href="${pageContext.request.contextPath}/cita/create.htm">Crear</a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.citas}" var="t">
                    <tr>
                        <td>
                            ${t.getFechaDesc()}
                        </td>
                        <td>
                            ${t.getPacienteId().getNombre()}
                        </td>
                        <td>
                            ${t.getMedicoId().getNombre()}
                        </td>
                        <td>
                            ${t.getHora()} 
                        </td>
                        <td>
                            ${t.getDia()} 
                        </td>
                        <td>
                            ${t.getObservacion()}
                        </td>
                         <td>
                            ${t.getRealizada()}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cita/retrieve/${p.getCitaid()}.htm">Ver</a> |
                            <a href="${pageContext.request.contextPath}/cita/delete/${p.getCitaid()}.htm">Eliminar</a>
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
