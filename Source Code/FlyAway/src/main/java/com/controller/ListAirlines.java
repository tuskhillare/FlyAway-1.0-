package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.PrintWriter;
import com.table.Airline;
import com.util.HibernateUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;


public class ListAirlines extends HttpServlet
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
            final String query = "from Airline";
            final List<Airline> airlines = (List<Airline>)session.createQuery(query).list();
            if (airlines.size() > 0) {
                out.println("<h1>List of all Airlines: </h1>");
                out.println("<style> table,th,td { border : 1px solid black ; padding :15px;} </style>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>");
                out.println("Airline ID");
                out.println("</th>");
                out.println("<th>");
                out.println("Airline Name");
                out.println("</th>");
                out.println("</tr>");
                for (final Airline i : airlines) {
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(i.getId());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(i.getAirline());
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            }
            else {
                out.print("<a href=\"index.jsp\">Home</a>");
                out.print("<h1>Sorry there are no airlines available!<h1>");
            }
            out.close();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    }
}