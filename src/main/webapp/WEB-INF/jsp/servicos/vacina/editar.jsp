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
    <title>Editar Vacina</title>
  </head>

  <body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
    <main class="container rounded shadow my-4 p-4">
      <h1 class="mb-3">Editar Vacina</h1>
      <form action="/servicos/vacina/editar" method="post">
        <div class="row">
          <div class="col mb-3">
            <input type="number" name="id" value="${vacina.id}" hidden>
            <label for="nome" class="form-label">Nome:</label>
            <input type="text" class="form-control" id="nome" name="nome" value="${vacina.nome}" required>
          </div>
          <div class="col mb-3">
            <label for="preco" class="form-label">Preço</label>
            <input type="number" class="form-control" id="preco" name="preco" value="${vacina.preco}" required>
          </div>
        </div>

        <div class="row">
          <div class="col mb-3">
            <label for="tempo" class="form-label">Tempo do Serivço:</label>
            <input type="number" class="form-control" id="tempo" name="tempoMinutos" value="${vacina.tempoMinutos}" aria-describedby="tempoMinutospInline" required>
            <span id="tempoMinutospInline" class="form-text">O tempo deve ser maior que 10 minutos</span>
          </div>
          <div class="col mb-3">
            <label for="tipos" class="form-label">Tipos de Vacina</label>
            <select id="tipos" name="tipo" class="form-select">
              <option <c:if test="${vacina.tipo == 'V-10'}">selected</c:if> value="V-10">V-10</option>
              <option <c:if test="${vacina.tipo == 'Raiva'}">selected</c:if> value="Raiva">Raiva</option>
              <option <c:if test="${vacina.tipo == 'Gripe'}">selected</c:if> value="Gripe">Gripe</option>
            </select>
          </div>         
        </div>

        <div class="row">
          <div class="col mb-3">
            <label for="marca" class="form-label">Marca da Vacina:</label>
            <input type="text" name="marca" class="form-control" id="marca" name="tempoMinutos" value="${vacina.marca}" required>
          </div>
          <div class="col mb-3">
            <label for="precoVacina" class="form-label">Preço da Vacina</label>
            <input type="number" class="form-control" id="precoVacina" name="precoVacina" value="${vacina.precoVacina}" required>
          </div>         
        </div>
        <button type="submit" class="btn btn-dark me-2">Editar</button>
        <a class="btn btn-dark" href="/servicos/vacina">Voltar</a>
      </form>      
    </main>
  </body>
</html>
