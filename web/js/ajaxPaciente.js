$(document).ready(function () {



    //Agregar contenido dinamico de etapaClinica



    //REGISTRAR CITA
    $('#btn-citaRegistrar').on('click', () => {

        $.ajax({
            url: 'PacienteController',
            cache: false,
            method: 'POST',
            data: {
                key: 'agregarEvento',
                hora: $('#RegistrarCita_hora').val(),
                tipo: $('#RegistrarCita_tipo').val(),
                medico: $('#RegistrarCita_medico').val(),
            }
        })
                .done(function (response) {
                    console.log(response);
                })
                .fail(function (xhr, textStatus, errorThrown) {
                    console.log(xhr.responseText);
                });
        //VERIFICACION
        console.log($('#RegistrarCita_fecha').val());
        console.log($('#RegistrarCita_hora').val());
        console.log($('#RegistrarCita_tipo').val());
        console.log($('#RegistrarCita_medico').val());
        console.log(miPiso);
        console.log(miEdificio);

        //CERRAR MODAL
        $('#modalAgregarCita').modal('toggle')
    });

    $('#feedbackEdAntiguo').hide();
    $('#feedbackEdTorre').hide();
    $('#pisosDiv').hide();

    $('#EdAntiguo').on('mouseover', function () {
        $('#feedbackEdAntiguo').show();
        $('#feedbackEdAntiguo').disabled = true;
    });
    $('#feedbackEdAntiguo').on('mouseout', function () {
        $('#feedbackEdAntiguo').hide();
    });

    $('#EdTorre').on('mouseover', function () {
        $('#feedbackEdTorre').show();
    });
    $('#feedbackEdTorre').on('mouseout', function () {
        $('#feedbackEdTorre').hide();
    });


    $('input:radio[name=Edificios]').change(function () {
        if (this.value == 'Edificio antiguo') {
            $('#pisosDiv').hide();
        } else if (this.value == 'Torre de nueva hospitalización') {
            $('#pisosDiv').show();
        }
    });

    //PARA IR A LA CUENTA
    $('#irACuenta').on('click', function () {
        $.get("SAPI", {
            file: "paciente/cuenta.jsp"
        },
                function (response, status, xhr) {
                    //console.log(response);
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
    //PARA SALIR DE LA CUENTA
    $('#salirCuenta').on('click', function () {
        console.log("Salir cuenta");
        $.get("LoginController", {
            key: "cerrar-sesion"
        },
                function (response, status, xhr) {
                    console.log(response);
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
    //PARA SALIR DE LA CUENTA
    $('#salirCuenta1').on('click', function () {
        console.log("Salir cuenta");
        $.get("LoginController", {
            key: "cerrar-sesion"
        },
                function (response, status, xhr) {
                    console.log(response);
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
    //
    function getValues(selector) {
        var els = document.querySelectorAll(selector);
        return [].map.call(els, el => el.value);
    }

    /*
     //PARA GUARDAR CAMBIOS
     $('#guardarCambios').on('click', function () {
     
     var data = [] = getValues('.dataTratamiento');
     
     // JSON.
     // console.log(data);
     
     $.ajax({
     url:'PacienteController',
     cache:false,
     method: 'POST',
     data:{
     key:"cambiarDatos",
     correo : $("#correo").val(),
     telefono : $("#telefono").val(),
     noExpediente : $("#noExpediente").val(),
     etapaClinica: $("#etapaClinica").val(),
     tipoSangre: $("#tipoSangre").val(),
     tratamientos : data
     }
     
     })
     
     .done(function (response) {
     console.log(response);
     
     
     swal({
     title: 'Buen Trabajo',
     text: "Cambios guardados correctamente",
     type: 'success',
     confirmButtonColor: '#3085d6',
     confirmButtonText: 'Ok'
     }).then((result) => {
     if (result.value) {
     window.location.reload();
     };
     });
     })
     .fail(function (xhr, textStatus, errorThrown) {
     console.log(xhr.responseText);
     });
     
     
     
     });
     */


    $('#guardarCambios').on('click', function () {

        console.log("Presionó GuardarCambios")
        var form = $("form")[0];
        var data = new FormData(form);

        var datos = [] = getValues('.dataTratamiento');
        data.append("datosTratamiento", JSON.stringify(datos));



        data.append("key", "cambiarDatos");
        data.forEach((value, key) => {
            console.log(key + " " + value);
        })

        $.ajax({
            url: "PacienteController",
            data: data,
            method: "POST",
            encType: "multipart/form-data",
            processData: false,
            contentType: false,
            cache: false,
            success: function (response) {
                $.post("SAPI", {
                    file: "paciente/cuenta.jsp"
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
                            url: "PotencialController",
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
