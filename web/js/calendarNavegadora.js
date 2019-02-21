$(document).ready(function () {

    $('#error-pacienteSelected').hide();

    //Recupera Titulo
    $("#paciente-resultado").on('change', function () {

        $('#tituloCita').val($(this).find(':selected').html());

    });


    $('#calendarCitasPaciente').fullCalendar({
        locale: 'es',
        height: 630,
        themeSystem: 'bootstrap4',
        header: {
            left: 'prev,next today',
            center: 'month,agendaWeek,agendaDay',
            right: 'title'
        },
        eventBackgroundColor: "#eb5865",
        eventBorderColor: "#de1f1f",
        eventLimit: true, // allow "more" link when too many events
        eventClick: function (calEvent, jsEvent, view) {

            $('#modalVerCita').modal('toggle');


            $('#nombrePacienteCalendario').html(calEvent.title);

        },
        dayClick: function (date) {

            var dateFinal = new Date(date);
            dateFinal.setDate(dateFinal.getDate() + 1);

            $('#fechaCita').val(convertDate(dateFinal));

            var m = moment(date);

            $('#dia-cita').html(m.locale("es").format("LL"));

            $('#error-pacienteSelected').hide();
            $("#paciente-resultado").css('border', '');
            $("#paciente-resultado").css('color', '');
            $("#paciente-resultado").prop('selectedIndex', 0);

            $('#modalAgregarCita').modal('toggle');
        },
        eventSources: [
            {
                url: 'NavegadoraController',
                type: 'POST',
                data: {
                    key: 'obtenerEventosResultados'
                },
                textColor: 'white',
                success: function (response) {
                }
            }

        ]
    });

    //Cambiar de color los botones del calendario y varios textos
    $('.fc-agendaWeek-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-month-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-agendaDay-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-prev-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-next-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-today-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-right h2').addClass('display-4').css({'color': '#696f71', 'font-size': '30px'});


    //Agregar Cita
    $('#btn-registrarCitaResultados').on('click', function () {

        var idPaciente = $("#paciente-resultado").val();
        var nombre = $('#paciente-resultado option:selected').html();

        if (isValidSelect($("#paciente-resultado"))) {

            $('#error-pacienteSelected').hide();

            $.ajax({

                url: 'NavegadoraController',
                method: 'POST',
                cache: false,
                data: {
                    key: 'agregarCitaResultados',
                    idPaciente: idPaciente,
                    nombre: nombre,
                    fechaCita: $('#fechaCita').val()
                },
                success: function (response) {

                    if (response == "success") {

                        var newEvent = {

                            title: $('#tituloCita').val(),
                            start: $('#fechaCita').val() + " 07:50:00",
                            color: '#eb5865',
                            textColor: 'white'

                        };

                        $('#calendarCitasPaciente').fullCalendar('renderEvent', newEvent);


                        swal({
                            title: "¡Buen trabajo!",
                            text: "Cita agregada correctamente.",
                            closeOnEsc: false,
                            closeOnClickOutside: false,
                            icon: "success",
                            buttons: [, 'Aceptar'],
                        });

                        $('#modalAgregarCita').modal('toggle');
                        $("#paciente-resultado").prop('selectedIndex', 0);

                    } else {
                        swal({
                            title: "Error",
                            text: "Hubo un error al agregar la cita",
                            icon: "error",
                            closeOnEsc: false,
                            closeOnClickOutside: false,
                            button: "Aceptar",
                        });
                    }

                }

            });

        } else {
            $('#error-pacienteSelected').show();
        }

    });

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


    }

    function formatDate(date) {
        var d = new Date(date),
                month = '' + (d.getMonth() + 1),
                day = '' + (d.getDate()),
                year = d.getFullYear();

        if (month.length < 2)
            month = '0' + month;
        if (day.length < 2)
            day = '0' + day;

        return [year, month, day].join('-');
    }

    function convertDate(date) {
        var yyyy = date.getFullYear().toString();
        var mm = (date.getMonth() + 1).toString();
        var dd = date.getDate().toString();

        var mmChars = mm.split('');
        var ddChars = dd.split('');

        return yyyy + '-' + (mmChars[1] ? mm : "0" + mmChars[0]) + '-' + (ddChars[1] ? dd : "0" + ddChars[0]);
    }


});