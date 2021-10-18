<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link
    rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
  />
  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css"
  />

  <title>Produit</title>
</head>
<body>
<div class="container mt-5">
  <div class="shadow p-5 rounded">
    <h2>Ajouter un produit</h2>
    <form>
      <div class="form-group">
        <label for="urlImg">Url de l'image</label>
        <input
          type="text"
          class="form-control"
          id="urlImg"
          name="urlImg"
          aria-describedby="textHelp"
          placeholder="Entrer l'url de l'image"
        />
        <!-- <small class="form-text text-muted">l'image est requis</small> -->
      </div>
      <div class="form-group">
        <label for="title">Le Titre</label>
        <input
          type="text"
          id="title"
          name="title"
          class="form-control"
          placeholder="Entre le titre du produit"
        />
      </div>
      <div class="form-group">
        <label for="description">La Description</label>
        <input
          type="text"
          name="description"
          id="description"
          class="form-control"
          placeholder="Entre la description du produit"
        />
      </div>
      <div class="form-group">
        <label for="price">Le Prix</label>
        <input
          type="number"
          name="price"
          id="price"
          class="form-control"
          placeholder="Entre le prix du produit"
        />
      </div>
      <div class="my-2">
        <button type="submit" class="btn btn-primary">Enregistrer</button>
      </div>
    </form>
  </div>
</div>
</body>
</html>
