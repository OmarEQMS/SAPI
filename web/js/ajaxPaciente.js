$(document).ready(function () {


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

    $('#EdAntiguo').on('mouseover', function() {
        $('#feedbackEdAntiguo').show();
        $('#feedbackEdAntiguo').disabled = true;
    });
    $('#feedbackEdAntiguo').on('mouseout', function() {
        $('#feedbackEdAntiguo').hide();
    });

    $('#EdTorre').on('mouseover', function() {
        $('#feedbackEdTorre').show();
    });
    $('#feedbackEdTorre').on('mouseout', function() {
        $('#feedbackEdTorre').hide();
    });

    
    $('input:radio[name=Edificios]').change(function() {
        if (this.value == 'Edificio antiguo') {
            $('#pisosDiv').hide();
        }
        else if (this.value == 'Torre de nueva hospitalización') {
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
    
});