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
      <title>Lista de Pets</title>
    </head>

    <body>
      <c:import url="/WEB-INF/jsp/menu.jsp" />
      <main class="container rounded shadow my-4 p-4">
        <h1 class="mb-3">Lista de Pets</h1>
        <form action="/pet/cadastro">
            <button class="btn btn-dark mb-3" type="su
            ">Cadastrar Pet</button>
        </form>
        <c:if test="${not empty mensagem}">
          <div class="alert alert-${alerta}" role="alert">
            ${mensagem}
          </div>
        </c:if>
        <c:if test="${empty pets}">
          <h5 class="mb-3">Não existem pets cadastrados</h5>
        </c:if>
        <c:if test="${not empty pets}">
          <div class="row mb-3">
            <div class="table-responsive">
              <table class="table table table-striped align-middle">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Data de Nascimento</th>
                    <th scope="col">Espécie</th>
                    <th scope="col">Raça</th>
                    <th scope="col">Gênero</th>
                    <th scope="col">Castrado</th>
                    <th scope="col">Usuário</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="pet" items="${pets}">
                    <tr>
                      <th scope="row">${pet.id}</th>
                      <td>${pet.nome}</td>
                      <td>${pet.dataNasc}</td>
                      <td>${pet.especie}</td>
                      <td>${pet.raca}</td>
                      <td>
                        <c:if test="${pet.genero == 'F'.charAt(0)}">Fêmea</c:if>
                        <c:if test="${pet.genero == 'M'.charAt(0)}">Macho</c:if>
                      </td>
                      <td>
                        <c:if test="${pet.castrado}">Sim</c:if>
                        <c:if test="${!pet.castrado}">Não</c:if>
                      </td>
                      <td>${pet.usuario.nome}</td>
                      <td>
                        <a class="btn btn-outline-secondary" href="/pet/${pet.id}/detalhes">Detalhes</a>
                        <a class="btn btn-outline-info" href="/pet/${pet.id}/editar">Editar</a>
                        <a class="btn btn-outline-danger" href="/pet/${pet.id}/excluir">Excluir</a>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
                <tfoot>
                  <tr>
                    <th scope="row"></th>
                    <th scope="row">Total</td>
                    <th scope="row">${pets.size()}</td>
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