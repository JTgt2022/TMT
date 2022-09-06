package newpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanb
 */
@WebServlet(urlPatterns = {"/ParametrosCorreo"})
public class ParametrosCorreo extends HttpServlet {

    private String servidor, puerto, usuario, clave;

    public void init() {

        ServletContext contex = getServletContext();
        servidor = contex.getInitParameter("servidor");
        puerto = contex.getInitParameter("puerto");
        usuario = contex.getInitParameter("usuario");
        clave = contex.getInitParameter("clave");

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destinatario = request.getParameter("destinatario");
        String asunto = request.getParameter("asunto");
        String contenido = request.getParameter("contenido");
        
        String resultado = "";
        
        try {
            EnvioCorreo.enviarCorreo(servidor, puerto, usuario, clave, destinatario, asunto, contenido);
            resultado = "El mensaje se envió correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            resultado = "Error de envió " + e.getMessage();
        }finally{
        request.setAttribute("resultado", resultado);
        getServletContext().getRequestDispatcher("/resultado.jsp").forward(request, response);
        }
    }

}
