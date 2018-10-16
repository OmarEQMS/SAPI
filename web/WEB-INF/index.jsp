<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Inicio de Sesión</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

    <form class="formulario">
    
        <h1 class="h3 mb-4 titulo-login text-center">Bienvenido</h1>
    
        <!-- Input usuario -->
        <div class="input-group">
            <input id="user" type="text" class="form-control input-usuario mb-2 useFontAwesomeFamily effect3" placeholder="&#xf007; USUARIO" autofocus>
        </div>
    
        <!-- Input contraseña -->
        <div class="input-group">
            <input id="password" type="password" class="form-control input-pass mb-4 useFontAwesomeFamily" placeholder="&#xf023; CONTRASEÑA">
        </div>
    
        <!-- Input submit -->
        <input type="button" id="btn-login" class="btn btn-lg btn-secondary btn-block btn-login" value="INICIAR SESIÓN">
        
        <!-- MENSAJE DE ERROR -->
        <div class="row mt-3" id="msj-error">
            <div class="col-12 text-center">
                <span class="text-center text-danger">El usuario o contraseña son incorrectos</span>
            </div>
        </div>
        
        <h6 class="text-center mt-3 texto-pass"><span>Olvidaste tu contraseña?</span> <a href="#">Recupérala aquí</a></h6>

        <h6 class="text-center mt-2 texto-cuenta mb-0"><span>No tienes cuenta?</span> <a href="#" id="registrate">Regístrate aquí</a></h6>
    
    </form>
  
    <script src="js/jquery.js"></script>
    <script src="js/app.js"></script>
    <script src="js/jqueryPostGo.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/popper.min.js"></script>
    <script type="module" src="js/asincrono.js"></script>
    
</body>
</html>