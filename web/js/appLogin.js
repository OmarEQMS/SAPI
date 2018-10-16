$(document).ready(function () {
    $("#msj-error").hide();
    
    $(document).on('click', function () {
        $("#msj-error").hide();
    });

    $('#btn-login').on('click', function () {
        var usu = $("#usuario");
        var pass = $("#password");
        $.get("SAPI", {
                key: "login",
                accion: "login",
                usuario: usu.val(),
                password: pass.val()
            },
            function (response, status, xhr) {
                if (status == "success") {
                    if (response == "error") {
                        $("#msj-error").show();
                    } else {
                        document.open("text/html", "replace");
                        document.write(response);
                        document.close();
                    }
                }
            }
        );
    });

    $('#registrate').click(function () {
        $.postGo("SAPI", {
            key: "JSP",
            archivo: "registro",
        });
    });

});


