package Servlets;

import ManagerInfo.ManagerDao;
import ManagerInfo.ManagerDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class RequestDenial extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ManagerDao dao = ManagerDaoFactory.getDao();
        String reimID = request.getParameter("reimID");

        request.getRequestDispatcher("managerNav.html").include(request, response);
        out.println("<br>");

        boolean result = false;

        try {
            result = dao.denyRequest(reimID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result){
            out.println("Reimbursement Request Denied");
        }else{
            out.println("Something went wrong try again");
        }



    }
}
