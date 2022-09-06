/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.EmpleadoDAO;
import ModeloVO.EmpleadoVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "EmpleadoControlador", urlPatterns = {"/Empleado"})
public class EmpleadoControlador extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
     //1. Recibir datos de las vistas
        String IdEmpleado = request.getParameter("textId");
        String NombreEmpleado = request.getParameter("textNombre");
        String ApellidoEmpleado = request.getParameter("textApellido");
        String TipoDocEmpleado = request.getParameter("textTipo");
        String NumeroDocEmpleado = request.getParameter("textNumDoc");
        String TelefonoCelularEmpleado = request.getParameter("textTelefono");
        String DirecionEmpleado = request.getParameter("textDireccion");
        String CorreoEmpleado = request.getParameter("textCorreo");
        String EstadoEmpleado = request.getParameter("textEstado");
        String IdUsuarioFK = request.getParameter("textUsuario");
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2. ¿Quién tiene los datos de forma segura? VO
        EmpleadoVO empVO = new EmpleadoVO(IdEmpleado, NombreEmpleado, ApellidoEmpleado, TipoDocEmpleado,NumeroDocEmpleado,TelefonoCelularEmpleado,DirecionEmpleado,CorreoEmpleado,EstadoEmpleado, IdUsuarioFK);

        //3. ¿Quién hace las operaciones? DAO
        EmpleadoDAO empDAO = new EmpleadoDAO(empVO);

        //4. Administrar  Operaciones
        switch (opcion) {

            case 1: //Agregar Registro
                if (empDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "<center><h2>El empleado se registro correctamente</h2></center>");

                } else {
                    request.setAttribute("mensajeError", "<h2>El empleado NO se registro correctamente</h2>");

                }
                request.getRequestDispatcher("registrarEmpleado.jsp").forward(request, response);
                break;
            case 2:  //Actualizar REgistro
                if (empDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "<center><h2>El empleado se actualizo correctamente</center></h2>");

                } else {
                    request.setAttribute("mensajeError", "<center><h2>El empleado NO se actualizo correctamente</center></h2>");

                }
                request.getRequestDispatcher("ConsultarEmpleado.jsp").forward(request, response);
                break;

            case 3:

                EmpleadoVO emp = empDAO.consultarDocumento(NumeroDocEmpleado);
                if (emp != null) {

                    request.setAttribute("empleadoConsultado", emp);
                    request.setAttribute("mensajeExito", "<center><h2>Empleado consultado</center></h2>");
                    request.getRequestDispatcher("ActualizarEmpleado.jsp").forward(request, response);
                } else {

                    request.setAttribute("mensajeError", "<center><h2>El empleado NO existe!</center></h2>");
                    request.getRequestDispatcher("ConsultarEmpleado.jsp").forward(request, response);

                }
                break;

           

            case 4: //Eliminar Registro
                if (empDAO.eliminarRegistro()) {
                    request.setAttribute("mensajeExito", "El empleado se elimino correctamente ");
                } else {
                    request.setAttribute("mensajeError", "El empleado No se elimino correctamente ");
                }
                request.getRequestDispatcher("EliminarEmpleado.jsp").forward(request, response);
                break;
        }

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
