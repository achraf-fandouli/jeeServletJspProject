package controller;

import dao.GestionClient;
import dao.GestionMedecin;
import model.Medecin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updatemedecin", value = "/updatemedecin")
public class UpdateMedecin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        GestionMedecin agentMed = new GestionMedecin();
        agentMed.init();
        Medecin medecin =  agentMed.findMedById(id);
        request.setAttribute("medecin",medecin);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/editmedecin.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id=Long.parseLong(request.getParameter("idMedecin"));
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String spec =request.getParameter("specialite");

        Medecin medecin = new Medecin();
        medecin.setId(id);
        medecin.setNom(nom);
        medecin.setPrenom(prenom);
        medecin.setSpecialite(spec);

        GestionMedecin agentMedecin = new GestionMedecin();
        agentMedecin.init();
        agentMedecin.updateMed(medecin);

        response.sendRedirect("./listmedecin");

    }
}
