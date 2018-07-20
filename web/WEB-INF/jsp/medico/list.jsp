<%-- 
    Document   : list
    Created on : 13-jul-2018, 12:03:15
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/container/css/bootstrap.min.css"/>" rel="stylesheet">
        <title>Medico</title>
    </head>
    <body>
         <div class="jumbotron">
            <div class="container">
        <h1>Listado de medico</h1>
         </div>
        </div>
        <hr>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Correo</th>
                     <th>Especialidad</th>
                     <th>Horario</th>                   
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
                            ${m.getNombres()}
                        </td>
                        <td>
                            ${m.getApellidos()}
                        </td>
                        <td>
                            ${m.getCorreo()}
                        </td>
                        <td>
                            ${m.getEspecialidadid().getNombre()}
                        </td>
                        <td>
                            ${m.getHorarioid().getHorainicial()}
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
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="<c:url value="/container/js/bootstrap.min.js"/>"></script>
    </body>
</html>
