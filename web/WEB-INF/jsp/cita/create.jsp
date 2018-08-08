<%-- 
    Document   : create
    Created on : 18-jul-2018, 7:25:36
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Registrar Citas</title>
    </head>
    <body>
        <h1>Registrar Cita</h1>
        <hr>
        <frm:form action="${pageContext.request.contextPath}/cita/create.htm" method="POST" commandName="cita">
            <fieldset>
                <label>Fecha: </label>
                <frm:input type="date" path="strFecha"></frm:input>
                <frm:errors path="strFecha" />  
                    <br>
                    <label>Paciente: </label>
                <frm:select path="idpaciente"> <%--Terapia--%>
                    <frm:option value="0" label="--Seleccione--"/>
                    <frm:options items="${listPaciente}"
                                 itemLabel="nombres"
                                 itemValue="pacienteid"/> <%--Paciente--%>
                </frm:select>
                <br>
                <label>M&eacute;dico: </label>
                <frm:select path="idmedico"> <%--Terapia--%>
                    <frm:option value="0" label="--Seleccione--"/>
                    <frm:options items="${listMedico}"
                                 itemLabel="nombres"
                                 itemValue="medicoid"/> <%--Paciente--%>
                </frm:select>
                <br>
                 <label>Hora: </label>
                 <frm:input path="hora" />
                 <small id="horaHelp" class="form-text text-muted">Ingrese la hora</small><br> 
                <frm:errors path="hora" />     
                <br>
                   <label>Dia: </label>
                   <frm:input path="dia" />
                   <small id="diaHelp" class="form-text text-muted">Ingrese el dia</small><br> 
                   <frm:errors path="dia" />   
                <br>
                <label>Observacion: </label>
                <frm:input path="observacion" />
                <small id="observacionHelp" class="form-text text-muted">Ingrese una Observacion</small><br>  
               <frm:errors path="observacion" /> 
                    <br>
                    <label>Realizada: </label>
                <frm:input path="realizada" placeholder="Ingrese si se realizo o no"></frm:input>
                    <br>
                <button type="reset">
                    <a href="${pageContext.request.contextPath}/cita/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
                </button>
                <button type="submit">Guardar</button>
            </div>
        </fieldset>
    </frm:form>
</body>
</html>
