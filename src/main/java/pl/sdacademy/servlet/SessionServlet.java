package pl.sdacademy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.stream.StreamSupport;

public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("sessionCounter:" + getAndUpdateSessionCounter(req.getSession()));
        resp.getWriter().write("\n");
        resp.getWriter().write("cookieCounter:" + getAndUpdateCoockieCounter(req, resp));
    }

    private int getAndUpdateCoockieCounter(HttpServletRequest req, HttpServletResponse resp){
        Integer counter = 1;
        for(Cookie cookie : req.getCookies()){
            if(cookie.getName().equals("CounterCookie")){
                counter = Integer.valueOf(cookie.getValue());
                counter++;
                break;
            }
        }
        resp.addCookie(new Cookie("CounterCookie", counter.toString()));
        return counter;
    }

    private int getAndUpdateSessionCounter(HttpSession session){
        Integer counter = (Integer) session.getAttribute("counter");
        if(counter == null){
            counter = 1;
            session.setAttribute("counter", counter);
            return counter;
        }
        else{
            counter++;
            session.setAttribute("counter", counter);
            return counter;
        }

    }
}
