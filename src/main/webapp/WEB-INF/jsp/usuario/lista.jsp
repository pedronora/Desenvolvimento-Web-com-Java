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
      <title>Cadastro de Usuários</title>
    </head>

    <body>
      <c:import url="/WEB-INF/jsp/menu.jsp" />
      <main class="container rounded shadow my-4 p-4">
        <h1 class="mb-3">Listagem de Usuários</h1>
        <c:if test="${not empty mensagem}">
          <div class="alert alert-${alerta}" role="alert">
            ${mensagem}
          </div>
        </c:if>
        <c:if test="${empty usuarios}">
          <h5 class="mb-3">Não existem usuários cadastrados</h5>
        </c:if>
        <c:if test="${not empty usuarios}">
          <div class="row mb-3">
            <div class="table-responsive">
              <table class="table table table-striped align-middle">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Email</th>
                    <th scope="col">Pets</th>
                    <th scope="col">Serviços</th>
                    <th scope="col">Atendimentos</th>
                    <th scope="col">Admin?</th>
                    <th scope="col">Endereço</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="usuario" items="${usuarios}">
                    <tr>
                      <th scope="row">${usuario.id}</th>
                      <td>${usuario.nome}</td>
                      <td>${usuario.email}</td>
                      <td>${usuario.pets.size()}</td>
                      <td>${usuario.servicos.size()}</td>
                      <td>${usuario.atendimentos.size()}</td>
                      <td>
                        <c:if test="${usuario.admin}">Sim</c:if>
                        <c:if test="${!usuario.admin}">Não</c:if>
                      </td>
                      <td>${usuario.endereco}</td>
                      <td>
                        <a class="btn btn-outline-secondary" href="/usuario/${usuario.id}/detalhes">Detalhes</a>
                        <c:if test="${user.admin or (user.id == usuario.id)}">
                          <c:if test="${usuario.pets.size() != 0 and usuario.servicos.size() != 0 and usuario.atendimentos.size() != 0}"><a class="btn btn-outline-info" href="/usuario/${usuario.id}/editar">Editar</a></c:if>
                        </c:if>
                        <c:if test="${user.admin and (user.id != usuario.id)}">
                          <a class="btn btn-outline-danger" href="/usuario/${usuario.id}/excluir">Excluir</a>
                        </c:if>

                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
                <tfoot>
                  <tr>
                    <th scope="row"></th>
                    <th scope="row">Total</td>
                    <th scope="row">${usuarios.size()}</td>
                    <th scope="row"></th>
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