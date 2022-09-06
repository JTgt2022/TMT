package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Util.ConexionDB;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.ArrayList;
import ModeloVO.ProductoVO;
import ModeloDAO.ProductoDAO;

public final class ConsultarProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("\n");
      out.write("<!------ Include the above in your HEAD tag ---------->\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login Page</title>\n");
      out.write("        <!--Made with love by Mutiullah Samim -->\n");
      out.write("\n");
      out.write("        <!--Bootsrap 4 CDN-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!--Fontawesome CDN-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!--Custom styles-->\n");
      out.write("        <link href=\"Estilos/estilos2.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("    <center>\n");
      out.write("        <div>\n");
      out.write("\n");
      out.write("            <h1>Consultar Producto</h1>\n");
      out.write("  ");

    ConexionDB con = new ConexionDB();
    Statement smt;
    ResultSet rs;
    smt = con.obtenerConexion().createStatement();
    rs = smt.executeQuery("select * from producto");

      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("         \n");
      out.write("            <div style=\"padding-left: 800px\">    \n");
      out.write("             <div  class=\"container buscar\">\n");
      out.write("                 <center>\n");
      out.write("                 <form class=\"form\">\n");
      out.write("                <input type=\"text\" name=\"txtbuscar\">\n");
      out.write("                <input type=\"submit\" value=\"Buscar\">\n");
      out.write("                 </form></center></center>\n");
      out.write("                 ");
 
String nombuscar=request.getParameter("txtbuscar");
if(nombuscar!=null){
    smt=con.obtenerConexion().createStatement();
    rs=smt.executeQuery("select* from producto where CodigoDeBarrasProducto LIKE"+"'%"+nombuscar+"%' OR ReferenciaProducto  LIKE"+"'%"+nombuscar+"%' OR DescripcionProducto LIKE"+"'%"+nombuscar+"%' OR StockProducto  LIKE"+"'%"+nombuscar+"%' OR  PrecioUnitario LIKE"+"'%"+nombuscar+"%'");

}else{
    System.err.print("Error");
}
                 
      out.write("\n");
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("                    <div class=\"container\">               \n");
      out.write("                         <a  class=\"btn btn-success\" href=\"registrarProducto.jsp\">Nuevo Registro</a>\n");
      out.write("                        <table class=\"table table-bordered\"  id=\"tablaDatos\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th class=\"text-center\">Codigos Disponibles</th>\n");
      out.write("                                    <th class=\"text-center\">Referencia</th>\n");
      out.write("                                    <th class=\"text-center\">Descripcion</th>\n");
      out.write("                                    <th class=\"text-center\">Stock disponible</th>\n");
      out.write("                                    <th class=\"text-center\">Precio por unidad</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody id=\"tbodys\">\n");
      out.write("                            <br><br><br>\n");
      out.write("\n");
      out.write("                            ");

                                while (rs.next()) {
                            
      out.write("\n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"text-center\">");
      out.print( rs.getString("CodigoDeBarrasProducto"));
      out.write("</td>\n");
      out.write("                                <td class=\"text-center\">");
      out.print( rs.getString("ReferenciaProducto"));
      out.write("</td>\n");
      out.write("                                <td class=\"text-center\">");
      out.print( rs.getString("DescripcionProducto"));
      out.write("</td>\n");
      out.write("                                 <td class=\"text-center\">");
      out.print( rs.getString("StockProducto"));
      out.write("</td>\n");
      out.write("                                  <td class=\"text-center\">");
      out.print( rs.getString("PrecioUnitario"));
      out.write("</td>\n");
      out.write("\n");
      out.write("                        <td class=\"text-center\">\n");
      out.write("                                \n");
      out.write("                                <!-- <input type=\"hidden\" value=\"<//%= rs.getInt(\"IdPedido\")%>\" id=\"Editar\"/>\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-warning\" data-toggle=\"modal\" data-target=\"#myModal1\" value=\"Editar\"/>  -->\n");
      out.write("                                <a href=\"ActuaizarProducto.jsp?IdProducto=");
      out.print( rs.getInt("IdProducto"));
      out.write("\" class=\"btn btn-primary\">Editar</a>\n");
      out.write("                                <a href=\".jsp?IdProducto=");
      out.print( rs.getInt("IdProducto"));
      out.write("\" class=\"btn btn-danger\">Delete</a>\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </table>    \n");
      out.write("                    </div>   \n");
      out.write("\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");

                if (request.getAttribute("MensajeError") != null) {
      out.write("\n");
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            ");
 } else { 
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </center>\n");
      out.write("</body>\n");
      out.write("<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("</html>");
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
