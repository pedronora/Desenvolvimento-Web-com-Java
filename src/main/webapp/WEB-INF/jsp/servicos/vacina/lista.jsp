<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
      <meta charset="UTF-8" />
      <title>Listagem de Vacinas</title>
    </head>

    <body>
      <c:import url="/WEB-INF/jsp/menu.jsp" />
      <main class="container rounded shadow my-4 p-4">
        <h1 class="mb-3">Listagem de Vacinas</h1>
        <form action="/servicos/vacina/cadastro">
            <button class="btn btn-dark mb-3" type="su
            ">Cadastrar Vacina</button>
        </form>
        <c:if test="${not empty mensagem}">
          <div class="alert alert-${alerta}" role="alert">
            ${mensagem}
          </div>
        </c:if>
        <c:if test="${empty vacinas}">
          <h5 class="mb-3">Não existem vacinas cadastradas</h5>
        </c:if>
        <c:if test="${not empty vacinas}">
          <div class="row mb-3">
            <div class="table-responsive">
              <table class="table table table-striped">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Preço da Aplicação</th>
                    <th scope="col">Tempo de Aplicação</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Marca</th>
                    <th scope="col">Preço da Vacina</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="vacina" items="${vacinas}">
                    <tr>
                      <th scope="row">${vacina.id}</th>
                      <td>${vacina.nome}</td>
                      <td>${vacina.preco}</td>
                      <td>${vacina.tempoMinutos}</td>
                      <td>${vacina.tipo}</td>
                      <td>${vacina.marca}</td>
                      <td>${vacina.precoVacina}</td>
                      <td>
                        <a class="btn btn-outline-secondary" href="/servicos/vacina/${vacina.id}/detalhes">Detalhes</a>
                        <a class="btn btn-outline-info" href="/servicos/vacina/${vacina.id}/editar">Editar</a>
                        <a class="btn btn-outline-danger" href="/servicos/vacina/${vacina.id}/excluir">Excluir</a>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
                <tfoot>
                  <tr>
                    <th scope="row"></th>
                    <th scope="row">Total</td>
                    <th scope="row">${vacinas.size()}</td>
                    <th scope="row"></th>
                    <th scope="row"></th>
                    <th scope="row"></th>
                    <th scope="row"></th>
                    <th scope="row"></th>
                  </tr>
                </tfoot>
              </table>
            </div>
          </div>
        </c:if>
        <a class="link-dark" href="/home">Voltar</a>
      </main>
    </body>

    </html>