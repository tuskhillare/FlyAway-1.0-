package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.PrintWriter;
import com.util.HibernateUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


public class SourceDestination extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.print("<a href=\"Dashboard.jsp\">Dashboard</a><br/><hr>");
        out.print("<h1>Master View</h1>");
        try {
            final SessionFactory sFactory = HibernateUtil.buildSessionFactory();
            final Session session = sFactory.openSession();
            session.beginTransaction();
            final String query = "select source, destination from Flight";
            final List<Object[]> flights = (List<Object[]>)session.createQuery(query).list();
            if (flights.size() > 0) {
                out.println("<h1>List of all Source/Destinations: </h1>");
                out.println("<style> table,th,td { border : 1px solid black ; padding :15px;} </style>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>");
                out.println("Source");
                out.println("</th>");
                out.println("<th>");
                out.println("Destination");
                out.println("</th>");
                out.println("</tr>");
                for (final Object[] i : flights) {
                    out.println("<tr>");
                    out.println("<td>");
                    out.println((String)i[0]);
                    out.println("</td>");
                    out.println("<td>");
                    out.println((String)i[1]);
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            }
            else {
                out.print("<a href=\"Dashboard.jsp\">Home</a>");
                out.print("<h1>Sorry there are no flights currently!<h1>");
            }
            session.close();
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    }
}