package com.dwes.adictosalfutbol;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ApostaServlet")
public class ApostaServlet extends HttpServlet {

    private final ApostaServicio service = new ApostaServicio();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null || action.equals("list")) {
                // Mostrar la llista d'apostes
                String nomFiltre = request.getParameter("nomUsuari");
                if (nomFiltre != null && !nomFiltre.isEmpty()) {
                    request.setAttribute("aposta_list", service.getApostesByNomUsuari(nomFiltre));
                } else {
                    request.setAttribute("aposta_list", service.getApostes());
                }
                request.setAttribute("nomFiltre", nomFiltre);
                getServletContext().getRequestDispatcher("/aposta.jsp").forward(request, response);

            } else if (action.equals("add")) {
                // Afegir nova aposta
                try {
                    String nomUsuari = request.getParameter("nomUsuari");
                    String enfrontament = request.getParameter("enfrontament");
                    String competicio = request.getParameter("competicio");
                    int golsEquip1 = Integer.parseInt(request.getParameter("golsEquip1"));
                    int golsEquip2 = Integer.parseInt(request.getParameter("golsEquip2"));
                    LocalDate dataPartit = LocalDate.parse(request.getParameter("dataPartit"));
                    double apostaEconomica = Double.parseDouble(request.getParameter("apostaEconomica"));
                    boolean apostaGuanyada = false;

                    Aposta novaAposta = new Aposta(0, nomUsuari, enfrontament, competicio, golsEquip1, golsEquip2, dataPartit, apostaEconomica, apostaGuanyada);
                    service.addAposta(novaAposta);
                    response.sendRedirect("ApostaServlet?action=list");
                } catch (NumberFormatException | DateTimeParseException e) {
                    request.setAttribute("errorMessage", "Error en afegir l'aposta: dades invàlides.");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }

            } else if (action.equals("delete")) {
                // Eliminar aposta
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    service.deleteAposta(id);
                    response.sendRedirect("ApostaServlet?action=list");
                } catch (NumberFormatException e) {
                    request.setAttribute("errorMessage", "Error en eliminar l'aposta: ID invàlid.");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }

            } else if (action.equals("edit")) {
                // Editar aposta existent
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Aposta aposta = service.getApostaById(id);
                    request.setAttribute("aposta", aposta);
                    getServletContext().getRequestDispatcher("/apostaForm.jsp").forward(request, response);
                } catch (NumberFormatException e) {
                    request.setAttribute("errorMessage", "Error en editar l'aposta: ID invàlid.");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }

            } else if (action.equals("update")) {
                // Modificar aposta existent
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String nomUsuari = request.getParameter("nomUsuari");
                    String enfrontament = request.getParameter("enfrontament");
                    String competicio = request.getParameter("competicio");
                    int golsEquip1 = Integer.parseInt(request.getParameter("golsEquip1"));
                    int golsEquip2 = Integer.parseInt(request.getParameter("golsEquip2"));
                    LocalDate dataPartit = LocalDate.parse(request.getParameter("dataPartit"));
                    double apostaEconomica = Double.parseDouble(request.getParameter("apostaEconomica"));
                    boolean apostaGuanyada = false;

                    Aposta apostaActualitzada = new Aposta(id, nomUsuari, enfrontament, competicio, golsEquip1, golsEquip2, dataPartit, apostaEconomica, apostaGuanyada);
                    service.updateAposta(apostaActualitzada);
                    response.sendRedirect("ApostaServlet?action=list");
                } catch (NumberFormatException | DateTimeParseException e) {
                    request.setAttribute("errorMessage", "Error en actualitzar l'aposta: dades invàlides.");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }

            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acció no vàlida");
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", "S'ha produït un error intern: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
