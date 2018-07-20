<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/container/css/bootstrap.min.css"/>" rel="stylesheet">
        <title>Citas Medicas</title>
    </head>

    <body>
        <div class="jumbotron">
            <div class="container">
         <h1>Citas Medicas</h1>
           </div>
        </div>  
           <img src="container/imagenes/diabetes-900x380.jpg"/>
        
        <div>
            <a href="${pageContext.request.contextPath}/medico/list.htm">Listado de m&eacute;dicos</a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/paciente/list.htm">Listado de paciente</a>
        </div>
        
        <div>
            <a href="${pageContext.request.contextPath}/especialidad/list.htm">Listado de especialidad</a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/horario/list.htm">Listado de horario</a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/cita/list.htm">Listado de citas</a>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="<c:url value="/container/js/bootstrap.min.js"/>"></script>
    </body>
</html>
