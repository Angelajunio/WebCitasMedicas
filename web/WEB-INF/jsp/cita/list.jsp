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
        <link href="<c:url value="/container/css/bootstrap.min.css"/>" rel="stylesheet">
       <title>Citas</title>
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
        <h1>Listado de Citas</h1>
        </div>
        </div>
        <hr>
        <table class="table table-striped table-bordered">
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
                <c:forEach items="${requestScope.citas}" var="cita">
                    <tr>
                        <td>
                            ${cita.getFechaDesc()}
                        </td>
                        <td>
                            ${cita.getPacienteid().getNombres()}
                        </td>
                        <td>
                            ${cita.getMedicoid().getNombres()}
                        </td>
                        <td>
                            ${cita.getHora()} 
                        </td>
                        <td>
                            ${cita.getDia()} 
                        </td>
                        <td>
                            ${cita.getObservacion()}
                        </td>
                         <td>
                            ${cita.getRealizada()}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cita/retrieve/${cita.getCitaid()}.htm">Ver</a> 
                            <a href="${pageContext.request.contextPath}/cita/update/${cita.getPacienteid()}.htm">Editar</a> 
                            <a href="${pageContext.request.contextPath}/cita/delete/${cita.getCitaid()}.htm">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button type="reset">
            <a href="${pageContext.request.contextPath}/index.htm" style="text-decoration: none; color: black">Atr&aacute;s</a>
              
        </button>
            <br>
        
            <a href="${pageContext.request.contextPath}/cita/reportturno.htm">Reporte</a>
          
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
            <script src="<c:url value="/container/js/bootstrap.min.js"/>"></script>
    </body>

</html>
