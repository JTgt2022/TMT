<%@page import="ModeloVO.UsuarioVO"%>
<%
            Connection con;
            String url = "jdbc:mysql://localhost:3306/tatis_media_y_todo";
            String Driver = "com.mysql.jdbc.Driver";
            String user = "root";
            String clave = "";
            Class.forName(Driver);
            con = DriverManager.getConnection(url, user, clave);
            Statement smt;
            ResultSet rs;
            smt = con.createStatement();
            rs = smt.executeQuery("select * from usuario");
        %>
<%@page import="java.sql.*"%>
<div class="modal fade" id="editarPerfilModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Información de Consulta</h5>
                <button class="close bg-transparent border-0" data-dismiss="modal">
                    <i class="fal fa-times"></i>
                </button>
            </div>
            <div class="container">               
            <table class="table table-bordered"  id="tablaDatos">
                <thead>
                    <tr>
                        <th class="text-center">USUARIO</th>
                    </tr>
                </thead>
                <tbody id="tbodys">


                    <%
                        while (rs.next()) {
                    %>

                    <tr>
                        <td class="text-center"><%= rs.getString("NombreUsuario")%></td>

                    </tr>
                    <%}%>
            </table>    
        </div>   
            </form>
        </div>
    </div>
</div>