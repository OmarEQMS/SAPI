$(document).ready(function () {

    // Inicializar plug in tooltipster
    $('.questionMark').tooltipster({
        theme: 'tooltipster-shadow',
        delay: '140'
    });

    $('[data-toggle="tooltip"]').tooltipster({
        theme: 'tooltipster-shadow',
        delay: '140'
    });

    $('#biopsiaContenedor').hide();
    $('#biopsiaQuestion').hide();

    //Reemplazar el nombre del archivo en el input
    $('body').on('change', '.custom-file-input', function () {
        $(this).next('.custom-file-label').addClass("selected").html($(this).val());
    });

    //Esconder menu lateral a presionar click en el menu hamburguesa
    $('#sidebarCollapse').on('click', () => {
        $('#sidebar, #content').toggleClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
    });

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


    $("#motivoConsulta").on('change', () => {

        var motivo = $('#motivoConsulta').val();
        console.log(motivo);

        switch (motivo) {
            case "Me envió un médico":
                $('#documentoAdjuntoMotivo').html("");
                $('#otroHospital').html("");
                $('#estudioMotivo').html("");

                var referencia =
                    '<div class="col-3 text-center">'
                    + '<span class="textoDocumento">Referencia</span>'
                    + '</div>'
                    + '<div class="custom-file col-8" id="customFile">'
                    + '<input type="file" class="custom-file-input" multiple="multiple" aria-describedby="fileHelp">'
                    + '<label class="custom-file-label">'
                    + 'Adjunta la hoja de referencia de médico.'
                    + '</label>'
                    + '</div>';

                $('#documentoAdjuntoMotivo').html(referencia);
                break;
            case "Me envían de otro hospital":

                $('#documentoAdjuntoMotivo').html("");
                $('#otroHospital').html("");
                $('#estudioMotivo').html("");

                var otroHospital =
                    '<div class="col-3 text-center">'
                    + '<span class="textoDocumento">Hospital</span>'
                    + '</div>'
                    + '<div class="custom-file col-8 p-0 m-0" id="customFile">'
                    + '<input type="text" class="form-control" placeholder="Introduce tu hospital de procedencia">'
                    + '</div>';

                var referencia =
                    '<div class="col-3 text-center">'
                    + '<span class="textoDocumento">Referencia</span>'
                    + '</div>'
                    + '<div class="custom-file col-8" id="customFile">'
                    + '<input type="file" class="custom-file-input" multiple="multiple" aria-describedby="fileHelp">'
                    + '<label class="custom-file-label">'
                    + 'Adjunta la hoja de referencia de médico del hospital.'
                    + '</label>'
                    + '</div>';
                ;
                $('#documentoAdjuntoMotivo').html(referencia);
                $('#otroHospital').html(otroHospital);
                break;
            case "Otro":
                console.log("OTRO");
                $('#documentoAdjuntoMotivo').html("");
                $('#otroHospital').html("");
                $('#estudioMotivo').html("");

                var otroHospital =
                    '<div class="col-3 text-center">'
                    + '<span class="textoDocumento">Otro motivo</span>'
                    + '</div>'
                    + '<div class="custom-file col-8 p-0 m-0" id="customFile">'
                    + '<input type="text" class="form-control" placeholder="Introduce otro motivo">'
                    + '</div>';

                $('#otroHospital').html(otroHospital);
                break;
            case "Estudio con diagnóstico de cáncer de mama":
                $('#documentoAdjuntoMotivo').html("");
                $('#otroHospital').html("");
                $('#estudioMotivo').html("");

                var estudio =

                    '<div class="col-3 text-center">'
                    + '<span class="textoDocumento">Estudios previos</span>'
                    + '</div>'

                    + '<div class="custom-file col-8" id="customFile">'
                    + '<input type="file" class="custom-file-input" multiple="multiple" aria-describedby="fileHelp">'
                    + '<label class="custom-file-label">'
                    + 'Elegir archivos...(Puedes subir mas de uno)'
                    + '</label>'
                    + '</div>'

                    + '<div class="col-1 iconoQuestion align-self-center">'
                    + '<a href="#" class="questionMark" data-tooltip-content="#tooltip_content2"><i'
                    + 'class="fas fa-question-circle"></i></a>'
                    + '</div>'

                    + '<div class="tooltip_templates">'
                    + '<span id="tooltip_content2">'
                    + 'Puedes subir mas de un archivo'
                    + '</span>'
                    + '</div>';

                $('#estudioMotivo').html(estudio);
                break;
            default:
                console.log("default");
                break;
        }
    });

    //Checkbox biopsia
    $('#biopsiaInput').on('change', () => {

        var tieneBiopsia = $('#biopsiaInput').is(':checked') ? 1 : 0;

        switch (tieneBiopsia) {
            case 1:
                $('#biopsiaContenedor').show();
                $('#biopsiaQuestion').show();
                break;
            case 0:
                $('#biopsiaContenedor').hide();
                $('#biopsiaQuestion').hide();
                break;
        }
    });


});