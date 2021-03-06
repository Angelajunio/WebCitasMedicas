<%-- 
    Document   : list
    Created on : 13-jul-2018, 8:57:09
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/container/css/bootstrap.min.css"/>" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
         <h1>Listado de Pacientes</h1>
          </div>
        </div>
        <hr>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>C&eacute;dula</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Estatura</th>
                    <th>Peso</th>
                    <th>Telefono</th>
                    <th>Observaciones</th>
                    <th>
                        <a href="${pageContext.request.contextPath}/paciente/create.htm">Crear</a>
                    </th>
                    <!--completar con otros datos-->
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.pacientes}" var="p">
                    <tr>
                        <td>
                            ${p.getCedula()}
                        </td>
                        <td>
                            ${p.getNombres()}
                        </td>
                        <td>
                            ${p.getApellidos()}
                        </td>
                        <td>
                            ${p.getFechaMostrar()}
                        </td>
                        <td>
                            ${p.getEstatura()}
                        </td>
                        <td>
                            ${p.getPeso()}
                        </td>
                        <td>
                            ${p.getTelefono()}
                        </td>
                        <td>
                            ${p.getObservaciones()}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/paciente/retrieve/${p.getPacienteid()}.htm">Ver</a> |
                            <a href="${pageContext.request.contextPath}/paciente/update/${p.getPacienteid()}.htm">Editar</a> |
                            <a href="${pageContext.request.contextPath}/paciente/delete/${p.getPacienteid()}.htm">Eliminar</a>
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
