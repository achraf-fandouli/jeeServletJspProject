package controller;

import dao.GestionClient;
import model.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updateperson", value = "/updateperson")
public class UpdatePerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id=Long.parseLong(request.getParameter("id"));

        //Client c = new Client(id,"Ben foulen","foulen","foulen@gmail.com","foulen123*");

        GestionClient agentClient  = new GestionClient();
        agentClient.init();
        Client c = agentClient.findClientById(id);

        request.setAttribute("client",c);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/editClient.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id=Long.parseLong(request.getParameter("idClient"));
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        Client c = new Client(id,nom,prenom,email,password);

        GestionClient agentClient = new GestionClient();
        agentClient.init();
        agentClient.updateClient(c);
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("./listperson");
//        rd.forward(request,response);
        response.sendRedirect("./listperson");
    }
}
