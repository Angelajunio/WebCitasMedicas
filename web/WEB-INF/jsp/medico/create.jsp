<%-- 
    Document   : create
    Created on : 13-jul-2018, 12:03:48
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <h1>Registrar Medico</h1>
        <hr>
        <frm:form action="${pageContext.request.contextPath}/medico/create.htm" method="POST" commandName="medico">
            <fieldset>
                <label>Nombre: </label>
                <frm:input path="nombres" placeholder="Ingrese el nombre"></frm:input>
                    <br>
                    <label>Apellidos: </label>
                <frm:input path="apellidos" placeholder="Ingrese el apellido"></frm:input>
                <br>
                <label>Correo: </label>
                <frm:input path="correo" placeholder="Ingrese el correo"></frm:input>
                <br>
                    <label>Especialidad: </label>
                <frm:select path="idespecialidad"> <%--Terapia--%>
                    <frm:option value="0" label="--Seleccione--"/>
                    <frm:options items="${listEspecialidad}"
                                 itemLabel="nombre"
                                 itemValue="especialidadid"/> <%--Paciente--%>
                </frm:select>
                <br>
                <label>Horario: </label>
                <frm:select path="idhorario"> <%--Terapia--%>
                    <frm:option value="0" label="--Seleccione--"/>
                    <frm:options items="${listHorario}"
                                 itemLabel="horainicial"
                                 itemValue="horarioid"/> <%--Paciente--%>
                    
                </frm:select>
                <br>
                <button type="reset">
                    <a href="${pageContext.request.contextPath}/medico/list.htm" style="text-decoration: none; color: black"/>Cancelar</a>
                </button>
                <button type="submit">Guardar</button>
            </div>
        </fieldset>
    </frm:form>
</body>
</html>
