<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8" />
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
                crossorigin="anonymous" />
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
                crossorigin="anonymous"></script>
            <title>PetShop - Gestão de Aumigos</title>
        </head>

        <body>
            <c:import url="/WEB-INF/jsp/menu.jsp" />
            <div class="container my-4">
                <div class="mb-3">
                    <h1>Relatório:</h1>
                </div>
                <div class="mb-3">
                    <h3>Números atuais:</h3>
                    <ul class="list-group">
                        <li class="list-group-item list-group-item-light">
                            <strong>${tUsuarios}</strong> usuários cadastrados!
                        </li>
                        <li class="list-group-item list-group-item-light">
                            <strong>${tAtendimentos}</strong> atendimentos realizados!
                        </li>
                        <li class="list-group-item list-group-item-light">
                            <strong>${tPets}</strong> pets como clientes!
                        </li>
                        <li class="list-group-item list-group-item-light">
                            <strong>${tServiços}</strong> serviços como finalizados, sendo:
                            <ul>
                                <li>
                                    <strong>${tBanhos}</strong> banhos;
                                </li>
                                <li>
                                    <strong>${tConsultas}</strong> consultas; e
                                </li>
                                <li>
                                    <strong>${tVacinas}</strong> vacinas aplicadas.
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>

        </body>

        </html>