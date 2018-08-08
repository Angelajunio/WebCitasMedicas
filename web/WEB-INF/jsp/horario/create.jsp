<%-- 
    Document   : create
    Created on : 14-jul-2018, 13:30:40
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Registrar Horario</title>
    </head>
    <body>
        <h1>Registrar Horario</h1>
        <hr>
        <frm:form action="${pageContext.request.contextPath}/horario/create.htm" method="POST" commandName="horario">
            <fieldset>
                    <label>Dias: </label>
                    <frm:input path="dias" />
                  <small id="diasHelp" class="form-text text-muted">Ingrese el dia</small><br>
                   <frm:errors path="dias" /> 
                <br>
                <label>Hora Inicial: </label>
                <frm:input path="horainicial"/>
                <small id="horainicialHelp" class="form-text text-muted">Ingrese la hora inicial</small><br>
                <frm:errors path="horainicial" /> 
                
                <br>

                <label>Hora Final: </label>
                <frm:input path="horafinal" />
               <small id="horafinalHelp" class="form-text text-muted">Ingrese la hora final</small><br>
                <frm:errors path="horafinal" /> 
                    <br>
                <div>
                        
                            <a href="${pageContext.request.contextPath}/horario/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
                            <button type="submit">Guardar</button>
       
                </div>
            </fieldset>
        </frm:form>
    </body>
</html>
