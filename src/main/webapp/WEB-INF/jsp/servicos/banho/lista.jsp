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
      <title>Cadastro de Banhos</title>
    </head>

    <body>
      <c:import url="/WEB-INF/jsp/menu.jsp" />
      <main class="container rounded shadow my-4 p-4">
        <h1 class="mb-3">Listagem de Banhos</h1>
        <form action="/servicos/banho/cadastro">
            <button class="btn btn-dark mb-3" type="su
            ">Cadastrar Banho</button>
        </form>
        <c:if test="${not empty mensagem}">
          <div class="alert alert-${alerta}" role="alert">
            ${mensagem}
          </div>
        </c:if>
        <c:if test="${empty banhos}">
          <h5 class="mb-3">Não existem banhos cadastrados</h5>
        </c:if>
        <c:if test="${not empty banhos}">
          <div class="row mb-3">
            <div class="table-responsive">
              <table class="table table table-striped">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Preço</th>
                    <th scope="col">Tempo de Banho</th>
                    <th scope="col">Hidratar Pelo</th>
                    <th scope="col">Cortar Unhas</th>
                    <th scope="col">Escovar Dentes</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="banho" items="${banhos}">
                    <tr>
                      <th scope="row">${banho.id}</th>
                      <td>${banho.nome}</td>
                      <td>${banho.preco}</td>
                      <td>${banho.tempoMinutos}</td>
                      <td>
                        <c:if test="${banho.hidratarPelo}">Sim</c:if>
                        <c:if test="${!banho.hidratarPelo}">Não</c:if>
                      </td>
                      <td>
                        <c:if test="${banho.cortarUnhas}">Sim</c:if>
                        <c:if test="${!banho.cortarUnhas}">Não</c:if>
                      </td>
                      <td>
                        <c:if test="${banho.escovarDentes}">Sim</c:if>
                        <c:if test="${!banho.escovarDentes}">Não</c:if>
                      </td>
                      <td>
                        <a class="btn btn-outline-secondary" href="/servicos/banho/${banho.id}/detalhes">Detalhes</a>
                        <a class="btn btn-outline-info" href="/servicos/banho/${banho.id}/editar">Editar</a>
                        <a class="btn btn-outline-danger" href="/servicos/banho/${banho.id}/excluir">Excluir</a>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
                <tfoot>
                  <tr>
                    <th scope="row"></th>
                    <th scope="row">Total</td>
                    <th scope="row">${banhos.size()}</td>
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