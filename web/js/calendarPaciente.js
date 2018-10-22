/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

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

            var d = new Date(Date.parse(calEvent.start._i));
          
            var dias = ["Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"];
            
            var meses = [ "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" ];
            
            $('#titulo-cita').html(calEvent.title);
            $('#dia-cita').html(dias[d.getDay()-1] + " " + d.getDay() + " " + "de " + meses[d.getMonth()]);
            $('#hora-cita').html(d.getHours()+":"+d.getMinutes());
            $('#modalVerCita').modal('toggle');

        },
        dayClick: function (date, jsEvent, view) {
            
            
            $('#dia-registrarCita').html(date.format('LL'));
            
            $('#modalAgregarCita').modal('toggle');
            
        },
        eventSources: [
            {
                url: 'PacienteController',
                type: 'POST',
                data: {
                    key: 'obtenerEventos',
                    idPaciente: $('#idPaciente').val()
                },
                textColor: 'white',
                success: function (response) {
                    console.log(response);
                }
            }

        ],

    });

    //Cambiar de color los botones del calendario y varios textos
    $('.fc-agendaWeek-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-month-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-agendaDay-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-prev-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-next-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-today-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-right h2').addClass('display-4').css({'color': '#696f71', 'font-size': '30px'});

});


