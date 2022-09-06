/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.PedidoDAO;
import ModeloVO.PedidoVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexis
 */
@WebServlet(name = "PedidoControlador", urlPatterns = {"/Pedido"})
public class PedidoControlador extends HttpServlet {

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
        String IdPedido=request.getParameter("txtPedido");
        String NumeroFacturaPedido=request.getParameter("txtNumeroFacturaPedido");
        String FechaPedido=request.getParameter("txtFechaPedido");
        String FechaRecibido=request.getParameter("txtFechaRecibido");
        String FechaVencimientoPago=request.getParameter("txtFechaVencimientoPago");
        String IdEmpresaProveedoraFK=request.getParameter("txtIdEmpresaProveedora");
        String IVA=request.getParameter("txtIVA");
        String Descuento=request.getParameter("txtDescuento");
        String EstadoPedido=request.getParameter("txtEstadoPedido");
        
        
         int opcion= Integer.parseInt(request.getParameter("opcion"));
        
        //2¿ Quién tien elos datos de forma segura ? VO
        PedidoVO PVO= new PedidoVO(IdPedido, NumeroFacturaPedido, FechaPedido, FechaRecibido, FechaVencimientoPago, IdEmpresaProveedoraFK, IVA, Descuento, EstadoPedido);
        
        
        //3¿Quién hace las operaciones? DAO
                
         PedidoDAO PDAO = new PedidoDAO(PVO);
           //Administrar operaciones
        switch (opcion) {

            case 1: //Agregar Registro 
                if (PDAO.agregarRegistro()) {

                    request.setAttribute("MensajeExito", "<center=red><h2>El Pedido se ha registrado correctamente</h2></center>");

                } else {
                    request.setAttribute("MensajeError", "El pedido no se ha registrado correctamente");
                }

                request.getRequestDispatcher("registrarPedido.jsp").forward(request, response);
                break;

            case 2: //Actualizar Registro 
                if (PDAO.actualizarRegistro()) {

                    request.setAttribute("MensajeExito ", "El pedido se actualizó correctamente");

                } else {
                    request.setAttribute("MensajeError ", "El pedido no se actualizó correctamente");
                }

                request.getRequestDispatcher("ConsultarPedido.jsp").forward(request, response);
                break;

            case 3: //Eliminar Registro 
                if (PDAO.eliminarRegistro()) {

                    request.setAttribute("MensajeExito ", "El Pedido se eliminó correctamente");

                } else {
                    request.setAttribute("MensajeError ", "El Pedido no se eliminó correctamente");
                }

                request.getRequestDispatcher("EliminarPedido.jsp").forward(request, response);
                break;
              case 4: 
                   
                  PVO = PDAO.consultarPedido(IdPedido);
                   
                   if (PVO != null) {
                       
                       request.setAttribute("PedidoConsultado",PVO);
                       request.getRequestDispatcher("actualizarPedido.jsp").forward(request, response);
                       
                   }else{
                        request.setAttribute("MensajeError", "El  Pedido No existe");
                       request.getRequestDispatcher("ConsultarPedido.jsp").forward(request, response);
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

 

