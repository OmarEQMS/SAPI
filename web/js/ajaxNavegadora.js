$(document).ready(function () {


    
    //Eliminar cuenta
    $('#eliminarCuentaNavegadora').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "Los datos se eliminarán y no podrás recuperarlos.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
            .then((eliminar) => {
                if (eliminar) {



                } else {

                }
            });

    });

    //Enviar Observaciones
    $('#enviarObservaciones').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "Estas observaciones se enviarán al paciente.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
            .then((enviar) => {
                if (enviar) {

                    //ajax para aprobar

                    location.href = "./index.html"

                } else {

                }
            });

    });

    $('#btn-cancelar').on('click', () => {

        swal({
            title: "¿Estás segura(o) de cancelar la cita?",
            text: "El paciente tendrá que solicitar de nuevo cita a preconsulta.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
            .then((cancelar) => {
                if (cancelar) {



                } else {

                }
            });

    });

    //Enviar todos los datos del formulario
    $('#btn-sendAll').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "Los datos serán almacenados y no será posible su posterior edición.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
            .then((enviar) => {
                if (enviar) {



                } else {

                }
            });

    });

    //aprobar
    $('#btn-aprobar').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "Este documento será guardado como un documento válido y no podrás cambiar ese estatus.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
            .then((aprobar) => {
                if (aprobar) {

                    //ajax para aprobar

                    //location.href = "./documentos3.html"

                } else {

                }
            });

    });

    $('#btn-eliminar').on('click', () => {

        swal({
            title: "¿Estás segura?",
            text: "Una vez eliminado, el paciente y sus datos ya no se podrán recuperar.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
            .then((eliminar) => {
                if (eliminar) {



                } else {

                }
            });

    });

    $('#btn-eliminar2').on('click', () => {

        swal({
            title: "¿Estás segura?",
            text: "Una vez eliminado, el paciente y sus datos ya no se podrán recuperar.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
            .then((eliminar) => {
                if (eliminar) {



                } else {

                }
            });

    });

     $('#guardarCambios').on('click', function () {

        console.log("Presionó GuardarCambios")
        var form = $("form")[0];
        var data = new FormData(form);
        data.append("key", "cambiarDatos");
        data.forEach((value, key) => {
            console.log(key + " " + value);
        })

        $.ajax({
            url: "NavegadoraController",
            data: data,
            method: "POST",
            encType: "multipart/form-data",
            processData: false,
            contentType: false,
            cache: false,
             success: function (response) {
                $.post("SAPI", {
                    file: "navegadora/cuentaNavegadora.jsp"
                },
                        function (response, status, xhr) {
                            console.log("El ajax fue exitoso!!-----------------------");
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
            },
            error: function (xhr) {
                //alert(xhr.statusText);
            }
        });
    });
    
    //Cambiar imagen temporalmente en elfront
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#ImagenPerfil').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#file-input").on('change', function () {
        console.log("Llegó :)");
        readURL(this);
    });
    
        //Cambiar contraseña

    $("#btn-updatePassword").on('click', function () {



        //Modal cambiar contraseña 
        swal({
            title: "¿Estás segura(o) que deseas guardar los cambios de tu contraseña?",
            text: "No podras volver a usar tu contraseña anterior para ingresar",
            icon: "warning",
            buttons: true,
            buttons: ['Regresar', 'Cambiar contraseña'],
            dangerMode: true
        })
                .then((cambiar) => {
                    if (cambiar) {


                        $.ajax({
                            url: "NavegadoraController",
                            data: {
                                key: "cambiarContrasena",
                                idCuenta: $("#sesionPaciente").val(),
                                password: $("#password").val(),
                                password2: $("#password-confirm").val()
                            },
                            method: "POST",
                            success: function (response) {
                                if (response == "success") {

                                } else {
                                    //Aqui no se que hace
                                }
                            },
                            error: function (xhr) {

                            }
                        });
                        $('#modalCambiarContraseña').modal('toggle');
                    } else {

                    }

                });
    });

});

