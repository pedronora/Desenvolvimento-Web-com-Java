<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
    <meta charset="UTF-8" />
    <title>Login</title>
  </head>

  <body>
    <main class="container rounded shadow my-4 p-4">
      <h1 class="mb-3">Login</h1>
      <form action="/login" method="post">
        <div class="mb-3">
          <label for="email" class="form-label">Email:</label>
          <input
            type="email"
            class="form-control"
            id="email"
            name="email"
            placeholder="Informe o seu email"
            aria-describedby="emailHelp"
            required
          />
        </div>
        <div class="mb-3">
          <label for="senha" class="form-label">Senha:</label>
          <input
            type="password"
            class="form-control"
            name="senha"
            id="senha"
            placeholder="Informe sua senha"
            required
          />
        </div>
        <div class="mb-3">
          <a href="/usuario">Criar novo usuário</a>
        </div>
        <button type="submit" class="btn btn-primary">Entrar</button>
      </form>
    </main>
  </body>
</html>
