<%@ page import="java.util.List" %>
<%@ page import="model.Client" %>
<%@ page import="model.Medecin" %><%--
  Created by IntelliJ IDEA.
  User: kolt
  Date: 12/10/2021
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ajout RDV</title>

    <!-- css part--->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<!-- js part-->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>

            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Gestion client</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="./Person.html">Ajouter client</a>
                    <a class="dropdown-item" href="./listperson">Liste clients</a>

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

            <form method="post" action="./addrdv">
                <div class="form-group">
                    <label for="jour">Nom : </label>
                    <input type="date" class="form-control" id="jour" name="jour" placeholder="jour">
                    <!--<small id="prenomlHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                </div>

                <div class="form-group">
                    <label >Liste Clients : </label>
                    <select class="form-control" id="client" name="client">
                        <%
                            List<Client> listClient = (List<Client>) request.getAttribute("clients");
                            for(Client c : listClient){
                        %>
                        <option value="<%=c.getId()%>"> <%=c.getNom()%> <%=c.getPrenom()%></option>

                        <%
                            }
                        %>
                    </select>
                </div>


                <div class="form-group">
                    <label >Liste Medecins : </label>
                    <select class="form-control" id="medecin" name="medecin">
                        <%
                            List<Medecin> listMed = (List<Medecin>) request.getAttribute("medecins");
                            for(Medecin c : listMed){
                        %>
                        <option value="<%=c.getId()%>"> <%=c.getNom()%> <%=c.getPrenom()%></option>

                        <%
                            }
                        %>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>
    </div>
</main>

</body>
</html>
