<%@ page import="model.polinomios.Polynomial" %><%--
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
<h1 class="container-fluid text-center my-5">Agregar Término</h1>
<form class="container px-5" action="<%= request.getContextPath() %>/add-term" method="post">
    <div class="row align-items-center fs-5">
        <p class="col"><b>Polinomio: </b><%= form.showPolynomial() %></p>
    </div>

    <div class="row mt-2">
        <div class="col">
            <label for="coef" class="form-label"> Coeficiente </label>
            <input class="form-control" type="number" id="coef" name="coef" required/>
        </div>
        <div class="col">
            <label for="exp" class="form-label"> Exponente </label>
            <input class="form-control" type="number" id="exp" name="exp" required min="0"/>
        </div>
    </div>

    <div class="row mt-4">
        <button class="btn btn-primary" type="submit" value="insert">Insertar Término</button>
    </div>
</form>
</body>
</html>
