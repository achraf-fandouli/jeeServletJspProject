package controller;

import dao.GestionMedecin;
import dao.GestionRdv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleterdv", value = "/deleterdv")
public class DeleteRdv extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id =Long.parseLong(request.getParameter("id"));
        GestionRdv agentRdv = new GestionRdv();
        agentRdv.init();
        agentRdv.deleteRdv(id);

        response.sendRedirect("./listrdvs");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
