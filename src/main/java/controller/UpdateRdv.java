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

@WebServlet(name = "updaterdv", value = "/updaterdv")
public class UpdateRdv extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));

        GestionRdv agentRdv = new GestionRdv();
        agentRdv.init();
        Rdv rdv = agentRdv.findRdvById(id);
        request.setAttribute("rdv",rdv);

        GestionClient agentClient = new GestionClient();
        agentClient.init();
        List<Client> clients = agentClient.findAll();
        request.setAttribute("clients", clients);

        GestionMedecin agentMedecin = new GestionMedecin();
        agentMedecin.init();
        List<Medecin> medecins = agentMedecin.findAll();
        request.setAttribute("medecins",medecins);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/editrdv.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("idr"));
        String jour = request.getParameter("jour");
        Long idc = Long.parseLong(request.getParameter("client"));
        Long idm = Long.parseLong(request.getParameter("medecin"));

        GestionClient agent = new GestionClient();
        agent.init();
        Client client = agent.findClientById(idc);

        GestionMedecin agent2 = new GestionMedecin();
        agent2.init();
        Medecin medecin = agent2.findMedById(idm);
        Rdv rdv = new Rdv();
        rdv.setId(id);
        rdv.setJour(jour);
        rdv.setClient(client);
        rdv.setMedecin(medecin);

        GestionRdv agentrdv = new GestionRdv();
        agentrdv.init();
        agentrdv.updateRdv(rdv);

        response.sendRedirect("./listrdvs");

    }
}
