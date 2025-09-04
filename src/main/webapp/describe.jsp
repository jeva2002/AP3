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
    String entrada = (String) application.getAttribute("Entry");
%>
<html>
<%@ include file="component/head.jsp" %>
<body>
<%@ include file="component/nav.jsp" %>
<h1 class="container-fluid text-center my-5 ">Descripción Polinomio</h1>
<div class="container fs-5">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Polinomio Inicial</th>
            <th scope="col">Polinomio Organizado</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><%= entrada %>
            </td>
            <td><%= form.showPolynomial() %>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="container fs-5">
    <div class="row align-items-center">
        <p class="col"><b>Forma: </b><span><%= form.showForm() %></span></p>
    </div>
</div>
</body>
</html>
