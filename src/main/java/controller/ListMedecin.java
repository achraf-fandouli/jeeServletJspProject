package controller;

import dao.Gestion;
import dao.GestionMedecin;
import model.Medecin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listmedecin", value = "/listmedecin")
public class ListMedecin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionMedecin agentMed = new GestionMedecin();
        agentMed.init();
        List<Medecin> res= agentMed.findAll();
        request.setAttribute("meds",res);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/medecins.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
