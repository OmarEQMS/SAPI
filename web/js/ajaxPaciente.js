$(document).ready(function () {

    //Recuperar edificio
    var edificio;

    $("input:radio[name=Edificios]").click(function () {
        edificio = $(this).val();
       
    });
    
    //Recupera ColoR
    
    $('input[type=radio][name=Edificios]').on('change',function () {
        
        console.log('Valor seleccionado de EDIFICIOS: ' + parseInt($(this).val()));
        
        if(parseInt($(this).val()) === 1){
            $('#colorCita').val($('input:radio[name=Edificios]:checked').attr("data-color"));
            console.log($('#colorCita').val());
        }
        
    });
    
    $('input[type=radio][name=Pisos]').on('change',function () {
        
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
    $('#RegistrarCita_tipo').on('change', function(){
        
        $('#tituloCita').val($(this).find(':selected').data('nombre'));
        
        console.log($('#tituloCita').val());
        
    });


//Agregar contenido dinamico de etapaClinica

//Valor a inputs modal
$(".terminarTratamiento").on('click', function(){
    
    
    
    
});

//REGISTRAR CITA
    $('#btn-citaRegistrar').on('click', () => {

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
if (this.value == 1) {
            $("input:radio[name=Pisos]").prop('checked', false);
            $('#pisosDiv').hide();
        } else if (this.value == 2) {
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
                            /*console.log("El ajax fue exitoso!!-----------------------");
                             if (status == "success") {
                             if (response == "error") {
                             $("#msj-error").show();
                             } else {
                             
                             
                             document.open("text/html", "replace");
                             document.write(response);
                             document.close();
                             }
                             }*/
                            swal({
                                title: 'Buen Trabajo',
                                text: "Cambios guardados correctamente",
                                type: 'success',
                                confirmButtonColor: '#3085d6',
                                confirmButtonText: 'Ok'
                            }).then((result) => {
                                if (result.value) {
                                    window.location.reload();
                                }
                                ;
                            });
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
    //Agregar tratamientos
    $("#btn-agregarTratamiento").on('click', function () {

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
                            "<input type='hidden' id='nombre-"+response+"' value='"+$("#nombreTipoTratamiento").val()+"'/>"+
                            "<input type='hidden' id='fechaInicio-"+response+"' value='"+$("#fechaInicioTratamiento").val()+"'/>"+
                            "<td id='nombre-"+response+"' value='"+$("#tipoTratamiento").val()+"' >" + $("#nombreTipoTratamiento").val() + "</td>" +
                            "<td id='fechaInicio-"+response+"' value='"+$("#fechaInicioTratamiento").val()+"' >"  + $("#fechaInicioTratamiento").val() + "</td>" +
                            "<td  id='fecha-"+response+"'>"  + "</td>" +
                            "<td><button class='btn btn-primary terminarTratamiento' id='modal-"+response+"' data-id='" + response + "'data-toggle='modal' data-target='#modalEditarTerminado'> <i class='fas fa-edit'></i> </button></td > " +
                            "</tr>";
                    $("#tablaTratamientos").append(row);
                    
                    $('#tipoTratamiento').prop('selectedIndex',0);
                    
                    $("#fechaInicioTratamiento").val('');
                    
                    $('#idTratamientoPaciente').val(response);
                   
                })
                .fail(function (xhr, textStatus, errorThrown) {
                    console.log(xhr.responseText);
                });
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
                     
                     $("#modal-"+$("#botonHidden").val()).attr("disabled", "disabled").removeClass("btn-primary").addClass("btn-secondary");
                     
                     
                     
                })
                .fail(function (xhr, textStatus, errorThrown) {
                    console.log(xhr.responseText);
                });
    });
    //Designar idTratamientoPaciente
    $('body').on('click', '.terminarTratamiento', function () {

        $('#idTratamientoPaciente').val($(this).data('id'));
        
        $("#botonHidden").val($(this).data('id'));
        
       alert($('#idTratamientoPaciente').val());
        
        $("#tipoTratamiento2").val(
                $("#nombre-"+$(this).data('id')).val()
               
              );
        $("#fechaInicioTratamiento2").val(
                 $("#fechaInicio-"+$(this).data('id')).val()
                );
        
    });
    //Conseguir contenido del select

    $("#tipoTratamiento").on('change', function () {



        $('#nombreTipoTratamiento').val($('#tipoTratamiento option:selected').text());
        console.log($('#nombreTipoTratamiento').val());
    });
});