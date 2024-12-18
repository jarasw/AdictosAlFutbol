<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulari Aposta</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
            }
            form {
                max-width: 400px;
                margin: auto;
            }
            label {
                display: block;
                margin-top: 10px;
            }
            input {
                width: 100%;
                padding: 8px;
                margin-top: 5px;
            }
            button {
                margin-top: 15px;
                padding: 10px;
                background-color: #CDC1FF;
                color: white;
                border: none;
                cursor: pointer;
            }
            button:hover {
                background-color: #FFCCEA;
            }
        </style>
    </head>
    <body>
        <h1>${requestScope.single_aposta == null ? "Afegir Nova Aposta" : "Editar Aposta"}</h1>
        <form action="ApostaServlet?action=add" method="post">
            <label for="nomUsuari">Nom Usuari:</label>
            <input type="text" id="nomUsuari" name="nomUsuari" required>

            <label for="enfrontament">Enfrontament:</label>
            <input type="text" id="enfrontament" name="enfrontament" required>
            
            <label for="competicio">Competicio</label>
            <input type="text" id="competicio" name="competicio" required>

            <label for="golsEquip1">Gols Equip 1:</label>
            <input type="number" id="golsEquip1" name="golsEquip1" required>

            <label for="golsEquip2">Gols Equip 2:</label>
            <input type="number" id="golsEquip2" name="golsEquip2" required>

            <label for="dataPartit">Data del Partit:</label>
            <input type="date" id="dataPartit" name="dataPartit" required>

            <label for="apostaEconomica">Aposta Econòmica:</label>
            <input type="number" step="0.01" id="apostaEconomica" name="apostaEconomica" required>
            
            <label for="apostaGuanyada">Aposta Guanyada</label>
            <input type="boolean" id="apostaGuanyada" name="apostaGuanyada" required>

            <button type="submit">Afegir Aposta</button>
        </form>

        <!-- Tornar al llistat -->
        <div style="text-align: center; margin-top: 20px;">
            <a href="Aposta?action=list">Tornar al Llistat</a>
        </div>
    </body>
</html>
