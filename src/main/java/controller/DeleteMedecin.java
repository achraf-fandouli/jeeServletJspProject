package controller;

import dao.GestionClient;
import dao.GestionMedecin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deletemedecin", value = "/deletemedecin")
public class DeleteMedecin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id =Long.parseLong(request.getParameter("id"));
        GestionMedecin agentMed = new GestionMedecin();
        agentMed.init();
        agentMed.deleteMedecin(id);

        response.sendRedirect("./listmedecin");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
