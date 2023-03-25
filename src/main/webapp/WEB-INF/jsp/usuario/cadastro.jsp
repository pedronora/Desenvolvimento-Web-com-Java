<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <meta charset="UTF-8">
    <title>Cadastro de Usuário</title>
  </head>

  <body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
    <main class="container rounded shadow my-4 p-4">
        <h1 class="mb-3">Cadastro de Usuário</h1>
        <form class="mb-3" action="/usuario/cep" method="post">
          <div class="row mb-3">
            <div class="input-group col">
              <span class="input-group-text" id="basic-addon1"><i class="bi bi-house"></i></span>
              <input type="text" class="form-control" placeholder="Informe seu CEP" aria-label="cep" aria-describedby="basic-addon1" name="cep" value="${endereco.cep}" maxlength="9" required>
            </div>
            <div class="col-10">
              <button class="btn btn-dark" type="submit">Buscar</button>
            </div>
          </div>
        </form>
        <form class="mb3" action="/usuario/incluir" method="post">
          <div class="row mb-3">
            <div class="col">
              <label for="nome" class="form-label">Nome Completo:</label>
              <input
                type="text"
                class="form-control"
                name="nome"
                id="nome"
                placeholder="Insira o seu nome"
                required
              />
            </div>
            <div class="col">
              <label for="senha" class="form-label">Senha</label>
                <input
                  type="password"
                  class="form-control"
                  name="senha"
                  id="senha"
                  placeholder="Insira sua senha"
                  required
                />
            </div>
          </div>
          <div class="row mb-3">
            <div class="col">
              <label for="email" class="form-label">Email</label>
              <input
                type="email"
                class="form-control"
                name="email"
                id="email"
                placeholder="nome@exemplo.com.br"
                required
              />
            </div>
            <div class="col"></div>
          </div>

          <c:import url="/WEB-INF/jsp/endereco/cadastro.jsp" />
          
          <button class="btn btn-dark mb-3" type="submit">Cadastrar</button>
        </form>
      </main>
    </body>
</html>
