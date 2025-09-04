<%@ page import="model.polinomios.Polynomial" %><%--
  Created by IntelliJ IDEA.
  User: jvillegas
  Date: 25/08/2025
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Polynomial form1 = (Polynomial) application.getAttribute("Form");
    Polynomial form2 = (Polynomial) application.getAttribute("Form2");
    Polynomial form3 = (Polynomial) application.getAttribute("Form3");
%>
<html>
<%@ include file="component/head.jsp" %>
<body>
<%@ include file="component/nav.jsp" %>
<h1 class="container-fluid text-center my-5 ">Resultado de Operación entre Polinomios</h1>
<div class="container fs-5">
    <div class="row align-items-center">
        <p class="col"><b>Polinomio A: </b><%= form1.showPolynomial() %></p>
    </div>
    <div class="row align-items-center">
        <p class="col"><b>Polinomio B: </b><%= form2.showPolynomial() %></p>
    </div>
    <div class="row align-items-center">
        <p class="col"><b>Resultado: </b><%= form3.showPolynomial() %></p>
    </div>
</div>
</body>
</html>
