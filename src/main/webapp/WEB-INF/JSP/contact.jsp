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
        <h2>Coordonnées de l'établissement</h2>
        <p><strong>Adresse :</strong> 123 Rue Exemple, Ville, Code postal</p>
        <p><strong>Téléphone :</strong> 0123456789</p>
        <p><strong>Courriel :</strong> exemple@etablissement.com</p>

        <h3>Envoyez-nous un courriel</h3>
        <form  method="post">
            <div class="form-group">
                <label for="nom">Nom:</label>
                <input type="text" class="form-control" id="nom" name="nom" required>
            </div>
            <div class="form-group">
                <label for="courriel">Courriel:</label>
                <input type="email" class="form-control" id="courriel" name="courriel" required>
            </div>
            <div class="form-group">
                <label for="message">Message:</label>
                <textarea class="form-control" id="message" name="message" rows="4" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Envoyer</button>
        </form>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>