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
    <title>Cadastro de Usuário</title>
  </head>

  <body>
    <main class="container rounded shadow my-4 p-4">
        <h1 class="mb-3">Cadastro de Usuário</h1>
        <form action="/usuario/incluir" method="post">
          <div class="row mb-3">
            <div class="mb-3 col">
              <label for="nome" class="form-label">Nome Completo:</label>
              <input
                type="text"
                class="form-control"
                name="nome"
                id="nome"
                placeholder="Insira o seu nome"
              />
            </div>
            <div class="col">
              <label for="senha" class="col-sm-2 col-form-label">Senha</label>
              <div class="col">
                <input
                  type="password"
                  class="form-control"
                  name="senha"
                  id="senha"
                  placeholder="Insira sua senha"
                />
              </div>
            </div>
          </div>
          <div class="row mb-3">
            <div class="mb-3 col">
              <label for="email" class="form-label">Email address</label>
              <input
                type="email"
                class="form-control"
                name="email"
                id="email"
                placeholder="nome@exemplo.com.br"
              />
            </div>
            <div class="mb-3 col">
              <label for="idade" class="form-label">Idade:</label>
              <input
                type="text"
                class="form-control"
                id="idade"
                name="idade"
                placeholder="Insira a sua idade"
              />
            </div>
          </div>
          <div class="row mb-3">
            <div class="mb-3 col">
              <label for="salario" class="form-label">Salário:</label>
              <input
                type="text"
                class="form-control"
                name="salario"
                id="salário"
                placeholder="Insira o seu salário"
              />
            </div>
            <div class="form-group col">
              <label class="form-label">Características:</label>
              <div class="form-check">
                <input
                  class="form-check-input"
                  name="caracteristicas"
                  type="checkbox"
                  value="De"
                  id="flexCheckDefault"
                />
                <label class="form-check-label" for="flexCheckDefault">
                  Developer
                </label>
              </div>
              <div class="form-check">
                <input
                  class="form-check-input"
                  name="caracteristicas"
                  type="checkbox"
                  value="An"
                  id="flexCheckChecked"
                />
                <label class="form-check-label" for="flexCheckChecked">
                  Analista
                </label>
              </div>
              <div class="form-check">
                <input
                  class="form-check-input"
                  name="caracteristicas"
                  type="checkbox"
                  value="Da"
                  id="flexCheckChecked"
                />
                <label class="form-check-label" for="flexCheckChecked">
                  Database
                </label>
              </div>
            </div>
          </div>
          <div class="row mb-3">
            <div class="form-group col">
                <label>Setor:</label>
                <select class="form-select" name="setor" aria-label="Setor select">
                  <option value="1">Diretoria</option>
                  <option value="2">Comercial</option>
                  <option value="3">Desenvolvimento</option>
                </select>
              </div>
            <div class="form-group col">
              <label class="form-label">Tipo:</label>
              <div class="form-check">
                <input
                  class="form-check-input"
                  type="radio"
                  name="tipo"
                  id="padrao"
                  value="P"
                />
                <label class="form-check-label" for="padrao">
                  Padrão
                </label>
              </div>
              <div class="form-check">
                <input
                  class="form-check-input"
                  type="radio"
                  name="tipo"
                  id="diretor"
                  value="D"

                />
                <label class="form-check-label" for="diretor">
                  Diretor
                </label>
              </div>
              <div class="form-check">
                <input
                  class="form-check-input"
                  type="radio"
                  name="tipo"
                  id="administrador"
                  value="A"
                />
                <label class="form-check-label" for="administrador">
                  Administrador
                </label>
              </div>
            </div>
          </div>

          <button class="btn btn-primary mb-3" type="submit">Cadastrar</button>
          <a class="btn btn-primary mb-3" href="/">Voltar</a>
        </form>
      </main>
    </body>
  </body>
</html>
