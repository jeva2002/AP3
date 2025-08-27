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
    String evaluated = (String) application.getAttribute("evaluation");
%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Polinomios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
            crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Polinomios</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/describe.jsp">Descripción</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/eval-polynomial.jsp">Evaluar</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/add-polynomial.jsp">Sumar Polinomio</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/multiply-polynomial.jsp">Multiplicar Polinomio</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/add-term.jsp">Añadir Término</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/delete-term.jsp">Eliminar Término</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/">Volver a Iniciar</a>
            </div>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <p class="row align-items-center">
        <b>Polinomio: </b><span><%= form.showPolynomial() %></span>
    </p>
    <p class="row align-items-center">
        <b>Solución: </b><span><%= evaluated %></span>
    </p>
</div>
</body>
</html>
