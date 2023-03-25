<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  
<input type="text" name="cep" value="${endereco.cep}" hidden>
<div class="row mb-3">
    <div class="col">
        <label for="logradouro" class="form-label">Logradouro:</label>
        <input type="text" class="form-control" id="logradouro" name="logradouro" value="${endereco.logradouro}" readonly>
    </div>
    <div class="col-3">
        <label for="num" class="form-label">Número:</label>
        <input type="number" class="form-control" id="num" name="num" required>
    </div>
</div>
<div class="row mb-3">
    <div class="col">
        <label for="complemento" class="form-label">Complemento:</label>
        <input type="text" class="form-control" id="complemento" name="complemento">
    </div>
    <div class="col-3">
        <label for="bairro" class="form-label">Bairro:</label>
        <input type="text" class="form-control" id="bairro" name="bairro" value="${endereco.bairro}" readonly>
    </div>
</div>
<div class="row mb-3">
    <div class="col">
        <label for="localidade" class="form-label">Cidade:</label>
        <input type="text" class="form-control" id="localidade" name="localidade" value="${endereco.localidade}" readonly>
    </div>
    <div class="col">
        <label for="uf" class="form-label">Estado:</label>
        <input type="text" class="form-control" id="uf" name="uf" value="${endereco.uf}" readonly>
    </div>
</div>
