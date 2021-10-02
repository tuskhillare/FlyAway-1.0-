package com.controller;


import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.PrintWriter;
import com.table.Admin;
import com.util.HibernateUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


public class Login extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final PrintWriter out = response.getWriter();
        response.setContentType("text/jsp");
        final String user = request.getParameter("username");
        final String password = request.getParameter("password");
        try {
            final SessionFactory sFactory = HibernateUtil.buildSessionFactory();
            final Session session = sFactory.openSession();
            session.beginTransaction();
            final String query = "from Admin a where email = '" + user + "'" + " and password = '" + password + "'";
            String usernamedb = "";
            String namedb = "";
            final HttpSession httpsession = request.getSession();
            final List<Admin> admin = (List<Admin>)session.createQuery(query).list();
            if (admin.size() > 0) {
                for (final Admin i : admin) {
                    usernamedb = i.getEmail();
                    namedb = i.getFirstName();
                }
                httpsession.setAttribute("name", (Object)namedb);
                httpsession.setAttribute("username", (Object)usernamedb);
                response.sendRedirect("Dashboard.jsp");
            }
            else {
                out.print("<a href=\"index.jsp\">Home</a>");
                out.print("<h1>Sorry that username and password does not exist.<h1>");
            }
            session.close();
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}