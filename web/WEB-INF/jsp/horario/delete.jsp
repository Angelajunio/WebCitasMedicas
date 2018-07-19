<%-- 
    Document   : delete
    Created on : 14-jul-2018, 13:30:49
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Horario</title>
    </head>
    <body>
        <h1>Desea eliminar horario ${horario.getDias()}</h1>
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
        <frm:form action="${pageContext.request.contextPath}/ehorario/delete.htm" method="POST" commandName="horario">
            <frm:hidden path="horarioid"/>
             <br>
            <div>
               
                    <a href="${pageContext.request.contextPath}/horario/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
               
                <button type="submit">Eliminar</button>
            </div>
        </frm:form>
</body>
</html>
