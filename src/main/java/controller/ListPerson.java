package controller;

import dao.GestionClient;
import model.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listperson", value = "/listperson")
public class ListPerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        List<Client> persons = new ArrayList();
        Client c1 = new Client(1, "FAN", "Achraf", "achref@gmail.com", "fa45682");
        Client c2 = new Client(2, "Mos", "Rami", "Rami@gmail.com", "1245682");
        Client c3 = new Client(3, "GA", "SAlem", "Salem@gmail.com", "90045682");

        persons.add(c1);
        persons.add(c2);
        persons.add(c3);
*/
        GestionClient agentClient = new GestionClient();
        agentClient.init();
        List<Client> persons = agentClient.findAll();

        request.setAttribute("clients", persons);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/persons.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
