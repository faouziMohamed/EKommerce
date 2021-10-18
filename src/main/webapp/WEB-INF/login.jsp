<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css">
  <title>Login</title>
</head>
<body>
<!-- navbar pour tous les page -->
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
  <a class="navbar-brand" href="#">EkomApp</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse"
          data-target="#navbarNav" aria-controls="navbarNav"
          aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div
    class="collapse navbar-collapse"
    id="navbarNav"
  >
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Accueil <span
          class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Tous les produits</a>
      </li>
    </ul>
  </div>
</nav>
<div class="container mt-5">
  <div class="p-3 shadow border border-sm rounded">
    <h1>Connexion</h1>
    <section class="body-content">
      <jsp:useBean id="error" scope="request" class="java.lang.String"/>
      <c:if test="${!empty error}">
      <section class="auth-msg">
        <p class="error-message">
          <c:out value="${error}"/>
        </p>
      </section>
      </c:if>
      <form action="${pageContext.request.contextPath}/login" method="POST">
        <div class="form-group">
          <label for="email">Email</label>
          <input type="email" class="form-control" id="email" name="email"
                 required
                 aria-describedby="emailHelp" placeholder="Enter email">
        </div>
        <div class="form-group">
          <label for="password">Mot de passe</label>
          <input type="password" class="form-control" id="password"
                 name="password"
                 required
                 placeholder="Password">
        </div>
        <button type="submit" class="btn btn-success mt-2">Se connecter</button>
      </form>
  </div>
</div>
</body>
</html>