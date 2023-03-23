<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
      crossorigin="anonymous"
    ></script>
    <meta charset="UTF-8" />
    <title>Cadastro de Vacina</title>
  </head>

  <body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
    <main class="container rounded shadow my-4 p-4">
      <h1 class="mb-3">Cadastro de Vacina</h1>
      <form action="/servicos/vacina/incluir" method="post">

        <c:import url="/WEB-INF/jsp/servicos/cadastro.jsp" />
        
          <div class="col mb-3">
            <label for="tipos" class="form-label">Tipos de Vacina</label>
            <select id="tipos" name="tipo" class="form-select">
              <option selected value="V-10">V-10</option>
              <option value="Raiva">Raiva</option>
              <option value="Gripe">Gripe</option>
            </select>
          </div>
        </div>

        <div class="row">
          <div class="col mb-3">
            <label for="marca" class="form-label">Marca da Vacina:</label>
            <input type="text" name="marca" class="form-control" id="marca" name="tempoMinutos" placeholder="Insira a marca da vacina" required>
          </div>
          <div class="col mb-3">
            <label for="precoVacina" class="form-label">Preço da Vacina</label>
            <input type="number" class="form-control" id="precoVacina" name="precoVacina" placeholder="Insira o preço da Vacina" required>
          </div>         
        </div>
        <button type="submit" class="btn btn-dark me-2">Cadastrar</button>
        <a class="btn btn-dark" href="/servicos/vacina">Voltar</a>
      </form>      
    </main>
  </body>
</html>
