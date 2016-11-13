package servlet;

import calendar.interfaces.Calendar;
import calendar.web.WebCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by yurik on 13.11.16.
 */
@WebServlet({"/calendar"})
public class CalendarServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Calendar calendar;
        try {
            calendar = new WebCalendar(getDate(req.getParameter("date")),
                    getStartDay(req.getParameter("custom_week")),
                    getWeekends(req.getParameter("weekends")));
        }catch (Exception e){
            calendar = new WebCalendar();
        }
        String stringCalendar =
                "<table>" +
                "<tr><a href=\"/\">Back</a></tr><br>" +
                calendar.getCurrentMonthHeader() +
                calendar.getWeekNames() +
                calendar.getMonthValues() +
                "</table>" ;
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/calendar.jsp");
        req.setAttribute("calendar", stringCalendar);
        dispatcher.forward(req, resp);
    }

    private List<DayOfWeek> getWeekends(String weekends) {
        List<DayOfWeek> listWeekends = new ArrayList<>();
        if (weekends.isEmpty()) {
            return Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        }
        int numberDay = 0;
        for (String s : weekends.split(",")) {
            numberDay = parseInt(s.trim());
            if ( numberDay >= DayOfWeek.MONDAY.getValue() && numberDay <= DayOfWeek.SUNDAY.getValue())
                listWeekends.add(DayOfWeek.of(numberDay));
        }
        return listWeekends;
    }

    private DayOfWeek getStartDay(String s) {
        return DayOfWeek.of(parseInt(s));
    }

    private LocalDate getDate(String s) {
        String[] array = s.split("-");
        return LocalDate.of(parseInt(array[0]), parseInt(array[1]), parseInt(array[2]));
    }
}
