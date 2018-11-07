$(document).ready(function () {

    //esconder mensajes de error
    $("#error-campos").hide();

    //Recuperar edificio
    var edificio;

    $("input:radio[name=Edificios]").click(function () {
        edificio = $(this).val();

    });

    //Recupera ColoR

    $('input[type=radio][name=Edificios]').on('change', function () {

        console.log('Valor seleccionado de EDIFICIOS: ' + parseInt($(this).val()));

        if (parseInt($(this).val()) === 1) {
            $('#colorCita').val($('input:radio[name=Edificios]:checked').attr("data-color"));
            console.log($('#colorCita').val());
        }

    });

    $('input[type=radio][name=Pisos]').on('change', function () {

        console.log('Valor seleccionado de PISOS: ' + parseInt($(this).val()));

        $('#colorCita').val($('input:radio[name=Pisos]:checked').attr("data-color"));

        console.log($('#colorCita').val());

    });

    //Recuperar piso
    var piso = 0;

    $("input:radio[name=Pisos]").click(function () {
        piso = $(this).val();
    });

    $('#RegistrarCita_hora').on('change', function () {

        $('#fechaProgramada').val($('#fechaTemp').val() + ' ' + $(this).val() + ":00");

        console.log($('#fechaProgramada').val());
    });

    //Recupera Titulo
    $('#RegistrarCita_tipo').on('change', function () {

        $('#tituloCita').val($(this).find(':selected').data('nombre'));

        console.log($('#tituloCita').val());

    });


//Agregar contenido dinamico de etapaClinica

//Valor a inputs modal
    $(".terminarTratamiento").on('click', function () {

        if (response === "success") {

            var newEvent = {

            };

            $('#calendarCitasPaciente').fullCalendar('renderEvent', newEvent);

            swal({
                title: "Buen Trabajo!",
                text: "La cita se ha registrado correctamente!",
                icon: "success",
            });
        }

    });

//REGISTRAR CITA
    $('#btn-citaRegistrar').on('click', () => {

        var esValid = false;
        //Verificar que todos los campos que han marcado
        if (isValidHour($('#RegistrarCita_hora')) && isValidSelect($('#RegistrarCita_tipo')) && isValidSelect($('#RegistrarCita_medico')) && isValidRadioChecked($('input[name=Edificios]'))) {
            $("#error-campos").hide();
            if (parseInt($('input[name=Edificios]:checked').val()) == 1) {
                esValid = true;
            } else {
                //Validamos los pisos
                if (isValidRadioChecked($('input[name=Pisos]'))) {
                    esValid = true;
                    $("#error-campos").hide();
                } else {
                    $("#error-campos").show();
                }
            }
        

                    if (esValid) {

                $.ajax({
                    url: 'PacienteController',
                    cache: false,
                    method: 'POST',
                    data: {
                        key: 'agregarEvento',
                        //hora: $('#RegistrarCita_hora').val(),
                        tipo: $('#RegistrarCita_tipo').val(),
                        medico: $('#RegistrarCita_medico').val(),
                        edificio: edificio,
                        piso: piso,
                        idPaciente: $('#idPaciente').val(),
                        fechaProgramada: $('#fechaProgramada').val()

                    }
                })
                        .done(function (response) {

                            console.log(response);

                            if (response === "success") {

                                var newEvent = {

                                    title: $('#tituloCita').val(),
                                    start: $('#fechaProgramada').val(),
                                    color: $('#colorCita').val(),
                                    textColor: 'white'

                                };

                                $('#calendarCitasPaciente').fullCalendar('renderEvent', newEvent);

                                swal({
                                    title: "Buen Trabajo!",
                                    text: "La cita se ha registrado correctamente!",
                                    icon: "success",
                                });


                                $('#modalAgregarCita').modal('toggle');

                            } else {
                                swal({
                                    title: "Algo salió mal!",
                                    text: "No se pudo registrar la cita, intentalo de nuevo!",
                                    icon: "error",
                                });
                            }

                        })
                        .fail(function (xhr, textStatus, errorThrown) {
                            console.log(xhr.responseText);
                        });
            }

        } else {
            $("#error-campos").show();
            //alert("SELECCIONA TODO -.-");
        }

        //CERRAR MODAL

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
        if (this.value == 1) {
            $("input:radio[name=Pisos]").prop('checked', false);
            $('#pisosDiv').hide();
        } else if (this.value == 2) {
            $('#pisosDiv').show();
        }
    });

    //PARA IR A LA CUENTA
    $('.irACuenta').on('click', function () {
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
    
    //PARA IR A INICIO PACIENTE
    $('#irAInicioPaciente').on('click', function () {
        $.post("SAPI", {
            file: "paciente/index.jsp"
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
    });

    //PARA IR A mis Tratamientos
    $('#irATratamientos').on('click', function () {
        $.get("SAPI", {
            file: "paciente/misTratamientos.jsp"
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

    //PARA IR A mis Citas
    $('#irMisCitas').on('click', function () {
        $.get("SAPI", {
            file: "paciente/index.jsp"
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


    //Eliminar Cuenta
    $('#eliminarCuenta').on('click', function () {

        swal({
            title: "¿Estás segura(o)?",
            text: "Los datos se eliminarán y no podrás recuperarlos ni poder acceder a tu cuenta.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],

        })
                .then((eliminar) => {
                    if (eliminar) {
                        $.ajax({
                            url: "PacienteController",
                            data: {
                                key: "eliminarCuentaPaciente",
                                idCuenta: $("#sesionPaciente").val()

                            },
                            method: "POST",
                            success: function (response) {
                                if (response == "error") {
                                    console.log("Error al cargar");
                                } else {
                                    console.log("Intentando redireccionar");
                                    document.open("text/html", "replace");
                                    document.write(response);
                                    document.close();

                                }
                            },
                            error: function (xhr) {

                            }

                        });


                    } else {

                    }
                });



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
        
        if(isValidEmail($("#correo")) &&
                isValidPhoneNumber($("#telefono")) &&
                isValidNoExpediente($("#noExpediente"))
                ){


        console.log("Presionó GuardarCambios")
        var form = $("form")[0];
        var data = new FormData(form);
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
        
        }else{
              swal({
  title: "Datos invalidos!",
  text: "Revisa todos los campos antes de continuar",
  icon: "error",
});
        }
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
    //Agregar tratamientos
    $("#btn-agregarTratamiento").on('click', function () {

    if($("#tipoTratamiento").val()!="Elegir Tratamiento")
        console.log($("#tipoTratamiento").val());
            
        if(isValidDate($('#fechaInicioTratamiento')) && $("#tipoTratamiento").val()!=null ){
    
        $.ajax({
            url: 'PacienteController',
            cache: false,
            method: 'POST',
            data: {
                key: 'agregarTratamiento',
                idTipoTratamiento: $('#tipoTratamiento').val(),
                fechaInicio: $('#fechaInicioTratamiento').val(),
            }
        })
                .done(function (response) {

                    console.log(response);

                    $('#modalAgregarTratamiento').modal('toggle'); //cerrar modal
                    swal({
                        title: "Tratamiento registrado correctamente",
                        icon: "success",
                    });
                    var row = "<tr>" +
                            "<input type='hidden' id='nombre-" + response + "' value='" + $("#nombreTipoTratamiento").val() + "'/>" +
                            "<input type='hidden' id='fechaInicio-" + response + "' value='" + $("#fechaInicioTratamiento").val() + "'/>" +
                            "<td id='nombre-" + response + "' value='" + $("#tipoTratamiento").val() + "' >" + $("#nombreTipoTratamiento").val() + "</td>" +
                            "<td id='fechaInicio-" + response + "' value='" + $("#fechaInicioTratamiento").val() + "' >" + $("#fechaInicioTratamiento").val() + "</td>" +
                            "<td  id='fecha-" + response + "'>" + "</td>" +
                            "<td><button class='btn btn-primary terminarTratamiento' id='modal-" + response + "' data-id='" + response + "'data-toggle='modal' data-target='#modalEditarTerminado'> <i class='fas fa-edit'></i> </button></td > " +
                            "</tr>";
                    $("#tablaTratamientos").append(row);

                    $('#tipoTratamiento').prop('selectedIndex', 0);

                    $("#fechaInicioTratamiento").val('');

                    $('#idTratamientoPaciente').val(response);

                })
                .fail(function (xhr, textStatus, errorThrown) {
                    console.log(xhr.responseText);
                });
            }else{
                swal({
  title: "Datos invalidos!",
  text: "Revisa todos los campos antes de continuar",
  icon: "error",
});
            }
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
    //Terminar tratamiento
    $("#fechaTerminarTratamiento").on('click', function () {

        if(isValidDate2($('#fechaFinTratamiento'), $("#fechaInicio-"+$("#botonHidden").val()).val())){
    
        $.ajax({
            url: 'PacienteController',
            cache: false,
            method: 'POST',
            data: {
                key: 'terminarTratamiento',
                idTratamientoPaciente: $('#idTratamientoPaciente').val(),
                fechaFin: $('#fechaFinTratamiento').val()
            }
        })

                .done(function (response) {

                    $('#modalEditarTerminado').modal('toggle'); //cerrar modal
                    swal({
                        title: "Tratamiento finalizado",
                        icon: "success",
                    });
                    //actualizar la tabla
                    $('#fecha-' + $('#idTratamientoPaciente').val()).html($('#fechaFinTratamiento').val());
                    $("#fechaFinTratamiento").val('');

                    $("#modal-" + $("#botonHidden").val()).attr("disabled", "disabled").removeClass("btn-primary").addClass("btn-secondary");



                })
                .fail(function (xhr, textStatus, errorThrown) {
                    console.log(xhr.responseText);
                });
                
        }else{
            swal({
  title: "Datos invalidos!",
  text: "Revisa todos los campos antes de continuar",
  icon: "error",
});
        }
    });
    //Designar idTratamientoPaciente
    $('body').on('click', '.terminarTratamiento', function () {

        $('#idTratamientoPaciente').val($(this).data('id'));

        $("#botonHidden").val($(this).data('id'));

        //alert($('#idTratamientoPaciente').val());

        $("#tipoTratamiento2").val(
                $("#nombre-" + $(this).data('id')).val()

                );
        $("#fechaInicioTratamiento2").val(
                $("#fechaInicio-" + $(this).data('id')).val()
                );

    });

    //Conseguir contenido del select

    $("#tipoTratamiento").on('change', function () {



        $('#nombreTipoTratamiento').val($('#tipoTratamiento option:selected').text());
        console.log($('#nombreTipoTratamiento').val());
    });
    
    function isValidNoExpediente (input) {

        var m = input.val();

        var expreg = /^[a-zA-Z0-9]{9,9}$/;


        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;


    };
    
    function isValidEmail (input)  {

        var m = input.val();

        ////Expresion regular por el estandard: RFC 5322
        var expreg = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;

    };
    
    function isValidPhoneNumber (input) {

        var m = input.val();

        var expreg = /^[0-9]{10,10}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    };

    function isValidHour(input) {

        if (!input.val()) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;


    };

    function isValidSelect(input) {

        if (!input.val()) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;


    };

    function isValidRadioChecked(input) {

        if (!input.is(':checked')) {

            return false;
        }

        return true;
    };
    
    function isValidDate (input) {

        //Obtener fecha
        let today = new Date();

        //Valor seleccionado del input
        let date_from = input.val();
        date_from = new Date(date_from);
        var todayYear= today.getFullYear();
        var inicioYear = date_from.getFullYear();
        var event = false;
        
        if(today > date_from && inicioYear >= todayYear-5){
            event=false;
            console.log("Valido");
        }
        else{
            event=true;
            console.log("Invalido");
        }
        

       


        if (!input.val() || event) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;


    };

    function isValidDate2 (input, fechaInicio) {

        //var mydate = new Date('2014-04-03');
        //Obtener fecha
        let today = new Date();

        //Valor seleccionado del input
        let date_from = input.val();
       
        console.log(fechaInicio);
        date_from = new Date(date_from);
        var date_Inicio = new Date(fechaInicio);

        var event = false;
        
        console.log(input.val());
        
        console.log("Date inicio"+date_Inicio);
        console.log("El años es: "+date_Inicio.getFullYear());
        console.log("Date from" +date_from);
        console.log("El años es: "+date_from.getFullYear());
         
        var inicioYear = date_Inicio.getFullYear();
        var inputYear = date_from.getFullYear();
        
        if(inputYear < inicioYear+5 &&  date_Inicio <= date_from ){
            event = false;
            console.log(event);
            console.log("fechaValida");
        }
        else{
            event= true;
            console.log(event);
            console.log("fechaInValida");
        }
        
       // date_Inicio > date_from ? event = true : event = false;

        if (!input.val() || event) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;


    };



});