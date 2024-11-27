<%@ page contentType="text/html" pageEncoding="UTF-8"%>
 
<%@ page import="com.dwes.adictosalfutbol.Aposta" %>
<%@ page import="com.dwes.adictosalfutbol.ApostaServicio" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.List" %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC Sample</title>
    </head>
    <body>
        <%
        if (request.getAttribute("single_aposta") != null) {
            Aposta aposta = (Aposta)request.getAttribute("single_aposta");
        %>
        <h1>Aposta Details</h1>
        <div>ID: <%= aposta.getId()%></div>
        <div>Name: <%= aposta.getNomUsuari()%></div>
        <div><a href="Aposta">Go Back</a></div>
 
        <% } else { %>
 
        <h1>Aposta List</h1>
        <table>
            <tr>
                    <td><b>Name</b></td>
                    <td><b>Options</b></td>
            </tr>
            <% for (Aposta aposta : (List<Aposta>)request.getAttribute("aposta_list")) {%>
 
            <tr>
                <td><%= aposta.getNomUsuari()%></td>
                <td><a href="Aposta?id=<%= aposta.getId()%>">Details...</a></td>
            </tr>
            <% }
          }%>
 
        </table>
    </body>
</html>