/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.ClienteDAO;
import ModeloVO.ClienteVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "ClienteControlador", urlPatterns = {"/Cliente"})
public class ClienteControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String IdCliente = request.getParameter("TextId");
        String NombreCliente = request.getParameter("TextNombre");
        String ApellidoCliente = request.getParameter("TextApellido");
        String TipoDocCliente = request.getParameter("TextTipo");
        String NumeroDocCliente = request.getParameter("TextNumDoc");
        String TelefonoCliente = request.getParameter("TextTelefono");
        String DirecionCliente = request.getParameter("TextDir");
        String CorreoCliente = request.getParameter("TextCorreo");
        String EstadoCliente = request.getParameter("TextEstado");
        int opcion = Integer.parseInt(request.getParameter("opcion"));    
        
        ClienteVO ClVO = new ClienteVO(IdCliente, NombreCliente, ApellidoCliente, TipoDocCliente, NumeroDocCliente, TelefonoCliente, DirecionCliente, CorreoCliente, EstadoCliente);
        
        ClienteDAO ClDAO = new ClienteDAO(ClVO);
        switch (opcion) {

            case 1: //Agregar Registro
                if (ClDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "<center><h2>El Cliente se registro correctamente</h2></center>");

                } else {
                    request.setAttribute("mensajeError", "<center><h2>El Cliente NO se registro correctamente</h2></center>");

                }
                request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
                break;
            case 2:  //Actualizar REgistro
                if (ClDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "<center><h2>El Cliente se actualizo correctamente</center></h2>");

                } else {
                    request.setAttribute("mensajeError", "<center><h2>El Cliente NO se actualizo correctamente</center></h2>");

                }
                request.getRequestDispatcher("ConsultarCliente.jsp").forward(request, response);
                break;

            case 3:

                ClienteVO cli =  ClDAO.consultarDocumento(NumeroDocCliente);
                if (cli != null) {

                    request.setAttribute("clienteConsultado", cli);
                    request.setAttribute("mensajeExito", "<center><h2>Cliente consultado</center></h2>");
                    request.getRequestDispatcher("ActualizarCliente.jsp").forward(request, response);
                } else {

                    request.setAttribute("mensajeError", "<center><h2>El Cliente NO existe!</center></h2>");
                    request.getRequestDispatcher("ConsultarCliente.jsp").forward(request, response);

                }
                break;

           

            case 4: //Eliminar Registro
                if (ClDAO.eliminarRegistro()) {
                    request.setAttribute("mensajeExito", "El Cliente se elimino correctamente ");
                } else {
                    request.setAttribute("mensajeError", "El Cliente No se elimino correctamente ");
                }
                request.getRequestDispatcher("EliminarCliente.jsp").forward(request, response);
                break;
        }

    }




    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
