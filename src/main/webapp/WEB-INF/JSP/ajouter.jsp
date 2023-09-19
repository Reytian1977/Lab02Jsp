<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

    <div class="container mt-4">
        <h2>Ajouter une évaluation</h2>
        <form  action="${UrlAjouter}" method="post" name="FormAjouter">

            <!-- Numéro, Nom, Prénom -->
            <div class="form-group">
                <label for="numero">Numéro:</label>
                <input type="text" class="form-control" id="numero" name="numero" required>
            </div>
            <div class="form-group">
                <label for="nom">Nom:</label>
                <input type="text" class="form-control" id="nom" name="nom" required>
            </div>
            <div class="form-group">
                <label for="prenom">Prénom:</label>
                <input type="text" class="form-control" id="prenom" name="prenom" required>
            </div>
            <div class="form-group">
                <label for="courriel">Email:</label>
                <input type="email" class="form-control" id="courriel" name="courriel" required>
            </div>
            <div class="form-group">
                <label for="telephone">Telephone:</label>
                <input type="text" class="form-control" id="telephone" name="telephone" required>
            </div>

            <!-- Date d'évaluation -->
            <div class="form-group">
                <label for="dateEvaluation">Date d'évaluation:</label>
                <input type="date" class="form-control" id="dateEvaluation" name="dateEvaluation" required>
            </div>

            <!-- Sexe -->
            <div class="form-group">
                <label>Sexe:</label><br>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="sexe" id="masculin" value="M" required>
                    <label class="form-check-label" for="masculin">Masculin</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="sexe" id="feminin" value="F">
                    <label class="form-check-label" for="feminin">Féminin</label>
                </div>
            </div>

            <!-- Commentaires -->
            <div class="form-group">
                <label for="commentaires">Commentaires:</label>
                <textarea class="form-control" id="commentaires" name="commentaires" rows="4"></textarea>
            </div>

            <!-- Note de l'évaluation -->
            <div class="form-group">
                <label for="note">Note:</label>
                <select class="form-control" id="note" name="note" required>
                    <option>Très bien</option>
                    <option>Bien</option>
                    <option>Moyen</option>
                    <option>Médiocre</option>
                </select>
            </div>

            <!-- Boutons -->
            <button type="submit" class="btn btn-primary">Envoyer</button>
            <a href="${UrlAccueil}" class="btn btn-danger" onclick="return confirm('Voulez-vous vraiment le annuler ?');">Annuler</a>

        </form>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>