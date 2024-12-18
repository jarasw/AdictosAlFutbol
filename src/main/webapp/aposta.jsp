<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.dwes.adictosalfutbol.Aposta" %>
<%@ page import="com.dwes.adictosalfutbol.ApostaServicio" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Llistat d'Apostes</title>
        <style>
            table {
                width: 70%;
                margin: 20px auto;
                border-collapse: collapse;
            }
            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: center;
            }
            th {
                background-color: #4CAF50;
                color: white;
            }
            form {
                text-align: center;
                margin-bottom: 20px;
            }
            a {
                text-decoration: none;
                color: blue;
                margin: 5px;
            }
        </style>
    </head>
    <body>
        <h1 style="text-align: center;">Llistat d'Apostes</h1>

        <!-- Formulari per filtrar per nom d'usuari -->
        <form method="get" action="ApostaServlet">
            <label for="nomUsuari">Filtrar per nom d'usuari:</label>
            <input type="text" id="nomUsuari" name="nomUsuari" value="${nomFiltre}">
            <button type="submit">Buscar</button>
        </form>
            
        <!-- Formulari per filtrar per enfrontament -->
        <form method="get" action="ApostaServlet">
            <label for="enfrontament">Filtrar per enfrontament:</label>
            <input type="text" id="enfrontament" name="enfrontament" value="${nomFiltre}">
            <button type="submit">Buscar</button>
        </form>

        <!-- Formulari per filtrar per rang d'aposta -->
        <form method="get" action="ApostaServlet">
            <label for="apostaEconomica">Filtrar per rang d'aposta:</label>
            <input type="text" id="apostaEconomica" name="apostaEconomica" value="${nomFiltre}">
            <button type="submit">Buscar</button>
        </form>

        <!-- Taula d'apostes -->
        <table>
            <tr>
                <th>Nom d'Usuari</th>
                <th>Enfrontament</th>
                <th>Competicio</th>
                <th>Resultat</th>
                <th>Data del Partit</th>
                <th>Quantitat Apostada</th>
                <th>Guanyadora</th>
                <th>Accions</th>
            </tr>
            <c:forEach var="aposta" items="${aposta_list}">
                <tr>
                    <td>${aposta.nomUsuari}</td>
                    <td>${aposta.enfrontament}</td>
                    <td>${aposta.competicio}</td>
                    <td>${aposta.golsEquip1} - ${aposta.golsEquip2}</td>
                    <td>${aposta.dataPartit}</td>
                    <td>${aposta.apostaEconomica} €</td>
                    <td>${aposta.apostaGuanyadora}</td>
                    <td>
                        <!-- Editar i eliminar -->
                        <a href="apostaForm.jsp?id=${aposta.id}">Editar</a>
                        <a href="ApostaServlet?action=delete&id=${aposta.id}" onclick="return confirm('Estàs segur de voler eliminar aquesta aposta?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <!-- Afegir una nova aposta -->
        <div style="text-align: center;">
            <a href="apostaForm.jsp">Afegir Nova Aposta</a>
        </div>
    </body>
</html>
