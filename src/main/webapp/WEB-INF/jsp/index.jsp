<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
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
    <title>PetShop - Gestão de Aumigos</title>
  </head>

  <body>
    <div class="container mt-3">
      <div class="mb-3">
        <h1>PetShop - Gestão de Aumigos</h1>
      </div>

      <section class="text-center rounded shadow p-4">
        <div class="mb-3">
          <h2>Menu:</h2>
        </div>
        <div class="row mb-3">
          <div class="col">
            <a class="btn btn-primary" href="/usuario" class="link-primary"
              >Cadastro de Usuário</a
            >
          </div>
          <div class="col">
            <a class="btn btn-primary" href="/atendimento" class="link-primary"
              >Cadastro de Atendimento</a
            >
          </div>
          <div class="col">
            <a class="btn btn-primary" href="/pet" class="link-primary"
              >Cadastro de Pet</a
            >
          </div>
        </div>
        <div class="row mb-3">
          <div class="col">
            <a class="btn btn-primary" href="/servico" class="link-primary"
              >Cadastro de Serviço</a
            >
          </div>
          <div class="col">
            <a class="btn btn-primary" href="/banho" class="link-primary"
              >Cadastro de Banho</a
            >
          </div>
          <div class="col">
            <a class="btn btn-primary" href="/vacina" class="link-primary"
              >Cadastro de Vacina</a
            >
          </div>
        </div>
      </section>
    </div>
  </body>
</html>
