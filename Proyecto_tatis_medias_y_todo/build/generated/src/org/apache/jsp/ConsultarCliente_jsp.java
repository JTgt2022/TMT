package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import Util.ConexionDB;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.ArrayList;
import ModeloDAO.ClienteDAO;
import ModeloVO.ClienteVO;

public final class ConsultarCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href=\"Estilos/estilos2.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("            \n");
      out.write("           <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Consultar</title>\n");
      out.write("    </head>\n");
      out.write("  <body>\n");
      out.write("           ");

            //CONECTANOD A LA BASE DE DATOS:
                  
    ConexionDB con = new ConexionDB();
    Statement smt;
    ResultSet rs;
    smt = con.obtenerConexion().createStatement();
    rs = smt.executeQuery("select * from Cliente");

      out.write("\n");
      out.write("    \n");
      out.write("            //Creamo la Tabla:     \n");
      out.write("        %>\n");
      out.write("        <div class=\"container\">            \n");
      out.write("            <button type=\"button\" class=\"btn btn-success btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\">New Add</button>\n");
      out.write("            <div style=\"padding-left: 800px\">                  \n");
      out.write("               <div  class=\"container buscar\">\n");
      out.write("                 <form class=\"form\">\n");
      out.write("                <input type=\"text\" name=\"txtbuscar\">\n");
      out.write("                <input type=\"submit\" value=\"Buscar\">\n");
      out.write("            </form>            \n");
      out.write("                   \n");
      out.write("                      ");
 
String nombuscar=request.getParameter("txtbuscar");
if(nombuscar!=null){
    smt=con.obtenerConexion().createStatement();
    rs=smt.executeQuery("select* from Cliente where NumeroDocCliente LIKE "+"'%"+nombuscar+"%'");
    
    
    
}else{
    System.err.print("Error");
}
                 
      out.write(" \n");
      out.write("            </div>\n");
      out.write("        </div>  \n");
      out.write("              \n");
      out.write("        <br>\n");
      out.write("        <div class=\"container\">               \n");
      out.write("            <!--<a  class=\"btn btn-success\" href=\"Agregar.jsp\">Nuevo Registro</a> Esto es Cuando se Crea un nuevo Archivo Agregar.jsp -->         \n");
      out.write("             <table class=\"table table-bordered\"  id=\"tablaDatos\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th class=\"text-center\">Id</th>\n");
      out.write("                            <th class=\"text-center\">Nombres</th>\n");
      out.write("                            <th class=\"text-center\">Apellidos</th>\n");
      out.write("                            <th class=\"text-center\">Numero Documento</th>\n");
      out.write("                            <th class=\"text-center\">Estado</th>\n");
      out.write("                            <th class=\"text-center\">Acciones</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody id=\"tbodys\">\n");
      out.write("                        ");

                            while (rs.next()) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"text-center\">");
      out.print( rs.getInt("IdCliente"));
      out.write("</td>\n");
      out.write("                             <td class=\"text-center\">");
      out.print( rs.getString("NombreCliente"));
      out.write("</td>\n");
      out.write("                             <td class=\"text-center\">");
      out.print( rs.getString("ApellidoCliente"));
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( rs.getString("NumeroDocCliente"));
      out.write("</td>\n");
      out.write("                            <td class=\"text-center\">");
      out.print( rs.getString("EstadoCliente"));
      out.write("</td>\n");
      out.write("                            <td class=\"text-center\">\n");
      out.write("                                \n");
      out.write("                                <!-- <input type=\"hidden\" value=\"<//%= rs.getInt(\"Id_Usuario\")%>\" id=\"Editar\"/>\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-warning\" data-toggle=\"modal\" data-target=\"#myModal1\" value=\"Editar\"/>  -->\n");
      out.write("                                <a href=\"ActualizarCliente.jsp?IdCliente=");
      out.print( rs.getInt("IdCliente"));
      out.write("\" class=\"btn btn-primary\">Editar</a>\n");
      out.write("                                <a href=\"EliminarCliente.jsp?IdCliente=");
      out.print( rs.getInt("IdCliente"));
      out.write("\" class=\"btn btn-danger\">Delete</a>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                </table>\n");
      out.write("                       \n");
      out.write("        <script src=\"js/jquery.js\" type=\"text/javascript\"></script>             \n");
      out.write("        <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>        \n");
      out.write("                    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
