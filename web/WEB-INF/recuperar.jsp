<%-- 
    Document   : recuperar
    Created on : 25/10/2018, 03:02:32 PM
    Author     : shannon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>SAPI</title>

        <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet"/>
        <link href="lib/fontawesome/css/all.css" rel="stylesheet"/>
        <link href='lib/fullcalendar/fullcalendar.css' rel='stylesheet'/>
        <link href="lib/tooltipster/dist/css/tooltipster.bundle.min.css" rel="stylesheet" />
        <link href="lib/datatables/datatables.min.css" rel="stylesheet" type="text/css"/> 
        <script src="lib/jquery/jquery-3.3.1.js" type="application/javascript"></script>
        <script src="lib/jquery/jqueryPostGo.js" type="application/javascript"></script>
        <script src="lib/popper/popper.min.js" type="application/javascript"></script>
        <script src="lib/bootstrap/js/bootstrap.js" type="application/javascript"></script> 
        <script src='lib/moment/moment.min.js' type="application/javascript" ></script>
        <script src='lib/fullcalendar/fullcalendar.js' type="application/javascript"></script>
        <script src="lib/sweetalert/dist/sweetalert.min.js"></script>
        <script src="lib/tooltipster/dist/js/tooltipster.bundle.min.js" type="text/javascript" ></script>
        <script src="lib/datatables/datatables.min.js" type="text/javascript"></script>
        
        <link rel="stylesheet" href="css/styleLogin.css">
         <script src="js/ajaxRecuperar.js"></script>
    

    </head>
    <body>
       

        <form class="formulario">

            <h1 class="h3 mb-4 titulo-login text-center">Cambiar Contraseña</h1>

            <div class="row">
                <div class="col-12">
                    <input id="cambio1" type="correo" class="form-control" placeholder="Introduce tu nueva contraseña" >
                </div>
                <div class="col-12">
                        <input id="cambio2"type="confirmarCorreo" class="form-control mt-3" placeholder="Confirma tu nueva contraseña" >
                    </div>
            </div>

            <div class="row justify-content-center mt-4">
                <div class="col-12">
                    <button class="btn btn-danger btn-block" id="RestablcerContra" style="background-color: #fc3955 !important">Cambiar</button>
                </div>
            </div>

        </form>

    </body>
</html>
