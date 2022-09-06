/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.EmpresaProveedoraDAO;
import ModeloVO.EmpresaProveedoraVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jtgt2
 */
@WebServlet(name = "EmpresaProveedoraControlador", urlPatterns = {"/EmpresaProveedora"})
public class EmpresaProveedoraControlador extends HttpServlet {

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
      
        String IdEmpresaProveedora=request.getParameter("txtid");
        String NitEmpresaProveedora=request.getParameter("txtNit");
        String RazonSocialEmpresaProveedora=request.getParameter("txtRazon");
        String NombreComercialEmpresaProveedora=request.getParameter("txtNombreC");
        String DireccionEmpresaProveedora=request.getParameter("txtDireccion");
        String TelefonoEmpresaProveedora=request.getParameter("txtTelefono");
        String Numeropago=request.getParameter("txtNumero");
        String EstadoEmpresaProveedora=request.getParameter("txtEstado");
       
        
        
        int opcion= Integer.parseInt(request.getParameter("opcion"));
        
        //2¿ Quién tien elos datos de forma segura ? VO
        EmpresaProveedoraVO epVO= new EmpresaProveedoraVO(IdEmpresaProveedora, NitEmpresaProveedora, RazonSocialEmpresaProveedora, NombreComercialEmpresaProveedora, DireccionEmpresaProveedora, TelefonoEmpresaProveedora, Numeropago,EstadoEmpresaProveedora);
        
        //3¿Quién hace las operaciones? DAO
                
         EmpresaProveedoraDAO epDAO = new EmpresaProveedoraDAO(epVO);
         
         
         
          //Administrar operaciones
        switch (opcion) {

           case 1: //Agregar proveedor
                if (epDAO.agregarRegistro()) {

                    request.setAttribute("MensajeExito", "<center=red><h2>La empresa se registró correctamente</h2></center>");

                } else {
                    request.setAttribute("MensajeError", "<center=red><h2>La empresa  no se registró correctamente</h2></center>");
                }

                request.getRequestDispatcher("registrarProveedor.jsp").forward(request, response);
                break;
            case 2: //Actualizar Registro 
                if (epDAO.actualizarRegistro()) {

                    request.setAttribute("MensajeExito ", "La empresa se actualizó correctamente");

                } else {
                    request.setAttribute("MensajeError ", "La empresa no se actualizó correctamente");
                }

                request.getRequestDispatcher("ConsultarProveedor.jsp").forward(request, response);
                break;

            case 3: //Eliminar Proveedor
                if (epDAO.eliminarRegistro()) {

                    request.setAttribute("MensajeExito ", "La empresa se eliminó correctamente");

                } else {
                    request.setAttribute("MensajeError ", "La empresa no se eliminó correctamente");
                }

                request.getRequestDispatcher("EliminarProveedor.jsp").forward(request, response);
                break;

             case 4: // consultarproveedor
                EmpresaProveedoraVO ep = epDAO.consultarNombreEmpresa(NombreComercialEmpresaProveedora);

                if (ep != null) {

                    request.setAttribute("EmpresaConsultada", ep);
                    request.setAttribute("MensajeExito", "Empresa Consultada");
                    request.getRequestDispatcher("ActualizarProveedor.jsp").forward(request, response);
                } else {
                    request.setAttribute("MensajeError", "La empresa no se encuentra registrada");
                    request.getRequestDispatcher("ConsultarProveedor.jsp").forward(request, response);

                }

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
