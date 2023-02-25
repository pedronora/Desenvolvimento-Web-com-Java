<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <nav class="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">PetShop</a>
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
                    <li class="nav-item">
                        <a class="nav-link" href="/usuario/lista">Usuário</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Atendimento</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pet</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            Serviços
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Banho</a></li>
                            <li><a class="dropdown-item" href="#">Consulta</a></li>
                            <li><a class="dropdown-item" href="#">Vacina</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right text-light">
                    <li class="nav-item me-2">
                        <a class="nav-link" href="/usuario"><i class="bi bi-person-fill"></i> Sign Up</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login"><i class="bi bi-box-arrow-in-right"></i> Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><i class="bi bi-box-arrow-left"></i> Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>