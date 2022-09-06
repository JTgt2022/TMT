/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.CategoriaDAO;
import ModeloVO.CategoriaVO;
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
@WebServlet(name = "CategoriaControlador", urlPatterns = {"/Categoria"})
public class CategoriaControlador extends HttpServlet {

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
        
        
        String IdCategoria=request.getParameter("txtid");
        String NombreCategoria=request.getParameter("txtNombre");
        
        int opcion= Integer.parseInt(request.getParameter("opcion"));
        
        //2¿ Quién tien elos datos de forma segura ? VO
        CategoriaVO catVO= new CategoriaVO(IdCategoria, NombreCategoria);
        
        //3¿Quién hace las operaciones? DAO
                
         CategoriaDAO catDAO = new CategoriaDAO(catVO);
         
         
         
          //Administrar operaciones
        switch (opcion) {

            case 1: //Agregar Registro 
                if (catDAO.agregarRegistro()) {

                    request.setAttribute("MensajeExito", "<center=red><h2>La categoría se registró correctamente</h2></center>");

                } else {
                    request.setAttribute("MensajeError", "La categoría no se registró correctamente");
                }

                request.getRequestDispatcher("RegistrarCategoria.jsp").forward(request, response);
                break;

            case 2: //Actualizar Registro 
                if (catDAO.actualizarRegistro()) {

                    request.setAttribute("MensajeExito ", "La categoría se actualizó correctamente");

                } else {
                    request.setAttribute("MensajeError ", "La categoría no se actualizó correctamente");
                }

                request.getRequestDispatcher("ConsultarCategoria.jsp").forward(request, response);
                break;

            case 3: //Eliminar Registro 
                if (catDAO.eliminarRegistro()) {

                    request.setAttribute("MensajeExito ", "La categoría se eliminó correctamente");

                } else {
                    request.setAttribute("MensajeError ", "La categoría no se eliminó correctamente");
                }

                request.getRequestDispatcher("EliminarCategoria.jsp").forward(request, response);
                break;

            case 4: // consultarVehiculo
               if (catDAO.consultarcategoria())
               {

                    request.setAttribute("CategoriaConsultada", catDAO);
                    request.setAttribute("MensajeExito", "Categoria Consultada");
                    request.getRequestDispatcher("ActualizarCategoria.jsp").forward(request, response);
                } else {
                    request.setAttribute("MensajeError", "La categoria no se encuentra registrada");
                    request.getRequestDispatcher("ConsultarCategoria.jsp").forward(request, response);

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
