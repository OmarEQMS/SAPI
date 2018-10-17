$(document).ready(function () {
    $("#msj-error").hide();
    
    $(document).on('click', function () {
        $("#msj-error").hide();
    });

    $('#btn-login').on('click', function () {
        alert();

        var usuario = $('#user');
        var password = $('#password');

        $.ajax({

            url: 'LoginController',
            cache: false,
            method: 'POST',
            data: {
                key: 'verificar',
                usuario: usuario.val(),
                password: password.val()
            },
            success: function (response) {

                if (response == 'success') {

                    $('#msj-error').hide();

                } else {
                    $('#msj-error').show();
                }


            }


        });

    });

    $('#registrate').click(function () {
        $.postGo("SAPI", {
            key: "JSP",
            archivo: "registro",
        });
    });

});


