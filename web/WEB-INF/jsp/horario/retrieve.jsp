<%-- 
    Document   : retrieve
    Created on : 14-jul-2018, 13:31:02
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Datos Horario</title>
    </head>
    <body>
        <h1>Datos horario ${horario.getDias()}</h1>
        <hr>
        <fieldset>
            <label>Dias: </label>
            <span>${horario.getDias()}</span>
            <br>
            <label>Hora Inicial: </label>
            <span>${horario.getHorainicial()}</span>
            <br>
            <label>Hora Final: </label>
            <span>${horario.getHorafinal()}</span>
            <br>
         
        </fieldset>
        <button type="reset">
            <a href="${pageContext.request.contextPath}/horario/list.htm" style="text-decoration: none; color: black"/>Atr&aacute;s</a>
    </button>
</body>
</html>
