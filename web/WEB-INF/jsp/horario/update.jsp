<%-- 
    Document   : update
    Created on : 14-jul-2018, 13:31:11
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Horario</title>
    </head>
    <body>
        <h1>Editar Horario</h1>
        <hr>
        <frm:form action="${pageContext.request.contextPath}/horario/update.htm" method="POST" commandName="horario">
            <fieldset>
              
                    <label>Dias: </label>
                <frm:input path="dias" 
                           value="${horario.getDias()}"
                           placeholder="Ingrese el dia"></frm:input>
                    <br>
                    <label>Hora Inicial: </label>
                    <frm:input path="horainicial" 
                           value="${horario.getHorainicial()}"
                           placeholder="Ingrese la hora inicial"></frm:input>
                    <br>
                    <label>Hora Final: </label>
                    <frm:input path="horafinal" 
                           value="${horario.getHorafinal()}"
                           placeholder="Ingrese la hora final"></frm:input>
 
                           <frm:hidden path="horarioid" 
                            value="${horario.getHorarioid()}"></frm:hidden>
                    <div>
                       
                            <a href="${pageContext.request.contextPath}/horario/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
                    
                    <button type="submit">Actualizar</button>
                </div>
            </fieldset>
        </frm:form>
    </body>
</html>
