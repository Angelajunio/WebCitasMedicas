<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        
        <div>
            <a href="${pageContext.request.contextPath}/medico/list.htm">Listado de m&eacute;dicos</a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/paciente/list.htm">Listado de paciente</a>
        </div>
        
        <div>
            <a href="${pageContext.request.contextPath}/terapia/list.htm">Listado de terapia</a>
        </div>
    </body>
</html>
