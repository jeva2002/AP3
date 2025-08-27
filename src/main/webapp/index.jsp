<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
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
<div>
    <div class="container text-center my-5">
        <div class="row">
            <h1>Bienvenido a la calculadora de Polinomios</h1>
        </div>
    </div>
    <form class="container px-5 fs-5" action="<%= request.getContextPath() %>/initial" method="post">
        <div class="row">
            <legend>Escriba un polinomio y seleccione una de las formas para iniciar</legend>
        </div>
        <div class="row my-5">
            <div class="col">
                <label for="polinomio" class="form-label"> Polinomio </label>
                <input class="form-control" type="text" id="polinomio" name="polinomio" required/>
            </div>
            <div class="col">
                <label for="form"> Forma</label>
                <select class="form-select mt-2" name="form" id="form">
                    <option value="form1">Forma 1</option>
                    <option value="form2">Forma 2</option>
                    <option value="form3">Forma 3</option>
                </select>
            </div>
        </div>

        <div class="row mt-4">
            <button class="btn btn-primary" type="submit" value="Empezar Cálculo">Empezar Cálculo</button>
        </div>
    </form>
</div>
</body>
</html>