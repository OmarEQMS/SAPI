/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

//Inicializar el calendario
$('#calendarCitas').fullCalendar({
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
    eventClick: function () {
        $('#modalVerCitaPreConsulta').modal('toggle');

    },
    events: [
        {
            title: 'Preconsulta',
            start: '2018-09-30'
        },
        {
            title: 'Navegación',
            start: '2018-09-30'
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
$('.fc-right h2').addClass('display-4').css({ 'color': '#696f71', 'font-size': '30px' });

});


