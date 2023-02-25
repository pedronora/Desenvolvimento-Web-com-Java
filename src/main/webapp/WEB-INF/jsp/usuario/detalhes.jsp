<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
      crossorigin="anonymous"
    ></script>
    <meta charset="UTF-8">
    <title>Detalhes de Usuário</title>
  </head>

  <body>
    <main class="container rounded shadow my-4 p-4">
        <h1 class="mb-3">Detalhes de Usuário</h1>
        <form>
          <div class="row mb-3">
            <div class="col">
              <label for="nome" class="form-label">Nome Completo:</label>
              <input
                type="text"
                class="form-control"
                name="nome"
                id="nome"
                placeholder="Insira o seu nome"
                value="${usuario.nome}"
                disabled
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
                  value="${usuario.senha}"
                  disabled
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
                value="${usuario.email}"
                disabled
              />
            </div>
            <div class="col"></div>

          </div>
          <a class="btn btn-dark mb-3" href="/usuario/lista">Voltar</a>
        </form>
      </main>
    </body>
  </body>
</html>
