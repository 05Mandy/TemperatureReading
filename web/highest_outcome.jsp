<%-- 
    Document   : highest_outcome
    Created on : 05 Jun 2024, 12:39:57 AM
    Author     : mandy
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entitites.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hight Temperature reading outcome Page</title>
    </head>
    <body>
        <h1>High temperature reading outcome</h1>

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
