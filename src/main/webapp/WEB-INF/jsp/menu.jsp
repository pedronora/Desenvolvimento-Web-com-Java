<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <nav class="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">PetShop</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/">Home</a>
                    </li>
                    <c:if test="${not empty user}">
                        <li class="nav-item">
                            <a class="nav-link" href="/usuario/lista">Usuário</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/atendimento">Atendimento</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/pet">Pet</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="/servicos" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                Serviços
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/servicos/banho">Banho</a></li>
                                <li><a class="dropdown-item" href="/servicos/consulta">Consulta</a></li>
                                <li><a class="dropdown-item" href="/servicos/vacina">Vacina</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="/servicos">Todos</a></li>
                            </ul>
                        </li>
                    </c:if>
                </ul>
                <ul class="nav navbar-nav navbar-right text-light">
                    <c:if test="${empty user}">
                        <li class="nav-item me-2">
                            <a class="nav-link" href="/usuario"><i class="bi bi-person-fill"></i> Sign Up</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/login"><i class="bi bi-box-arrow-in-right"></i> Login</a>
                        </li>
                    </c:if>
                    <c:if test="${not empty user}">
                        <li class="nav-item">
                            <a class="nav-link" href="/logout"><i class="bi bi-box-arrow-left"></i> Logout - ${user.nome}</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>