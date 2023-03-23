<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
      crossorigin="anonymous"
    ></script>
    <meta charset="UTF-8" />
    <title>Cadastro de Consulta</title>
  </head>

  <body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
    <main class="container rounded shadow my-4 p-4">
      <h1 class="mb-3">Cadastro de Consulta</h1>
      <form action="/servicos/consulta/incluir" method="post">

        <c:import url="/WEB-INF/jsp/servicos/cadastro.jsp" />

          <div class="col mb-3">
            <label class="form-label">Plantão?</label>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="plantao" id="flexRadio" value="true">
              <label class="form-check-label" for="flexRadio">
                Sim
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="plantao" id="flexRadio" value="false" checked>
              <label class="form-check-label" for="flexRadio">
                Não
              </label>
            </div>
          </div>     
        </div>

        <div class="row">
          <div class="mb-3">
            <label for="formControleTextArea" class="form-label">Descrição do Atendimento:</label>
            <textarea class="form-control" id="formControleTextArea" rows="3" name="descricao" required></textarea>
          </div>   

        <div class="row">
          <div class="mb-3">
            <label for="formControleTextArea" class="form-label">Receita Médica:</label>
            <textarea class="form-control" id="formControleTextArea" rows="3" name="receita" required></textarea>
          </div>   
        </div>
        <div>
          <button type="submit" class="btn btn-dark me-2">Cadastrar</button>
          <a class="btn btn-dark" href="/servicos/consulta">Voltar</a>
        </div>
      </form>      
    </main>
  </body>
</html>
