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
        <title>MVC AdictosAlFutbol </title>
    </head>
    <body>
        <%
            if (request.getAttribute("single_aposta") != null) {
                Aposta aposta = (Aposta) request.getAttribute("single_aposta");
        %>
        <h1>Detalls de l'Aposta</h1>
        <div><b>ID:</b> <%= aposta.getId() %></div>
        <div><b>Nom:</b> <%= aposta.getNomUsuari() %></div>
        <div><b>Enfrontament:</b> <%= aposta.getEnfrontament() %></div>
        <div><b>Predicció de Gols:</b> <%= aposta.getGolsEquip1() %> - <%= aposta.getGolsEquip2() %></div>
        <div><b>Data del Partit:</b> <%= aposta.getDataPartit() %></div>
        <div><b>Quantitat Apostada:</b> <%= new DecimalFormat("#0.00").format(aposta.getApostaEconomica()) %> €</div>
        <div><a href="Aposta">Tornar</a></div>

        <% } else { %>

        <h1>Llista d'Apostes</h1>
        <table border="1">
            <tr>
                <td><b>Nom</b></td>
                <td><b>Enfrontament</b></td>
                <td><b>Predicció de Gols</b></td>
                <td><b>Opcions</b></td>
            </tr>
            <% 
                for (Aposta aposta : (List<Aposta>) request.getAttribute("aposta_list")) { 
            %>
            <tr>
                <td><%= aposta.getNomUsuari() %></td>
                <td><%= aposta.getEnfrontament() %></td>
                <td><%= aposta.getGolsEquip1() %> - <%= aposta.getGolsEquip2() %></td>
                <td><a href="Aposta?id=<%= aposta.getId() %>">Detalls...</a></td>
            </tr>
            <% } 
                } 
            %>
        </table>
    </body>
</html>
