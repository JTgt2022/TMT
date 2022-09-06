package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloDAO.RolDAO;
import ModeloVO.RolVO;

public final class registrarUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registro usuario</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <!--Bootsrap 4 CDN-->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("    \n");
      out.write("    <!--Fontawesome CDN-->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("\t<!--Custom styles-->\n");
      out.write("      \n");
      out.write("      <link href=\"Estilos/estilos2.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("      <link href=\"css/alertify.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("      <link href=\"css/default.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("</head>\n");
      out.write("  \n");
      out.write("<center>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div class=\"contenedor\">      \n");
      out.write("\n");
      out.write("        <center>\n");
      out.write("            <h1 class=\"titulo\">Registrar Usuario</h1>\n");
      out.write("            <form  name=\"fmrUsuarios\" method=\"post\" action=\"Usuario\" onsubmit=\"return validarDatosdeUsuario()\">\n");
      out.write("            <table>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                   \n");
      out.write("                <div class=\"campos\">Nombre </div>\n");
      out.write("                <input type=\"email\" name=\"textUsuario\"><br><br>\n");
      out.write("                        \n");
      out.write("                    <div class=\"campos\"> Contraseña </div>\n");
      out.write("                    \n");
      out.write("                    <input type=\"password\" name=\"textClave\" onkeypress=\"return verificarcontraseña(event)\" ><br><br>\n");
      out.write("                \n");
      out.write("                    \n");
      out.write("                    <input type=\"hidden\" readonly read value=\"Activo\" name=\"textEstado\"><br><br>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                 </div>\n");
      out.write("                    \n");
      out.write("                \n");
      out.write("            </table><br>\n");
      out.write("           \n");
      out.write("      \n");
      out.write("        <div class=\"form-group\">\t\n");
      out.write("        <input type=\"hidden\" value=\"1\" name=\"opcion\" class=\"btn float-right l\n");
      out.write("               ogin_btn\">\n");
      out.write("        <button type=\"submit\" class=\"btn float-right login_btn\" > Registrarse</button>\n");
      out.write("        </div>\n");
      out.write("        </form>\n");
      out.write("                   \n");
      out.write("        </center>\n");
      out.write("      \n");
      out.write("        </div>\n");
      out.write("      \n");
      out.write("          <div class=\"tres\"> \n");
      out.write("                         \n");
      out.write("                                         ");
 
                                         if(request.getAttribute("MensajeError") !=null) {
      out.write("\n");
      out.write("                                         ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("           \n");
      out.write("               \n");
      out.write("                                         ");
}else {
      out.write("\n");
      out.write("                                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("  \n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                        \n");
      out.write("     </div>\n");
      out.write("                                        \n");
      out.write("    <script src=\"css/alertify.min.js\" type=\"text/javascript\"></script>\n");
      out.write("                                        \n");
      out.write("     <script>\n");
      out.write("        \n");
      out.write("        function validarDatosdeUsuario(){\n");
      out.write("            usu = document.fmrUsuarios.textUsuario.textClave.value;\n");
      out.write("            if(usu.length === 0){\n");
      out.write("                alertify.alert(\"Error\",\"Ingrese Nombre de usuario y contraseña\").set('label','OK');\n");
      out.write("                return  false;\n");
      out.write("            }else{\n");
      out.write("                alertify.sucess(\"Usuario ingresado correctamente\");\n");
      out.write("                return true;\n");
      out.write("            }    \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("       \n");
      out.write("        \n");
      out.write("    </script> \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    </body>\n");
      out.write("    </center>\n");
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
