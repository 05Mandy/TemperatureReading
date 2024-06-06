<%-- 
    Document   : occurence_outcome
    Created on : 06 Jun 2024, 2:02:05 AM
    Author     : mandy
--%>

<%@page import="za.ac.tut.entitites.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>occasion outcome Page</title>
    </head>
    <body>
        <h1>Employee who registered high temperature on more than two occasion</h1>

         <%
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
        %>

        <%
            for (Employee e : employees) {
                Long id = e.getId();
                String name = e.getName();
                String outcome = e.getOutcome();
        %>
        <table>
            <tr>
                <td><strong>ID:</strong>  <%=id%></td>
            </tr>
 
            <tr>
                <td><strong>Name:</strong>  <%=name%></td>
            </tr>

            <%
                List<Double> myTemp = e.getTemp();
                for (Double t : myTemp) {
            %>
            <tr>  
                <td><strong>Temperature Reading:</strong>  <%=t%></td>
            </tr>

            <%
                }
            %>

            <tr>
                <td><strong>Outcome:</strong>  <%=outcome%></td>
            </tr>
        </table>

        <%
            }
        %>

        <p>
            Please click <a href="menu.html">here</a> to go back to the menu page
            OR <a href="index.html">here</a> to go back to the main page
        </p>
    </body>
</html>
