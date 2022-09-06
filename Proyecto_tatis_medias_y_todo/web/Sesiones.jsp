<%-- 
    Document   : Sesiones
    Created on : 15/06/2022, 09:08:26 AM
    Author     : SENA
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <%
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-control", "no-cache, no-store,must-revalidate");
        response.setDateHeader("Expires", 0);
       
        
        %>
    
    
     <% 
     HttpSession sesion =(HttpSession)request.getSession();
     String Usuario="";
    if (sesion.getAttribute("datosUsuario")==null) {
         request.getRequestDispatcher("Login.jsp").forward(request, response);
            
        }else{
        
        UsuarioVO usuVO= (UsuarioVO)sesion.getAttribute("datosUsuario");
        Usuario = usuVO.getNombreUsuario();
        
    
    
    }
        
        
        
        %>
        
        
    <body>
        <div class="card-header">
            
        <h1>Bienvenido: <%=Usuario%></h1>
        <form method="post" action="Sesiones">
            
        </div>
            
            
            
           <div class="botones">                       
            <input type="submit" value="Cerrar Sesion">  
            </div>
            
            
            
        </form>
        
        </div><br><br>
        
        
    </body>
</html>
