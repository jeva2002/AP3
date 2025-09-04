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
    String evaluated = (String) application.getAttribute("evaluation");
%>
<html>
<%@ include file="component/head.jsp" %>
<body>
<%@ include file="component/nav.jsp" %>
<h1 class="container-fluid text-center my-5 ">Resultado Evaluación Polinomios</h1>
<div class="container fs-5">
    <div class="row align-items-center">
        <p class="col"><b>Polinomio: </b><%= form.showPolynomial() %></p>
    </div>
    <div class="row align-items-center">
        <p class="col"><b>Solución: </b><%= evaluated %></p>
    </div>
</div>
</body>
</html>
