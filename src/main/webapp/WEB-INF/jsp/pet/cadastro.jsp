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
    <title>Cadastro de Pet</title>
  </head>

  <body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
    <main class="container rounded shadow my-4 p-4">
      <h1 class="mb-3">Cadastro de Pet</h1>
      <form action="/pet/incluir" method="post">
        <div class="row">
          <div class="col mb-3">
            <label for="nome" class="form-label">Nome:</label>
            <input type="text" class="form-control" id="nome" name="nome" placeholder="Insira o nome do pet" required>
          </div>
          <div class="col mb-3">
            <label for="dataNasc" class="form-label">Data de Nascimento</label>
            <input type="date" class="form-control" id="dataNasc" name="dataNasc" placeholder="Informe a data de nascimento do pet" required>
          </div>
        </div>

        <div class="row">
          <div class="col mb-3">
            <label for="especie" class="form-label">Espécie do Pet:</label>
            <select class="form-select" aria-label="selecao" name="especie">
              <option value="Cachorro" selected>Cachorro</option>
              <option value="Gato">Gato</option>
              <option value="Outro">Outro</option>
            </select>
          </div>       
          <div class="col mb-3">
            <div class="col mb-3">
              <label for="raca" class="form-label">Raça:</label>
              <input type="text" class="form-control" id="raca" name="raca" placeholder="Insira a raça do pet" required>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col mb-3">
            <label for="genero" class="form-label">Gênero:</label>
            <select class="form-select" aria-label="selecao" name="genero">
              <option value="F" selected>Fêmea</option>
              <option value="M">Macho</option>
            </select>
          </div>       
          <div class="col mb-3">
            <label for="castrado" class="form-label">Castrado:</label>
            <select class="form-select" aria-label="selecao" name="castrado">
              <option value="false" selected>Não</option>
              <option value="true">Sim</option>
            </select>
          </div>    
        </div>
        <button type="submit" class="btn btn-dark me-2">Cadastrar</button>
        <a class="btn btn-dark" href="/pet">Voltar</a>
      </form>
    </main>
  </body>
</html>
