<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <meta charset="UTF-8" />
  <title>404 | Page non trouvé</title>
</head>
<body>
<h1>404 Page Not Found</h1>
<p class="text">Vous venez de prendre chemin qui n'existe pas</p>
<a href="${pageContext.request.contextPath}/products" class="go-back-btn">
  Aller sur la page des produits</a>

<details>
  <summary>
    Plus de détails
  </summary>
  <div>
    The request has not been applied because it lacks valid authentication
    credentials for the target resource.
  </div>
</details>
</body>
</html>
