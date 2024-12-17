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
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>${requestScope.single_aposta == null ? "Afegir Nova Aposta" : "Editar Aposta"}</h1>
    <form action="Aposta" method="post">
        <input type="hidden" name="action" value="${requestScope.single_aposta == null ? 'add' : 'update'}">

        <c:if test="${requestScope.single_aposta != null}">
            <input type="hidden" name="id" value="${single_aposta.id}">
        </c:if>

        <label>ID:</label>
        <input type="number" name="id" value="${single_aposta != null ? single_aposta.id : ''}" ${single_aposta != null ? 'readonly' : ''} required>

        <label>Nom Usuari:</label>
        <input type="text" name="nomUsuari" value="${single_aposta != null ? single_aposta.nomUsuari : ''}" required>

        <label>Enfrontament:</label>
        <input type="text" name="enfrontament" value="${single_aposta != null ? single_aposta.enfrontament : ''}" required>

        <label>Gols Equip 1:</label>
        <input type="number" name="golsEquip1" value="${single_aposta != null ? single_aposta.golsEquip1 : ''}" required>

        <label>Gols Equip 2:</label>
        <input type="number" name="golsEquip2" value="${single_aposta != null ? single_aposta.golsEquip2 : ''}" required>

        <label>Data del Partit:</label>
        <input type="date" name="dataPartit" value="${single_aposta != null ? single_aposta.dataPartit : ''}" required>

        <label>Aposta Econòmica:</label>
        <input type="number" step="0.01" name="apostaEconomica" value="${single_aposta != null ? single_aposta.apostaEconomica : ''}" required>

        <button type="submit">${requestScope.single_aposta == null ? "Afegir Aposta" : "Modificar Aposta"}</button>
    </form>

    <!-- Tornar al llistat -->
    <div style="text-align: center; margin-top: 20px;">
        <a href="Aposta?action=list">Tornar al Llistat</a>
    </div>
</body>
</html>
