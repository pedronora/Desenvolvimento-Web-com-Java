<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8" />
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
      <title>PetShop - Gestão de Aumigos</title>
    </head>

    <body>
      <c:import url="/WEB-INF/jsp/menu.jsp" />

      <div class="container mt-3">
        <div class="mb-3">
          <h1>PetShop - Gestão de Aumigos</h1>
        </div>

        <section class="text-center rounded shadow p-4">
          <c:if test="${empty user}">
            <h2>Instituto Infnet</h2>
            <h3>Desenvolvimento Web com Java</h3>
            <h4>Prof.: Elberth Lins Costa de Moraes</h4>
  
            <h5>Aluno: Pedro Nora</h5>
          </c:if>

          <c:if test="${not empty user}">
            <div class="mb-3">
              <h2>Menu:</h2>
            </div>
            <div class="row mb-3">
              <div class="col">
                <a class="btn btn-dark" href="/atendimento">Atendimentos</a>
              </div>
              <div class="col">
                <a class="btn btn-dark" href="/pet">Pets</a>
              </div>
              <div class="col">
                <a class="btn btn-dark" href="/servicos">Serviços</a>
              </div>
            </div>
            <div class="row mb-3">
              <div class="col">
                <a class="btn btn-dark" href="/servicos/consulta">Consultas</a>
              </div>
              <div class="col">
                <a class="btn btn-dark" href="/servicos/banho">Banhos</a>
              </div>
              <div class="col">
                <a class="btn btn-dark" href="/servicos/vacina">Vacinas</a>
              </div>
            </div>
          </c:if>
        </section>

      </div>
    </body>

    </html>