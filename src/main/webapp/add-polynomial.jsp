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
<h1 class="container-fluid text-center my-5 ">Sumar Polinomios</h1>
<form class="container px-5 fs-5" action="<%= request.getContextPath() %>/add-polynomial" method="post">
    <div class="row">
        <p class="col"><b>Polinomio A: </b><%= form.showPolynomial() %></p>
    </div>

    <div class="row mt-2">
        <div class="col">
            <label for="polinomio" class="form-label"> Polinomio B</label>
            <input class="form-control" type="text" id="polinomio" name="polinomio" required/>
        </div>
    </div>

    <div class="row mt-4">
        <button class="btn btn-primary" type="submit" value="sumar">Sumar</button>
    </div>
</form>
</body>
</html>
