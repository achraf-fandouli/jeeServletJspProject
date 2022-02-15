package controller;

import dao.GestionClient;
import model.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addperson", value = "/addperson")
public class AddPerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            /*todo output your page here. You may use following sample code*/

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Agent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Agent at " +request.getContextPath()+"</h1>");
            out.println("<h1>appel directement de la servlet</h1>");
            out.println("<h3>=>Alors la méthode doGest() qui s'exécutée par défault</h3>");
            out.println("</body>");
            out.println("</html>");


        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String email=request.getParameter("email");
        String password=request.getParameter("password");

        /*
        request.setAttribute("nomClient",nom);
        request.setAttribute("prenomClient",prenom);
        request.setAttribute("emailClient",email);
        request.setAttribute("passwordClient",password);

        //
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/contact.jsp");
        rd.forward(request,response);

         */

        //creer un client
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setEmail(email);
        client.setPassword(password);
        //creation de l'objet gestion client
        GestionClient agentClient = new GestionClient();
        //initialiser la connection
        agentClient.init();
        //la méthode ajouter_client va appeler la methode persist
        agentClient.ajouter_client(client);

        /*
        PrintWriter out=response.getWriter();
        out.println("client ajouté ");

         */
        response.sendRedirect("./listperson");





//
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out= response.getWriter();
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Servlet Agent</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>Formation JEE</h1>");
//        out.println("<h1>Servlet Agent at " +request.getContextPath()+"</h1>");
//        out.println("<h1>Nom : "+nom+"<h1>");
//        out.println("<h1>Prenom : "+prenom+"<h1>");
//        out.println("<h1>Email : "+email+"<h1>");
//        out.println("<h1>Password : "+password+"<h1>");
//        out.println("</body>");
//        out.println("</html>");

    }
}
