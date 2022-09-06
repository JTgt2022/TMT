<%-- 
    Document   : ActualizarProducto
    Created on : 3/08/2022, 09:26:19 PM
    Author     : jtgt2
--%>

<%@page import="ModeloDAO.EmpresaProveedoraDAO"%>
<%@page import="ModeloVO.EmpresaProveedoraVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jsp Page</title>
        <!--Made with love by Mutiullah Samim -->

        <!--Bootsrap 4 CDN-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <!--Fontawesome CDN-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

        <!--Custom styles-->

        <link href="Estilos/estilos2.css" rel="stylesheet" type="text/css"/>

    </head>

    <%
        if (request.getAttribute("EmpresaConsultada") != null) {
            EmpresaProveedoraVO epVO = (EmpresaProveedoraVO) request.getAttribute("EmpresaConsultada");


    %>
    <center>
        <body>
            <h1>Actualizar Producto</h1>
            <form method="post" action="EmpresaProveedora">
                <table>
                    
                    <input type="hidden" readonly read name="txtid" value="<%=epVO.getIdEmpresaProveedora()%>"><br><br>

                    
                    <tr>
                        NIT Empresa<br>
                    <input type="text" readonly read name="txtNit" value="<%=epVO.getNitEmpresaProveedora()%>"><br><br>


                    Razon Social<br>
                    <input type="text" readonly read name="txtRazon" value="<%=epVO.getRazonSocialEmpresaProveedora()%>"><br><br>


                    Nombre Comercial<br>

                    <input type="text"  name="txtNombreC" value="<%=epVO.getNombreComercialEmpresaProveedora()%>"><br><br>

                    Dirección<br>

                    <input type="text" name="txtDireccion" value="<%=epVO.getDireccionEmpresaProveedora()%>"><br><br>

                    Telefono<br>
                    <input type="number" name="txtTelefono" value="<%=epVO.getTelefonoEmpresaProveedora()%>"><br><br>

                    Numero de pago<br>

                    <input type="text" name="txtNumero" value="<%=epVO.getNumeropago()%>"><br><br>
                   
                    
                     Estado<br>

                    <input type="text" name="txtEstado" value="<%=epVO.getEstadoEmpresaProveedora()%>"><br><br>
                   

                    </tr>


                </table><br>
                <button> Actualizar Infomrmación</button>
                <input type="hidden" value="2" name="opcion">



            </form>

            <%
           if (request.getAttribute("MensajeError") != null) {%>
            ${MensajeError}
            <% } else { %>
            ${MensajeExito}
            <%}%>


            <% }%>

            </div>
    </center>
</body>
</html>