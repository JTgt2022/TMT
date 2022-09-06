/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.DetallePDAO;
import ModeloVO.DetallePedidoVO;
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
@WebServlet(name = "DetallePedidoControlador", urlPatterns = {"/DetallePedido"})
public class DetallePedidoControlador extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
 //1.Recibir datos de las vistas
        String IdPedidoFK = request.getParameter("textIdPedidoFK");
        String IdProductoFK= request.getParameter("textIdProductoFK");
        String PrecioUnitario = request.getParameter("textPrecio");
        String Cantidad=request.getParameter("textCantidad");
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
//2.¿Quien tiene los datos de forma segura en el sistema?VO
        DetallePedidoVO DPVO = new DetallePedidoVO(IdPedidoFK,IdProductoFK, PrecioUnitario, Cantidad);

//3.¿Quien hace las operaciones ?
        DetallePDAO DPDAO = new DetallePDAO(DPVO);
        
//4.Administrar operaciones 
        switch (opcion) {

            case 1://agregar registro 
                if (DPDAO.agregarRegistro()) {
                    request.setAttribute("MensajeExito", "El Detalle Pedido se registró correctamente ");

                } else {
                    request.setAttribute("MensajeError", "El Detalle Pedido no se registró correctamente ");
                }
                //Redireccionar
                request.getRequestDispatcher("registrarDP.jsp").forward(request, response);
                break;

            case 2://actualizar registro 
                if (DPDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El Detalle Pedido se ha modificado correctamente ");

                } else {
                    request.setAttribute("mensajeError", "El Detalle Pedido NO se ha modificado correctamente ");
                }
                //Redireccionar
                request.getRequestDispatcher("consultarDP.jsp").forward(request, response);
                break;
                
            case 3: //EliminarRegistro
                if (DPDAO.eliminarRegistro()) {
                     request.setAttribute("mensajeExito", "El Detalle Pedido se elimino correctamente ");
                }else{
                    request.setAttribute("mensajeError", "El Detalle Pedido No se elminó correctamente ");
                }   
                request.getRequestDispatcher("eliminarDP.jsp").forward(request, response) ;
                break;
                 case 4: 
                   
                  DPVO = DPDAO.consultarDetallePedido(IdPedidoFK);
                   
                   if (DPVO != null) {
                       
                       request.setAttribute("DetallePedidoConsultado",DPVO);
                       request.getRequestDispatcher("ActualizarDP.jsp").forward(request, response);
                       
                   }else{
                        request.setAttribute("MensajeError", "El Detalle Pedido No existe");
                       request.getRequestDispatcher("consultarDP.jsp").forward(request, response);
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


    



    
