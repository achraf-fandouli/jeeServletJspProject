package controller;

import dao.GestionClient;
import dao.GestionMedecin;
import dao.GestionRdv;
import model.Client;
import model.Medecin;
import model.Rdv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "addrdv", value = "/addrdv")
public class AddRdv extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionClient agentClient = new GestionClient();
        agentClient.init();
        List<Client>  clients = agentClient.findAll();

        GestionMedecin agentMedecin = new GestionMedecin();
        agentMedecin.init();
        List<Medecin>  medecins = agentMedecin.findAll();

        request.setAttribute("clients",clients);
        request.setAttribute("medecins",medecins);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/addrdv.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jour= request.getParameter("jour");
        Long idc = Long.parseLong(request.getParameter("client"));
        Long idm = Long.parseLong(request.getParameter("medecin"));

        GestionClient agentClient = new GestionClient();
        agentClient.init();
        Client client = agentClient.findClientById(idc);


        GestionMedecin agentMed = new GestionMedecin();
        agentMed.init();
        Medecin medecin  = agentMed.findMedById(idm);

        Rdv rdv = new Rdv();
        rdv.setJour(jour);
        rdv.setClient(client);
        rdv.setMedecin(medecin);

        GestionRdv agentRdv = new GestionRdv();
        agentRdv.init();
        agentRdv.ajoutRdv(rdv);

        response.getWriter().println("Rdv ajoute avec succes");



    }
}
