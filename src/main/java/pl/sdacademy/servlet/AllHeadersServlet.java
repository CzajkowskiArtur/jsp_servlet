package pl.sdacademy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class AllHeadersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headrNames = req.getHeaderNames();
        resp.addHeader("dupa","dupa1");
        Cookie cookie =new Cookie("dupneCiasteczko","123");
        resp.addCookie(cookie);

        while (req.getHeaderNames().hasMoreElements()) {
            String header = headrNames.nextElement();
            //        resp.getWriter().write(header + ":" + req.getHeader(header));  sklejenie stringow jako jeden;

            resp.getWriter().write(header);
            resp.getWriter().write(":");
            resp.getWriter().write(req.getHeader(header));
            resp.getWriter().write("\n");

        }
    }
}
