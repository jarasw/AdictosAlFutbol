package com.dwes.adictosalfutbol;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.time.LocalDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/Aposta")
public class ApostaController extends HttpServlet {

    private ApostaServicio apostaServicio;

    @Override
    public void init() throws ServletException {
        // Inicialització del servei d'apostes
        apostaServicio = ApostaServicio.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nomUsuari = request.getParameter("nomUsuari");

            // Obtenir la llista d'apostes, filtrada pel nom d'usuari si s'ha especificat
            List<Aposta> apostes;
            if (nomUsuari != null && !nomUsuari.isEmpty()) {
                apostes = apostaServicio.getApostesByNomUsuari(nomUsuari);
            } else {
                apostes = apostaServicio.getApostes();
            }

            // Establir atributs per passar-los al JSP
            request.setAttribute("aposta_list", apostes);
            request.setAttribute("nomFiltre", nomUsuari);

            // Redirigir al JSP de llistat d'apostes
            RequestDispatcher dispatcher = request.getRequestDispatcher("aposta.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al mostrar les apostes.");
        }
        
        try {
            String enfrontament = request.getParameter("enfrontament");

            // Obtenir la llista d'apostes, filtrada pel enfrontament si s'ha especificat
            List<Aposta> apostes;
            if (enfrontament != null && !enfrontament.isEmpty()) {
                apostes = apostaServicio.getApostesByEnfrontament(enfrontament);
            } else {
                apostes = apostaServicio.getApostes();
            }

            // Establir atributs per passar-los al JSP
            request.setAttribute("aposta_list", apostes);
            request.setAttribute("enfrontamentFiltre", enfrontament);

            // Redirigir al JSP de llistat d'apostes
            RequestDispatcher dispatcher = request.getRequestDispatcher("aposta.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al mostrar les apostes.");
        }
        
        try {
            LocalDate dataPartit = request.getParameter("dataPartit");

            // Obtenir la llista d'apostes, filtrada per la data si s'ha especificat
            List<Aposta> apostes;
            if (dataPartit != null && !dataPartit.isEmpty()) {
                apostes = apostaServicio.getApostesByData(dataPartit);
            } else {
                apostes = apostaServicio.getApostes();
            }

            // Establir atributs per passar-los al JSP
            request.setAttribute("aposta_list", apostes);
            request.setAttribute("dataPartitFiltre", dataPartit);

            // Redirigir al JSP de llistat d'apostes
            RequestDispatcher dispatcher = request.getRequestDispatcher("aposta.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al mostrar les apostes.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("action");

            if ("add".equals(action)) {
                // Recollir dades del formulari
                String nomUsuari = request.getParameter("nomUsuari");
                String enfrontament = request.getParameter("enfrontament");
                String competicio = request.getParameter("competicio");
                String golsEquip1Str = request.getParameter("golsEquip1");
                String golsEquip2Str = request.getParameter("golsEquip2");
                String dataPartitStr = request.getParameter("dataPartit");
                String apostaEconomicaStr = request.getParameter("apostaEconomica");
                String apostaGuanyadaStr = request.getParameter("apostaGuanyada");

                // Validacions
                if (nomUsuari == null || nomUsuari.trim().isEmpty()
                        || enfrontament == null || enfrontament.trim().isEmpty()
                        || competicio == null || competicio.trim().isEmpty()
                        || golsEquip1Str == null || golsEquip2Str == null
                        || dataPartitStr == null || apostaEconomicaStr == null || apostaGuanyadaStr == null) {
                    throw new IllegalArgumentException("Falten dades obligatòries.");
                }

                int golsEquip1 = Integer.parseInt(golsEquip1Str);
                int golsEquip2 = Integer.parseInt(golsEquip2Str);
                double apostaEconomica = Double.parseDouble(apostaEconomicaStr);
                LocalDate dataPartit = LocalDate.parse(dataPartitStr);
                boolean apostaGuanyada = false;

                // Crear l'aposta
                Aposta aposta = new Aposta(nomUsuari, enfrontament, competicio, golsEquip1, golsEquip2, dataPartit, apostaEconomica, apostaGuanyada);

                // Afegir l'aposta al servei
                apostaServicio.addAposta(aposta);

                // Redirigir a la pàgina principal
                response.sendRedirect("Aposta");
            } else if ("delete".equals(action)) {
                // Eliminar aposta
                int id = Integer.parseInt(request.getParameter("id"));
                apostaServicio.deleteAposta(id);

                // Redirigir a la pàgina principal
                response.sendRedirect("Aposta");
            }
        } catch (IOException | IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en l'aposta.");
        }
    }
}
