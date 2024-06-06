<%-- 
    Document   : login_error
    Created on : 06 Jun 2024, 4:01:59 PM
    Author     : mandy
--%>

<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error Page</title>
    </head>
    <body>
        <h1>Login Error</h1>

        <p style="color: red">
            <strong>Invalid login details!!! Please enter correct details</strong>
        </p>

        <form action="j_security_check" method="POST">
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="j_username" required=""/></td>
                </tr>

                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="j_password" required=""/></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" value="LOGIN"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
