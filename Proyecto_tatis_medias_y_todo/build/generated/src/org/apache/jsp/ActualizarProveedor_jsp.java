package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloDAO.EmpresaProveedoraDAO;
import ModeloVO.EmpresaProveedoraVO;

public final class ActualizarProveedor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("<!------ Include the above in your HEAD tag ---------->\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Jsp Page</title>\n");
      out.write("        <!--Made with love by Mutiullah Samim -->\n");
      out.write("\n");
      out.write("        <!--Bootsrap 4 CDN-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!--Fontawesome CDN-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <!--Custom styles-->\n");
      out.write("\n");
      out.write("        <link href=\"Estilos/estilos2.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    ");

        if (request.getAttribute("EmpresaConsultada") != null) {
            EmpresaProveedoraVO epVO = (EmpresaProveedoraVO) request.getAttribute("EmpresaConsultada");


    
      out.write("\n");
      out.write("    <center>\n");
      out.write("        <body>\n");
      out.write("            <h1>Actualizar Producto</h1>\n");
      out.write("            <form method=\"post\" action=\"EmpresaProveedora\">\n");
      out.write("                <table>\n");
      out.write("                    \n");
      out.write("                    <input type=\"hidden\" readonly read name=\"txtid\" value=\"");
      out.print(epVO.getIdEmpresaProveedora());
      out.write("\"><br><br>\n");
      out.write("\n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                        NIT Empresa<br>\n");
      out.write("                    <input type=\"text\" readonly read name=\"txtNit\" value=\"");
      out.print(epVO.getNitEmpresaProveedora());
      out.write("\"><br><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    Razon Social<br>\n");
      out.write("                    <input type=\"text\" readonly read name=\"txtRazon\" value=\"");
      out.print(epVO.getRazonSocialEmpresaProveedora());
      out.write("\"><br><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    Nombre Comercial<br>\n");
      out.write("\n");
      out.write("                    <input type=\"text\"  name=\"txtNombreC\" value=\"");
      out.print(epVO.getNombreComercialEmpresaProveedora());
      out.write("\"><br><br>\n");
      out.write("\n");
      out.write("                    Dirección<br>\n");
      out.write("\n");
      out.write("                    <input type=\"text\" name=\"txtDireccion\" value=\"");
      out.print(epVO.getDireccionEmpresaProveedora());
      out.write("\"><br><br>\n");
      out.write("\n");
      out.write("                    Telefono<br>\n");
      out.write("                    <input type=\"number\" name=\"txtTelefono\" value=\"");
      out.print(epVO.getTelefonoEmpresaProveedora());
      out.write("\"><br><br>\n");
      out.write("\n");
      out.write("                    Numero de pago<br>\n");
      out.write("\n");
      out.write("                    <input type=\"text\" name=\"txtNumero\" value=\"");
      out.print(epVO.getNumeropago());
      out.write("\"><br><br>\n");
      out.write("                   \n");
      out.write("                    \n");
      out.write("                     Estado<br>\n");
      out.write("\n");
      out.write("                    <input type=\"text\" name=\"txtEstado\" value=\"");
      out.print(epVO.getEstadoEmpresaProveedora());
      out.write("\"><br><br>\n");
      out.write("                   \n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </table><br>\n");
      out.write("                <button> Actualizar Infomrmación</button>\n");
      out.write("                <input type=\"hidden\" value=\"2\" name=\"opcion\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            ");

           if (request.getAttribute("MensajeError") != null) {
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
      out.write("            ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("    </center>\n");
      out.write("</body>\n");
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
