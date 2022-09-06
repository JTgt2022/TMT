/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.ProductoDAO;
import ModeloVO.ProductoVO;
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
@WebServlet(name = "ProductoControlador", urlPatterns = {"/Producto"})
public class ProductoControlador extends HttpServlet {

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

        String IdProducto = request.getParameter("txtid");
        String CodigoDeBarrasProducto = request.getParameter("txtcodigoB");
        String ReferenciaProducto = request.getParameter("txtreferencia");
        String DescripcionProducto = request.getParameter("txtdescripcion");
        String StockProducto = request.getParameter("txtstock");
        String PrecioUnitario = request.getParameter("txtprecio");
        String EstadoProducto = request.getParameter("txtestado");
        String IdCategoriaFK = request.getParameter("txtcategoria");
        String IdEmpresaProveedoraFK = request.getParameter("txtempresa");

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2¿ Quién tien elos datos de forma segura ? VO
        ProductoVO proVO = new ProductoVO(IdProducto, CodigoDeBarrasProducto, ReferenciaProducto, DescripcionProducto, StockProducto,
                PrecioUnitario, EstadoProducto, IdCategoriaFK, IdEmpresaProveedoraFK);

        //3¿Quién hace las operaciones? DAO
        ProductoDAO proDAO = new ProductoDAO(proVO);

        //Administrar operaciones
        switch (opcion) {

            case 1: //Agregar Registro 
                if (proDAO.agregarRegistro()) {

                    request.setAttribute("MensajeExito", "<center=red><h2>El Producto se registró correctamente</h2></center>");

                } else {
                    request.setAttribute("MensajeError", "El Producto no se registró correctamente");
                }

                request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
                break;

            case 2: //Actualizar Registro 
                if (proDAO.actualizarRegistro()) {

                    request.setAttribute("MensajeExito", "El Producto se actualizó correctamente");

                } else {
                    request.setAttribute("MensajeError", "El Producto no se actualizó correctamente");
                }

                request.getRequestDispatcher("ConsultarProducto.jsp").forward(request, response);
                break;

            case 3: //Eliminar Registro 
                if (proDAO.eliminarRegistro()) {

                    request.setAttribute("MensajeExito ", "El Producto se eliminó correctamente");

                } else {
                    request.setAttribute("MensajeError ", "El Producto no se eliminó correctamente");
                }

                request.getRequestDispatcher("EliminarProducto.jsp").forward(request, response);
                break;

            case 4: // consultarproducto
                ProductoVO pro = proDAO.consultarCodigodeBarras(CodigoDeBarrasProducto);

                if (pro != null) {

                    request.setAttribute("ProductoConsultado", pro);
                    request.setAttribute("MensajeExito", "Producto Consultado");
                    request.getRequestDispatcher("ActualizarProducto.jsp").forward(request, response);
                } else {
                    request.setAttribute("MensajeError", "El Producto no se encuentra registrado");
                    request.getRequestDispatcher("ConsultarProducto.jsp").forward(request, response);

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
