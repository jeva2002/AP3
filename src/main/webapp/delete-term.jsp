<%@ page import="model.Polynomial" %><%--
  Created by IntelliJ IDEA.
  User: jvillegas
  Date: 25/08/2025
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Polynomial form = (Polynomial) application.getAttribute("Form");
%>
<html>
<%@ include file="component/head.jsp" %>
<body>
<%@ include file="component/nav.jsp" %>
<h1 class="container-fluid text-center my-5 ">Eliminar Término</h1>
<form class="container px-5 fs-5" action="<%= request.getContextPath() %>/delete-term" method="post">
    <div class="row mt-2">
        <div class="col">
            <label for="degree" class="form-label"> Exponente del Término </label>
            <input class="form-control" type="number" id="degree" name="degree" required/>
        </div>
    </div>

    <div class="row my-4">
        <button class="btn btn-primary" type="submit" value="insert">Eliminar Término</button>
    </div>

    <div class="row align-items-center">
        <p class="col"><b>Forma: </b><%= form.showForm() %></p>
    </div>
</form>
</body>
</html>
