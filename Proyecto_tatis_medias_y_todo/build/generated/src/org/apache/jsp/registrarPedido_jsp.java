package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloVO.EmpresaProveedoraVO;
import ModeloDAO.EmpresaProveedoraDAO;
import ModeloVO.UsuarioVO;

public final class registrarPedido_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Sesiones.jsp");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    ");

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-control", "no-cache, no-store,must-revalidate");
        response.setDateHeader("Expires", 0);
       
        
        
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("     ");
 
     HttpSession sesion =(HttpSession)request.getSession();
     String Usuario="";
    if (sesion.getAttribute("datosUsuario")==null) {
         request.getRequestDispatcher("Login.jsp").forward(request, response);
            
        }else{
        
        UsuarioVO usuVO= (UsuarioVO)sesion.getAttribute("datosUsuario");
        Usuario = usuVO.getNombreUsuario();
        
    
    
    }
        
        
        
        
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    <body>\n");
      out.write("        <div class=\"card-header\">\n");
      out.write("            \n");
      out.write("        <h1>Bienvenido: ");
      out.print(Usuario);
      out.write("</h1>\n");
      out.write("        <form method=\"post\" action=\"Sesiones\">\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("           <div class=\"botones\">                       \n");
      out.write("            <input type=\"submit\" value=\"Cerrar Sesion\">  \n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        </div><br><br>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        <link href=\"css/default.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("      <link href=\"css/alertify.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <center>\n");
      out.write("        <h1>Registrar Pedido</h1>\n");
      out.write("        <form method=\"post\" action=\"Pedido\" name=\"fmrPedidos\" onsubmit=\"return validar_Pedidos()\">\n");
      out.write("            <table>\n");
      out.write("                <tr> No.Factura<br>\n");
      out.write("                <input type=\"text\" name=\"txtNumeroFacturaPedido\"><br>\n");
      out.write("                </tr>\n");
      out.write("                <tr>Fecha Pedido<br>\n");
      out.write("                <input type=\"date\" name=\"txtFechaPedido\"><br>\n");
      out.write("                </tr>\n");
      out.write("                <tr>Fecha Recibido<br>\n");
      out.write("                <input type=\"date\" name=\"txtFechaRecibido\"><br>\n");
      out.write("                </tr>\n");
      out.write("                <tr>Fecha Vencimiento pago<br>\n");
      out.write("                <input type=\"date\" name=\"txtFechaVencimientoPago\"><br>\n");
      out.write("                </tr>\n");
      out.write("                <tr>Id Empresa Proveedora<br>\n");
      out.write("                 <select name=\"txtIdEmpresaProveedora\">\n");
      out.write("                        <option>Seleccione una opción</option>\n");
      out.write("                        ");

                            EmpresaProveedoraDAO epDAO = new EmpresaProveedoraDAO();
                            for(EmpresaProveedoraVO epVO : epDAO.Listar()) {
                         
      out.write("\n");
      out.write("                         <option value=\"");
      out.print(epVO.getIdEmpresaProveedora());
      out.write('"');
      out.write('>');
      out.print(epVO.getRazonSocialEmpresaProveedora());
      out.write("</option>\n");
      out.write("                                 \n");
      out.write("                                 \n");
      out.write("                          ");
}
      out.write("       \n");
      out.write("                    </select> <br> <br>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                <tr>IVA<br>\n");
      out.write("                <input type=\"number\" name=\"txtIVA\"><br>\n");
      out.write("                </tr>\n");
      out.write("                <tr>Descuento <br>\n");
      out.write("                <input type=\"number\" name=\"txtDescuento\"><br>\n");
      out.write("                </tr>\n");
      out.write("                <tr>Estado Pedido<br>\n");
      out.write("                <select name=\"txtEstadoPedido\">\n");
      out.write("                    <option>Seleccione una opción</option>\n");
      out.write("                <option>Entregado</option>\n");
      out.write("                <option>Pago</option>\n");
      out.write("                </select> <br> <br>\n");
      out.write("                </tr>\n");
      out.write("            </table><br>\n");
      out.write("            <button>Registrar pedido</button>\n");
      out.write("            <input type=\"hidden\"value=\"1\"  name=\"opcion\">\n");
      out.write("            \n");
      out.write("             <button type=\"submit\"  class=\"btn float-right login_btn\"> <a href=\"ConsultarPedido.jsp\"> Ver Pedidos registrados </a> </button>\n");
      out.write("                                        \n");
      out.write("            \n");
      out.write("        </form><BR>\n");
      out.write("        ");

        if (request.getAttribute("MensajeError")  !=null) {
      out.write("\n");
      out.write("         ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" \n");
      out.write("           ");
  }  else {
      out.write("\n");
      out.write("                   ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                   ");
}
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("       \n");
      out.write("       </center>\n");
      out.write("         <script src=\"css/alertify.min.js\" type=\"text/javascript\"></script>\n");
      out.write("       \n");
      out.write("       <script>\n");
      out.write("        function validar_Pedidos(){\n");
      out.write("            ped= document.fmrPedidos.txtNumeroFacturaPedido.value;\n");
      out.write("            if(ped.length === 0){\n");
      out.write("                alertify.alert(\"Error\",\"Ingrese los datos correctamente\").set('label','OK');\n");
      out.write("                return  false;\n");
      out.write("            }else{\n");
      out.write("                alertify.success(\"Pedido Ingresada con exito\");\n");
      out.write("                return true;\n");
      out.write("            }    \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        function validar_Texto(){\n");
      out.write("            tecla = e.keyCode; \n");
      out.write("            teclado = String.fromCharCode(tecla);\n");
      out.write("            if ((teclado < 'A' || teclado > 'z') && teclado !==\" \"){\n");
      out.write("                return false;\n");
      out.write("            } \n");
      out.write("        }\n");
      out.write("    \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </script>             \n");
      out.write("                   \n");
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
