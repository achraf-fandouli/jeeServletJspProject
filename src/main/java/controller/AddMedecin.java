package controller;

import dao.GestionClient;
import dao.GestionMedecin;
import model.Medecin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addmedecin", value = "/addmedecin")
public class AddMedecin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //receperer les donner depuis html
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String spec=request.getParameter("specialite");

        //creation objet
        Medecin medecin = new Medecin();
        medecin.setNom(nom);
        medecin.setPrenom(prenom);
        medecin.setSpecialite(spec);

        //c'est le fournisseur qui assure la couche persistance (ajouter dans la base)
        GestionMedecin agentMedecin = new GestionMedecin();
        agentMedecin.init();
        agentMedecin.ajoutMedecin(medecin);

        response.sendRedirect("./listmedecin");


    }
}
