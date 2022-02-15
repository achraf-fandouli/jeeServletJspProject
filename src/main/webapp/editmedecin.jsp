<%--
  Created by IntelliJ IDEA.
  User: kolt
  Date: 08/10/2021
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="medecin" scope="request" class="model.Medecin"></jsp:useBean>
<html>

<head>
    <meta charset="UTF-8">
    <title>Mise à jour Medecin</title>

    <!-- css part--->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<!-- js part-->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<main role="main">



    <div class="jumbotron">
        <div class="container">
            Formulaire de mise à jour Medecin

        </div>
        <div class="container">

            <form method="post" action="./updatemedecin">

                <div class="form-group">
                    <label for="nom">Id : </label>
                    <input type="text"  class="form-control" id="idCMedcin" name="idMedecin"
                           value="<jsp:getProperty name="medecin" property="id"/>" readonly="true">
                    <!--<small id="prenomlHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                </div>

                <div class="form-group">
                    <label for="nom">Nom : </label>
                    <input type="text" class="form-control" id="nom" name="nom"  value="<jsp:getProperty name="medecin" property="nom"/>">
                    <!--<small id="prenomlHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                </div>
                <div class="form-group">
                    <label for="prenom">Prenom :</label>
                    <input type="text" class="form-control" id="prenom" name="prenom" value="<jsp:getProperty name="medecin" property="prenom"/>">
                    <!--<small id="prenomlHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                </div>

                <div class="form-group">
                    <label >Specialite : </label>
                    <select class="form-control" id="specialite" name="specialite">
                        <option value="Cheregien">Cheregien</option>
                        <option value="Generaliste">Generaliste</option>
                        <option value="dentiste">dentiste</option>
                    </select>
                </div>

                <!--
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                -->
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>
    </div>
</main>

</body>
</html>