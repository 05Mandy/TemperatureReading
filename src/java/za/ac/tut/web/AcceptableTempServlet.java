/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.EmployeeFacadeLocal;
import za.ac.tut.entitites.Employee;

/**
 *
 * @author mandy
 */
public class AcceptableTempServlet extends HttpServlet {

    @EJB
    EmployeeFacadeLocal eml;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Employee> employees = eml.getAcceptableTemparature();
        
        request.setAttribute("employees", employees);

        RequestDispatcher disp = request.getRequestDispatcher("acceptable_outcome.jsp");
        disp.forward(request, response);
    }
}
