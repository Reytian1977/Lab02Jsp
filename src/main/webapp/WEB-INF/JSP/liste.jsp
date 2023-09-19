<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="fr">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bienvenue</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<!-- Variables -->
<c:url var="UrlAccueil" value="/Accueil/accueil"/>
<c:url var="UrlAjouter" value="/evaluation/ajouter"/>
<c:url var="UrlListe" value="/evaluation/liste"/>
<c:url var="UrlModifier" value="/evaluation/modifier"/>
<c:url var="UrlSupprimer" value="/evaluation/supprimer"/>
<c:url var="UrlContacter" value="/Accueil/contact"/>

    <!-- Menu -->
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${UrlAccueil}">Accueil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${UrlAjouter}">Ajouter évaluation</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href=${UrlListe}>Liste évaluations</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${UrlContacter}">Nous contacter</a>
            </li>
        </ul>
    </nav>

    <div class="container">

        <c:choose>
            <c:when test="${empty listeEvaluation}">
                <p>Il n'y a pas des Evaluations.</p>
            </c:when>
            <c:otherwise>
                <table class="table">
                    <tr>
                        <th>Numéro</th>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Courriel</th>
                        <th>Telephone</th>
                        <th>Sexe</th>
                        <th>Note</th>
                        <th>Date Evaluation</th>
                        <th>Commentaires</th>
                        <th>Actions</th>
                    </tr>

                    <c:forEach var="e" items="${listeEvaluation}">

                        <tr>
                            <td>${e.numero}</td>
                            <td>${e.nom}</td>
                            <td>${e.prenom}</td>
                            <td>${e.courriel}</td>
                            <td>${e.telephone}</td>
                            <td>${e.sexe}</td>
                            <td>${e.note}</td>
                            <td>${e.dateEvaluation}</td>
                            <td>${e.commentaires}</td>
                            <td>
                                <!-- Modifier Button -->
                                <button class="btn btn-primary" onclick="location.href='${UrlModifier}/${e.numero}'">Modifier</button>

                                <!-- Supprimer Button -->
                                <a href="${UrlSupprimer}/${e.numero}" class="btn btn-danger" onclick="return confirm('Voulez-vous vraiment le supprimer ?');">Supprimer</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>