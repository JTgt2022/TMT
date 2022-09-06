<%-- 
    Document   : RegistrarVenta
    Created on : 9/08/2022, 06:44:33 PM
    Author     : jtgt2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Ventas</title>
    </head>
    <body>
        <h1>Registrar Venta</h1>
        
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Datos del Cliente</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                             <input type="text" name="TextNumDoc" class="form-control" placeholder="No de documento">
                             <input type="submit"  value="buscar" class="btn btn-outline-info">
                            <input type="hidden" value="3" name="opcion">
                              
                            </div>
                            <div class="col-sm-8">
                                 <input type="text" name="TextNombre" class="form-control col-sm-4"

                            </div>
                        </div>
                        <div class="form-group">
                            <label>Datos Producto</label>
                        </div>
                        <div class="form-group d-flex">
                             <div class="col-sm-6 d-flex">
                             <input type="text" name="txtcodigoB" class="form-control" placeholder="No de documento">
                             <input type="submit"  value="buscar" class="btn btn-outline-info">
                            <input type="hidden" value="3" name="opcion">
                              
                            </div>
                            <div class="col-sm-8">
                                 <input type="text" name="TextNombre" class="form-control col-sm-4"

                            </div>
                        </div>
                        <div class="form-group"></div>
                        
                    </div>
                        
                    </div>
                    
                </div>
                
           
            <div class="col-sm-8">
                
            </div>
            
        </div>
             
                         
                        
        
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
    
    
</html>
