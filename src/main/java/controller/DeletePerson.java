package controller;

import dao.GestionClient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deleteperson", value = "/deleteperson")
public class DeletePerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id= Long.parseLong(request.getParameter("id"));
        /*
        try(PrintWriter out =response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Personne à supprimer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3> Personne à supprimer" + id + "</h3>");
            out.println("</body>");
            out.println("</html>");
        }

         */

        GestionClient agentClient = new GestionClient();
        agentClient.init();
        agentClient.deleteClietnById(id);
        response.sendRedirect("./listperson");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
