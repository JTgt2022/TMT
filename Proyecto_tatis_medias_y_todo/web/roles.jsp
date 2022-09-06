<%

    HttpSession sesion = request.getSession();
    String rol = (String) sesion.getAttribute("rol");

    if (rol.equals("1")) {

        response.sendRedirect("./Menu.jsp");

    } else if (rol.equals("2")) {

        response.sendRedirect("./menu_cajero_vendedor.jsp");

    } else if (rol.equals("3")) {

        response.sendRedirect(  "./menu_auxiliar_bodega.jsp");
        
    }
        else if (rol.equals("")) {

        response.sendRedirect(  "./Login.jsp");
        
   

   

    }

%>

