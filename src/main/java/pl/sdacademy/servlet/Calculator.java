package pl.sdacademy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Calculator extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        String paramX = req.getParameter("paramX");
        String paramY = req.getParameter("paramY");

        out.println("<html><body>");

        int sum = Integer.parseInt(paramX) + Integer.parseInt(paramY);

        out.println("Suma liczb x i y wynosi " + sum);
        out.println("</body><html>");

        out.close();
    }
}
