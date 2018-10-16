$(document).ready(function () {

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

    $('#btn-registro').on('click', function () {
        
        swal(
            "¿Te han tratado por cáncer de mama previamente?", {
                buttons: {
                    primeraVez: "No",
                    segundaOpinion: "Sí",
                }
            })
            .then((value) => {
                switch (value) {
                    case "primeraVez":
                        
                        break;
                    case "segundaOpinion":
                        
                        break;
                }
                $('#modalTerminos').modal('toggle');
            });

    });

    function oculta(campo) {
        campo.hide();
    }

    function muestra(campo) {
        campo.show();
    }

});