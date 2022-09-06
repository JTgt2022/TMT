/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.RolDAO2;
import ModeloDAO.UsuarioDAO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SENA
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1. Recibir datos de las vistas
        String IdUsuario = request.getParameter("textId");
        String NombreUsuario = request.getParameter("textUsuario");
        String PasswordUsuario = request.getParameter("textClave");
        String EstadoUsuario = request.getParameter("textEstado");
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2. ¿Quién tiene los datos de forma segura? VO
        UsuarioVO usuVO = new UsuarioVO(IdUsuario, NombreUsuario, PasswordUsuario, EstadoUsuario);

        //3. ¿Quién hace las operaciones? DAO
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);

        //4. Administrar  Operaciones
        switch (opcion) {

            case 1: //Agregar Registro
                if (usuDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "<center><h2>El usuario se registro correctamente</h2></center>");

                } else {
                    request.setAttribute("mensajeError", "<center><h2>El usuario NO se registro correctamente</h2></center>");

                }
                request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
                break;
                
            case 2:  //Actualizar REgistro
                if (usuDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "<center><h2>El usuario se actualizo correctamente</center></h2>");

                } else {
                    request.setAttribute("mensajeError", "<center><h2>El usuario NO se actualizo correctamente</center></h2>");

                }
                request.getRequestDispatcher("ConsultarUsuario.jsp").forward(request, response);
                break;

            case 3:

                UsuarioVO usu = usuDAO.consultarNombre(NombreUsuario);
                if (usu != null) {

                    request.setAttribute("usuarioConsultado", usu);
                    request.setAttribute("mensajeExito", "<center><h2>Usuario consultado</center></h2>");
                    request.getRequestDispatcher("ActualizarUsuario.jsp").forward(request, response);
                } else {

                    request.setAttribute("mensajeError", "<center><h2>El Usuario NO existe!</center></h2>");
                    request.getRequestDispatcher("ConsultarUsuario.jsp").forward(request, response);

                }
                break;
                
                case 4://Inicio de sesion
                if (usuDAO.iniciarSesion(NombreUsuario, PasswordUsuario)) {
                    
                    HttpSession sesion=request.getSession(true);
                    usuVO= new UsuarioVO(IdUsuario, NombreUsuario, PasswordUsuario, EstadoUsuario);
                    sesion.setAttribute("datosUsuario", usuVO);
                    
                RolDAO2 rolD = new RolDAO2();
                    String rol = rolD.seleccionarRol (NombreUsuario, PasswordUsuario);
                    sesion.setAttribute("rol", rol);
                    request.getRequestDispatcher("roles.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeExito", "<center><h2>Datos de ingreso incorrectos</h2></center>");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
                break;
                
                
             

            case 5: //Eliminar Registro
                if (usuDAO.eliminarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se elimino correctamente ");
                } else {
                    request.setAttribute("mensajeError", "El usuario No se elimino correctamente ");
                }
                request.getRequestDispatcher("EliminarUsuario.jsp").forward(request, response);
                break;
        }

    }

}
