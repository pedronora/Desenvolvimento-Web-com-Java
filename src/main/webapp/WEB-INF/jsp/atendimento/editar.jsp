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
      <title>Editar Atendimento</title>
    </head>

    <body>
      <c:set var="disabledPets" value="" />
      <c:set var="disabledServicos" value="" />
      <c:import url="/WEB-INF/jsp/menu.jsp" />
      <main class="container rounded shadow my-4 p-4">
        <h1 class="mb-3">Editar Atendimento</h1>

        <form action="/atendimento/editar" method="post">
          <input type="text" name="id" value="${atendimento.id}" hidden>
          <div class="row">
            <div class="col mb-3">
              <label for="data" class="form-label">Data:</label>
              <input type="date" class="form-control" id="data" name="data" value="${atendimento.data}" placeholder="Informe a data do atendimento"
                required>
            </div>
            <div class="col mb-3">
              <label for="descricao" class="form-label">Descrição:</label>
              <input type="text" class="form-control" id="nome" name="descricao"
                value="${atendimento.descricao}" required>
            </div>
          </div>

          <div class="row">
            <div class="col mb-3">
                <c:choose>
                    <c:when test="${atendimento.emergencia}">
                        <c:set var="checkTrue" value="checked" />
                    </c:when>
                    <c:otherwise>
                        <c:set var="checkFalse" value="checked" />
                    </c:otherwise>
                </c:choose>
              <label class="form-label">Emergência?</label>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="emergencia" id="flexRadio" value="true" ${checkTrue}>
                <label class="form-check-label" for="flexRadio">
                  Sim
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="emergencia" id="flexRadio" value="false" ${checkFalse}>
                <label class="form-check-label" for="flexRadio">
                  Não
                </label>
              </div>
            </div>
            <div class="col mb-3">
              <div class="col mb-3">

                <label for="pet" class="form-label">Pet</label>
                <select id="pet" name="pet" class="form-select">
                  <c:if test="${not empty pets}">
                    <c:forEach var="pet" items="${pets}">
                      <option value="${pet.id}" <c:if test="${pet.id == atendimento.pet.id}">selected</c:if>>${pet.nome}</option>
                    </c:forEach>
                  </c:if>
                  <c:if test="${empty pets}">
                    <option value=null>Não há pets cadastrados</option>
                  </c:if>
                </select>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col mb-3">
              <label for="servico" class="form-label">Serviços:</label>
              <select id="servico" name="servicos" multiple class="form-select">
                  <c:forEach var="servico" items="${servicos}">
                    <option value="${servico.id}" <c:if test="${atendimento.servicos.contains(servico)}">selected</c:if>>${servico.nome}</option>
                  </c:forEach>
              </select>
              <div class="form-text">Mantenha pressionada a tecla 'Ctrl' para selecionar mais de um serviço.</div>
            </div>

            <div class="col mb-3"></div>
          </div>

          <c:if test="${not empty disabledServicos or not empty disabledPets}">
            <c:set var="botao" value="disabled" />
          </c:if>

          <button type="submit" class="btn btn-dark me-2" ${botao}>Editar</button>
          <a class="btn btn-dark" href="/atendimento">Voltar</a>
        </form>

      </main>
    </body>

    </html>