<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  
    <div class="row">
      <div class="col mb-3">
        <label for="nome" class="form-label">Nome:</label>
        <input type="text" class="form-control" id="nome" name="nome" placeholder="Insira o nome do serviço" required>
      </div>
      <div class="col mb-3">
        <label for="preco" class="form-label">Preço</label>
        <input type="number" class="form-control" id="preco" name="preco" placeholder="Insira o preço do serviço"
          required>
      </div>
    </div>

    <div class="row">
      <div class="col mb-3">
        <label for="nome" class="form-label">Tempo do Serivço:</label>
        <input type="number" class="form-control" id="tempo" name="tempoMinutos"
          placeholder="Insira o tempo em minutos para realizar o serviço" aria-describedby="tempoMinutospInline"
          required>
        <span id="tempoMinutospInline" class="form-text">O tempo deve ser maior que 10 minutos</span>
      </div>
