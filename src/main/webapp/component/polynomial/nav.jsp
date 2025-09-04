<%--
  Created by IntelliJ IDEA.
  User: jvillegas
  Date: 26/08/2025
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary bg-dark"  data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Polinomios</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/describe-polynomial.jsp">Descripción</a>
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