$(document).ready(function () {

    // Inicializar plug in tooltipster
    $('.questionMark').tooltipster({
        theme: 'tooltipster-shadow',
        delay: '140'
    });

    //Reemplazar el nombre del archivo en el input
    $('.custom-file-input').on('change', function () {
        $(this).next('.custom-file-label').addClass("selected").html($(this).val());
    });

    //Esconder menu lateral a presionar click en el menu hamburguesa
    $('#sidebarCollapse').on('click', () => {
        $('#sidebar, #content').toggleClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
    });


    //Cambiar de color los botones del calendario y varios textos
    $('.fc-agendaWeek-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-month-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-agendaDay-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-prev-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-next-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-today-button').removeClass('btn-primary').addClass('btn-outline-danger');
    $('.fc-right h2').addClass('display-4').css({ 'color': '#696f71', 'font-size': '30px' });

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
        eventClick: function () {

            $('#modalVerCita').modal('toggle');

        },
        dayClick: function (date) {
            $('#modalAgregarCita').modal('toggle');
        },
        events: [
            {
                title: 'Cita Radiologo',
                start: '2018-09-23'
            },
            {
                title: 'Cita Nutriologo',
                start: '2018-08-30'
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

    $("#btn-eliminarSintoma").on('click', function(){
        var id = $(this).data('id');
        console.log(id);

        //Modal borrar sintoma
        swal({
            title: "Estás a punto de eliminar este sintoma:",
            text: "-Dolor Muscular",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
            .then((eliminar) => {
                if (eliminar) {
                    $.ajax({
                        url: ''/*VACIO POR EL MOMENTO*/,
                        cache: false,
                        method: 'POST',
                        data: {
                            key: '',//FALTA DEFINIR 'key', PUEDE SER "borrar",
                            idSintoma: id
                        }
                    })
                    .done(function (response) {
                        console.log(response);
                    })
                    .fail(function (xhr, textStatus, errorThrown) {
                        console.log(xhr.responseText);
                    });
                } else {

                }
            });

    });

    ///////////////////////////////NAVEGADORAS
    $("#tablaSintomas").DataTable({
        "searching": false,
        responsive: true,
        dom: 'lBfrtip',
        buttons: [

            {
                extend: 'excel',
                text: 'Exportar a Excel',
                className: 'btn-success'
            },
            {
                extend: 'pdf',
                text: 'Exportar a pdf',
                className: 'btn-info'
            }
        ],

        "language": {

            "sProcessing": "Procesando...",
            "sLengthMenu": "Mostrar _MENU_ registros",
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": "Ningún dato disponible en esta tabla",
            "sInfo": "",
            "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }

        }

    });

    $('#btnAgregarSintoma').on('click', function () {

        swal({
            html: true, /*Julio, la consola me dijo esto
                        SweetAlert warning: "html" option has been deprecated. Please use "content" instead.*/
            title: "Estas apunto de agregar este sintoma:",
            text: "-Dolor Muscular \n \n Se recomienda poner en contacto con su medico",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
            .then((agregar) => {
                if (agregar) {
                     $.ajax({
                        url: ''/*VACIO POR EL MOMENTO*/,
                        cache: false,
                        method: 'POST',
                        data: {
                            key: '',//FALTA DEFINIR 'key', PUEDE SER "agregar",
                            /*$('#estadoAnimo').data("idAnimo")*/
                            Animo: $('#estadoAnimo').data("idanimo"),
                            Peso: $('#inputPeso').val(),
                            Pulso: $('#inputPulso').val(),
                            Presion: $('#inputPresion').val(),
                            Glucosa: $('#inputGlucosa').val(),
                            Oxigenacion: $('#inputOxigenacion').val(),
                            Temperatura: $('#inputTemperatura').val()
                            /*FALTAN SLIDERS*/
                        }
                    })
                    .done(function (response) {
                        console.log(response);
                    })
                    .fail(function (xhr, textStatus, errorThrown) {
                        console.log(xhr.responseText);
                    });
                    console.log($('#estadoAnimo').data("idanimo"));
                    console.log($('#inputPeso').val());
                    console.log($('#inputPulso').val());
                    console.log($('#inputPresion').val());
                    console.log($('#inputGlucosa').val());
                    console.log($('#inputOxigenacion').val());
                    console.log($('#inputTemperatura').val());
                } else {

                }
            });

    });


    $('[data-toggle="tooltip"]').tooltipster({
        theme: 'tooltipster-shadow',
        delay: '140'
    });

    cambiarEstadoAnimo('#animo_1','1');
    cambiarEstadoAnimo('#animo_2','2');
    cambiarEstadoAnimo('#animo_3','3');
    cambiarEstadoAnimo('#animo_4','4');
    cambiarEstadoAnimo('#animo_5','5');
    cambiarEstadoAnimo('#animo_6','6');

    function cambiarEstadoAnimo(myIdAnimo,valor){
        $(myIdAnimo).on('click', function () {
            $('#estadoAnimo').data("idanimo",valor);
            console.log($('#estadoAnimo').data("idanimo"));
        });
    }

    $('#eliminarCuentaPaciente').on('click', () => {

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

    //AGREGAR Y QUITAR TRATAMIENTOS
    $('#add-Tratamiento').on('click', function(){

        var plantilla = `<div class="form-group row justify-content-center contenedor-tratamientos">
        <div class="col-7">
            <select id="tratamiento" class="form-control">
                <option disabled selected>Elegir Tratamiento</option>
                <option value="">Quimioterapia antes de la cirugía</option>
                <option value="">Quimioterapia después de la cirugía</option>
                <option value="">Radioterapia antes de la cirugía</option>
                <option value="">Radioterapia después de la cirugía</option>
                <option value="">Hormonoterapia antes de la cirugía</option>
                <option value="">Hormonoterapia después de la cirugía</option>
                <option value="">Mastectomía</option>
                <option value="">Cirugía conservadora</option>
                <option value="">Reconstrucción</option>
                <option value="">Paliativo</option>
                <option value="">Ya terminé tratamiento</option>
            </select>
        </div>
            <div class="col-1">
                <button type="button" id="remove-Tratamiento" class="btn btn-outline-danger" style="border-radius: 25px;">
                <i class="fas fa-times"></i>
            </div>

    </div>`;

        $('#tratamientos').append(plantilla);

    });

    $('body').on('click', '#remove-Tratamiento', function(){

        $(this).parent().parent().remove();

    });

});
