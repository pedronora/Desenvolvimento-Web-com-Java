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
    <title>Cadastro de Banho</title>
  </head>

  <body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />
    <main class="container rounded shadow my-4 p-4">
      <h1 class="mb-3">Cadastro de Banho</h1>
      <form action="/servicos/banho/incluir" method="post">

        <c:import url="/WEB-INF/jsp/servicos/cadastro.jsp" />
        
          <div class="col mb-3">
            <label class="form-label">Opções:</label>
            <div class="form-check form-switch">
              <input hidden name="_hidratarPelo" value="false" checked>
              <input class="form-check-input" type="checkbox" role="switch" id="hidratarPelo" name="hidratarPelo" value="true">
              <label class="form-check-label" for="hidratarPelo">
                Hidratar pelo
              </label>
            </div>
            <div class="form-check form-switch">
              <input hidden name="_cortarUnhas" value="false" checked>
              <input class="form-check-input" type="checkbox" role="switch" id="cortarUnhas" name="cortarUnhas" value="true">
              <label class="form-check-label" for="cortarUnhas">
                Cortar Unhas
              </label>
            </div>
            <div class="form-check form-switch">
              <input hidden name="_escovarDentes" value="false" checked>
              <input class="form-check-input" type="checkbox" role="switch" id="escovarDentes" name="escovarDentes" value="true">
              <label class="form-check-label" for="escovarDentes">
                Escovar dentes
              </label>
            </div>
          </div>
        </div>
        <button type="submit" class="btn btn-dark me-2">Cadastrar</button>
        <a class="btn btn-dark" href="/servicos/banho">Voltar</a>
      </form>      
    </main>
  </body>
</html>
