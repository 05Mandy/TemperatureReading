/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
public class AddServlet extends HttpServlet {

    @EJB
    EmployeeFacadeLocal eml;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        
        List<Double> temperature =  new ArrayList<>();
        String[] tempArray = request.getParameterValues("temp");
   
        Date time = new Date();
        String outcome = "Acceptable";

        if(tempArray != null)
        {
            for (String t : tempArray)
            {
                Double temp = Double.parseDouble(t);
                temperature.add(temp);
                
                if(temp >= 38){
                    outcome = "High";
                }
            }
        }
        
        Employee employee = createEmployee(id, name, temperature, outcome, time);
        eml.create(employee);

        RequestDispatcher disp = request.getRequestDispatcher("add_outcome.jsp");
        disp.forward(request, response);

    }

    private Employee createEmployee(Long id, String name, List<Double> temperature, String outcome, Date time) {

        Employee e = new Employee();

        e.setId(id);
        e.setName(name);
        e.setTemp(temperature);
        e.setTime(time);
        e.setOutcome(outcome);
        return e;
    }
}
