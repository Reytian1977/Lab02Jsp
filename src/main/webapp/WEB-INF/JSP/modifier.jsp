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
<c:url var="UrlAccueil" value="/evaluation/index"/>
<c:url var="UrlAjouter" value="/evaluation/ajouter"/>
<c:url var="UrlListe" value="/evaluation/liste"/>
<c:url var="UrlModifier" value="/evaluation/modifier"/>
<c:set var="evaluation" value="${requestScope.evaluation}"/>
<!--<fmt:formatDate value="${evaluation.dateEvaluation.time}" pattern="dd-MM-yyyy" var="dateEvaluation" />-->

    <div class="container mt-5">
        <h2>Modifier l'Évaluation</h2>

        <form action="${UrlModifier}" method="post">
            <input type="hidden" name="numero" value="${evaluation.numero}">

            <div class="mb-3">
                <label for="nom" class="form-label">Nom</label>
                <input type="text" class="form-control" id="nom" name="nom" value="${evaluation.nom}">
            </div>

            <div class="mb-3">
                <label for="prenom" class="form-label">Prénom</label>
                <input type="text" class="form-control" id="prenom" name="prenom" value="${evaluation.prenom}">
            </div>

            <div class="mb-3">
                <label for="courriel" class="form-label">Courriel</label>
                <input type="email" class="form-control" id="courriel" name="courriel" value="${evaluation.courriel}">
            </div>

            <div class="mb-3">
                <label for="telephone" class="form-label">Téléphone</label>
                <input type="text" class="form-control" id="telephone" name="telephone" value="${evaluation.telephone}">
            </div>

            <div class="mb-3">
                <label for="sexe" class="form-label">Sexe</label>
                <select class="form-control" id="sexe" name="sexe">
                    <option value="M" >Masculin</option>
                    <option value="F" >Féminin</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="note" class="form-label">Note</label>
                <textarea class="form-control" id="note" name="note">${evaluation.note}</textarea>
            </div>

            <div class="form-group">
                <label for="dateEvaluation">Date d'évaluation:</label>
                <input type="date" class="form-control" id="dateEvaluation" name="dateEvaluation" value="<fmt:formatDate value="${evaluation.dateEvaluation.time}" pattern="yyyy-MM-dd"/>" required>
            </div>

            <div class="mb-3">
                <label for="commentaire" class="form-label">Commentaires</label>
                <textarea class="form-control" id="commentaire" name="comentaire">${evaluation.commentaires}</textarea>
            </div>

            <button type="submit" class="btn btn-primary">Sauvegarder les modifications</button>
        </form>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>