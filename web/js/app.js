$(document).ready(function () {

    $("#registrate").on('click', function () {
        $.postGo("ZonaController", {
            file: "registro.jsp",
            key: "getRegistro"
        });
    });

    $("#regresarIndex").on('click', function () {
        $.postGo("SAPI", {
            file: "index.jsp"
        });
    });


    var pantalla1 = $('#pantalla1');
    var pantalla2 = $('#pantalla2');
    var btnRegresar = $('#btn-regresar');
    var btnContinuar = $('#btn-continuar');
    var btnRegistro = $('#btn-registro');

    oculta(btnRegistro);
    oculta(pantalla2);
    oculta(btnRegresar);

    $('#btn-continuar').on('click', function () {

        oculta(btnContinuar);
        oculta(pantalla1);
        muestra(pantalla2);
        muestra(btnRegistro);
        muestra(btnRegresar);

    });

    $('#btn-regresar').on('click', function () {

        oculta(pantalla2);
        oculta(btnRegistro);
        oculta(pantalla2);
        oculta(btnRegresar);
        muestra(pantalla1);
        muestra(btnContinuar);

    });

   
        
    function oculta(campo) {
        campo.hide();
    }

    function muestra(campo) {
        campo.show();
    }

});