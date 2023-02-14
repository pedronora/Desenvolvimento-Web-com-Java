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
    <title>Cadastro de Usuário</title>
  </head>

  <body>
    <main class="container rounded shadow my-4 p-4">
      <h1 class="mb-3">Listagem de Usuários</h1>
      <div class="row mb-3">
        <form action="/usuario" method="get">
          <button class="btn btn-primary" type="submit">Novo</button>
        </form>
      </div>
      <div class="row mb-3">
        <div class="table-responsive">
          <table class="table table table-striped">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Nome Completo</th>
                <th scope="col">Email</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</td>
                <td>Pedro Nora</td>
                <td>pedro.nora@al.infnet.edu.br</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </main>
  </body>
</html>
