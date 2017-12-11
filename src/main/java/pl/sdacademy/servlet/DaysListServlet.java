package pl.sdacademy.servlet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sdacademy.dto.DaysDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class DaysListServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(DaysListServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String daysStr = req.getParameter( "days" );
        Integer days=null;
        try {
            days = Integer.valueOf(daysStr);
        }
        catch (NumberFormatException e){
            LOG.error("Incorrect input:  '{}'", daysStr,e);
        }
        catch(NullPointerException e){
            LOG.debug("Empty input for 'days'",e);
        }

        if (days != null) {


            LocalDateTime dt = LocalDateTime.now();

            List <DaysDto> daysList = new LinkedList <>();
            for (int i = 1; i <= days; i++) {
                LocalDateTime after = dt.plusDays( i );
                DaysDto daysDto = new DaysDto();
                daysDto.setAfter( after );
                daysDto.setDaysAfter( i );
                daysList.add( daysDto );
            }
            req.setAttribute( "dupa", daysList ); //list
        }
        else{
            daysStr = "1";
        }
        req.setAttribute( "daysParam", daysStr );
        req.getRequestDispatcher( "views/days.jsp" ).forward( req, resp );
    }
}