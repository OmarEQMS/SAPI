/* 
 * author: Julio
 */

$(document).ready(function () {


    $('.errorFechasMes').hide();
    $('.errorFechasEdad').hide();
    $('.errorFechasEscolaridad').hide();
    $('.errorFechasResidencia').hide();
    $('.errorFechasEconomico').hide();
    $('.errorFechasPre').hide();
    $('.errorFechasPatologia').hide();

    //1.- CANTIDAD DE VISITAS TOTALES EN UN RANGO DE MES


    $('#fecha2Mes').on('change', function () {

        if ($('#fecha1Mes').val() !== '') {
            if (areValidDates($('#fecha1Mes').val(), $('#fecha2Mes').val())) {

                $('.errorFechasMes').hide();

                totalVisitasMes($('#fecha1Mes').val(), $('#fecha2Mes').val());

            } else {
                $('.errorFechasMes').show();
            }
        }

    });

    $('#fecha1Mes').on('change', function () {

        if ($('#fecha2Mes').val() !== '') {
            if (areValidDates($('#fecha1Mes').val(), $('#fecha2Mes').val())) {

                $('.errorFechasMes').hide();

                totalVisitasMes($('#fecha1Mes').val(), $('#fecha2Mes').val());

            } else {
                $('.errorFechasMes').show();
            }
        }

    });

    //Total de visitas por mes
    function totalVisitasMes(fecha1, fecha2) {
        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarVisitaMes",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".totalVisitasMes").dataTable().fnDestroy();

                $('.totalVisitasMes tbody').children().remove();

                var data = JSON.parse(response);

                var plantilla = `<tr>
                    <td>${data.decripcion}</td>
                    <td>${data.cantidad}</td>
                  </tr>`;

                $('.totalVisitasMes tbody').append(plantilla);

                $('.totalVisitasMes').DataTable({
                    responsive: true,
                    searching: true,

                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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



            }

        });
    }

    //2.- CANTIDAD DE VISITAS POR EDADES

    $('#fecha2Edad').on('change', function () {

        if ($('#fecha1Edad').val() != '') {
            if (areValidDates($('#fecha1Edad').val(), $('#fecha2Edad').val())) {

                $('.errorFechasEdad').hide();

                cantidadPorEdad($('#fecha1Edad').val(), $('#fecha2Edad').val());

            } else {
                $('.errorFechasEdad').show();
            }
        }

    });

    $('#fecha1Edad').on('change', function () {

        if ($('#fecha2Edad').val() != '') {
            if (areValidDates($('#fecha1Edad').val(), $('#fecha2Edad').val())) {

                $('.errorFechasEdad').hide();

                cantidadPorEdad($('#fecha1Edad').val(), $('#fecha2Edad').val());

            } else {
                $('.errorFechasEdad').show();
            }
        }

    });


    //2.- Cantidad de visitas por edades
    function cantidadPorEdad(fecha1, fecha2) {
        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarVisitaEdad",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".cantidadVisitasEdades").dataTable().fnDestroy();

                $('.cantidadVisitasEdades tbody').children().remove();

                var data = JSON.parse(response);

                for (var i = 0; i < data.length; i++) {

                    var plantilla = `<tr>
     <td>${data[i].decripcion}</td>
     <td>${data[i].cantidad}</td>
     </tr>`;

                    $('.cantidadVisitasEdades tbody').append(plantilla);
                }

                $('.cantidadVisitasEdades').DataTable({
                    responsive: true,
                    searching: true,
                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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



            }

        });
    }


    //3.- CANTIDAD DE VISITAS POR ESCOLARIDAD

    $('#fecha2Escolaridad').on('change', function () {

        if ($('#fecha1Escolaridad').val() != '') {
            if (areValidDates($('#fecha1Escolaridad').val(), $('#fecha2Escolaridad').val())) {

                $('.errorFechasEscolaridad').hide();

                cantidadPorEscolaridad($('#fecha1Escolaridad').val(), $('#fecha2Escolaridad').val());

            } else {
                $('.errorFechasEscolaridad').show();
            }
        }

    });

    $('#fecha1Escolaridad').on('change', function () {

        if ($('#fecha2Escolaridad').val() != '') {
            if (areValidDates($('#fecha1Escolaridad').val(), $('#fecha2Escolaridad').val())) {

                $('.errorFechasEscolaridad').hide();

                cantidadPorEscolaridad($('#fecha1Escolaridad').val(), $('#fecha2Escolaridad').val());

            } else {
                $('.errorFechasEscolaridad').show();
            }
        }

    });

    function cantidadPorEscolaridad(fecha1, fecha2) {
        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarVisitaEscolaridad",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".cantidadVisitasEscolaridad").dataTable().fnDestroy();

                $('.cantidadVisitasEscolaridad tbody').children().remove();

                var data = JSON.parse(response);

                for (var i = 0; i < data.length; i++) {

                    var plantilla = `<tr>
     <td>${data[i].decripcion}</td>
     <td>${data[i].cantidad}</td>
     </tr>`;

                    $('.cantidadVisitasEscolaridad tbody').append(plantilla);
                }

                $('.cantidadVisitasEscolaridad').DataTable({
                    responsive: true,
                    searching: true,
                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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



            }

        });
    }



    //4.- CANTIDAD DE VISITAS POR RESIDENCIA

    $('#fecha2Residencia').on('change', function () {

        if ($('#fecha1Residencia').val() != '') {
            if (areValidDates($('#fecha1Residencia').val(), $('#fecha2Residencia').val())) {

                $('.errorFechasResidencia').hide();

                cantidadPorResidencia($('#fecha1Residencia').val(), $('#fecha2Residencia').val());

            } else {
                $('.errorFechasResidencia').show();
            }
        }

    });

    $('#fecha1Residencia').on('change', function () {

        if ($('#fecha2Residencia').val() != '') {
            if (areValidDates($('#fecha1Residencia').val(), $('#fecha2Residencia').val())) {

                $('.errorFechasResidencia').hide();

                cantidadPorResidencia($('#fecha1Residencia').val(), $('#fecha2Residencia').val());

            } else {
                $('.errorFechasResidencia').show();
            }
        }

    });


    function cantidadPorResidencia(fecha1, fecha2) {

        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarVisitaLugarResidencia",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".cantidadVisitasResidencia").dataTable().fnDestroy();

                $('.cantidadVisitasResidencia tbody').children().remove();

                var data = JSON.parse(response);

                for (var i = 0; i < data.length; i++) {

                    var plantilla = `<tr>
     <td>${data[i].decripcion}</td>
     <td>${data[i].cantidad}</td>
     </tr>`;

                    $('.cantidadVisitasResidencia tbody').append(plantilla);

                }

                $('.cantidadVisitasResidencia').DataTable({
                    responsive: true,
                    searching: true,
                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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



            }

        });

    }





    //5.- CANTIDAD DE VISITAS POR NIVEL SOCIECONOMICO

    $('#fecha2Economico').on('change', function () {

        if ($('#fecha1Economico').val() != '') {
            if (areValidDates($('#fecha1Economico').val(), $('#fecha2Economico').val())) {

                $('.errorFechasEconomico').hide();

                cantidadPorEconomico($('#fecha1Economico').val(), $('#fecha2Economico').val());

            } else {
                $('.errorFechasEconomico').show();
            }
        }

    });

    $('#fecha1Economico').on('change', function () {

        if ($('#fecha2Economico').val() != '') {
            if (areValidDates($('#fecha1Economico').val(), $('#fecha2Economico').val())) {

                $('.errorFechasEconomico').hide();

                cantidadPorEconomico($('#fecha1Economico').val(), $('#fecha2Economico').val());

            } else {
                $('.errorFechasEconomico').show();
            }
        }

    });

    function cantidadPorEconomico(fecha1, fecha2) {

        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarVisitaNivelSocioEconomico",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".cantidadVisitasNivel").dataTable().fnDestroy();

                $('.cantidadVisitasNivel tbody').children().remove();

                var data = JSON.parse(response);

                for (var i = 0; i < data.length; i++) {

                    var plantilla = `<tr>
     <td>${data[i].decripcion}</td>
     <td>${data[i].cantidad}</td>
     </tr>`;

                    $('.cantidadVisitasNivel tbody').append(plantilla);
                }

                $('.cantidadVisitasNivel').DataTable({
                    responsive: true,
                    searching: true,
                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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



            }

        });

    }



    //6.- CCANTIDAD DE VISITAS POR DECISION PRE CONSULTA

    $('#fecha2Pre').on('change', function () {

        if ($('#fecha1Pre').val() !== '') {
            if (areValidDates($('#fecha1Pre').val(), $('#fecha2Pre').val())) {

                $('.errorFechasPre').hide();

                cantidadPorDecisionPreconsulta($('#fecha1Pre').val(), $('#fecha2Pre').val());

            } else {
                $('.errorFechasPre').show();
            }
        }

    });

    $('#fecha1Pre').on('change', function () {

        if ($('#fecha2Pre').val() !== '') {
            if (areValidDates($('#fecha1Pre').val(), $('#fecha2Pre').val())) {

                $('.errorFechasPre').hide();

                cantidadPorDecisionPreconsulta($('#fecha1Pre').val(), $('#fecha2Pre').val());

            } else {
                $('.errorFechasPre').show();
            }
        }

    });

    function cantidadPorDecisionPreconsulta(fecha1, fecha2) {

        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarVisitaDecisionPreconsulta",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".cantidadVisitasPre").dataTable().fnDestroy();

                $('.cantidadVisitasPre tbody').children().remove();

                var data = JSON.parse(response);

                for (var i = 0; i < data.length; i++) {



                    var plantilla = `<tr>
     <td>${data[i].decripcion}</td>
     <td>${data[i].cantidad}</td>
     </tr>`;

                    $('.cantidadVisitasPre tbody').append(plantilla);
                }

                $('.cantidadVisitasPre').DataTable({
                    responsive: true,
                    searching: true,
                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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

            }

        });

    }



    //7.- Cantidad de visitas por resultado patologia

    $('#fecha2Patologia').on('change', function () {

        if ($('#fecha1Patologia').val() !== '') {
            if (areValidDates($('#fecha1Patologia').val(), $('#fecha2Patologia').val())) {

                $('.errorFechasPatologia').hide();

                cantidadPorPatologia($('#fecha1Patologia').val(), $('#fecha2Patologia').val());

            } else {
                $('.errorFechasPatologia').show();
            }
        }

    });

    $('#fecha1Patologia').on('change', function () {

        if ($('#fecha2Patologia').val() !== '') {
            if (areValidDates($('#fecha1Patologia').val(), $('#fecha2Patologia').val())) {

                $('.errorFechasPatologia').hide();

                cantidadPorPatologia($('#fecha1Patologia').val(), $('#fecha2Patologia').val());

            } else {
                $('.errorFechasPatologia').show();
            }
        }

    });

    function cantidadPorPatologia(fecha1, fecha2) {

        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarVisitaResultadoPatologia",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".cantidadVisitasPatologia").dataTable().fnDestroy();

                $('.cantidadVisitasPatologia tbody').children().remove();

                var data = JSON.parse(response);

                for (var i = 0; i < data.length; i++) {

                    var plantilla = `<tr>
     <td>${data[i].decripcion}</td>
     <td>${data[i].cantidad}</td>
     </tr>`;

                    $('.cantidadVisitasPatologia tbody').append(plantilla);
                }

                $('.cantidadVisitasPatologia').DataTable({
                    responsive: true,
                    searching: true,
                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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

            }

        });

    }
    
    

    /**
     *
     * @author Angel GTZ
     */

//1.- CANTIDAD DE VISITAS TOTALES EN UN RANGO DE MES


    $('#Rfecha2Mes').on('change', function () {

        if ($('#Rfecha1Mes').val() !== '') {
            if (areValidDates($('#Rfecha1Mes').val(), $('#Rfecha2Mes').val())) {

                $('.errorFechasMes').hide();

                estadisticaMes($('#Rfecha1Mes').val(), $('#Rfecha2Mes').val());

            } else {
                $('.errorFechasMes').show();
            }
        }

    });

    $('R#fecha1Mes').on('change', function () {

        if ($('#Rfecha2Mes').val() !== '') {
            if (areValidDates($('#Rfecha1Mes').val(), $('#Rfecha2Mes').val())) {

                $('.errorFechasMes').hide();

                estadisticaMes($('#Rfecha1Mes').val(), $('#Rfecha2Mes').val());

            } else {
                $('.errorFechasMes').show();
            }
        }

    });

    //Total de visitas por mes
    function estadisticaMes(fecha1, fecha2) {
        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarEstadisticaMes",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".estadisticaTotalVisitasMes").dataTable().fnDestroy();

                $('.estadisticaTotalVisitasMes tbody').children().remove();

                var data = JSON.parse(response);

                var plantilla = `<tr>
                    <td>${data.decripcion}</td>
                    <td>${data.cantidad}</td>
                  </tr>`;

                $('.estadisticaTotalVisitasMes tbody').append(plantilla);

                $('.estadisticaTotalVisitasMes').DataTable({
                    responsive: true,
                    searching: true,

                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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



            }

        });
    }

    //2.- CANTIDAD DE VISITAS POR EDADES

    $('#Rfecha2Edad').on('change', function () {

        if ($('#Rfecha1Edad').val() !== '') {
            if (areValidDates($('#Rfecha1Edad').val(), $('#Rfecha2Edad').val())) {

                $('.errorFechasEdad').hide();

                EstadisticaEdad($('#Rfecha1Edad').val(), $('#Rfecha2Edad').val());

            } else {
                $('.errorFechasEdad').show();
            }
        }

    });

    $('#Rfecha1Edad').on('change', function () {

        if ($('#Rfecha2Edad').val() !== '') {
            if (areValidDates($('#Rfecha1Edad').val(), $('#Rfecha2Edad').val())) {

                $('.errorFechasEdad').hide();

                EstadisticaEdad($('#Rfecha1Edad').val(), $('#Rfecha2Edad').val());

           } else {
                $('.errorFechasEdad').show();
            }
        }

    });


    //2.- Cantidad de visitas por edades
    function EstadisticaEdad(fecha1, fecha2) {
        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarEstadisticaEdad",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".EstadisticaEdad").dataTable().fnDestroy();

                $('.EstadisticaEdad tbody').children().remove();

                var data = JSON.parse(response);

                for (var i = 0; i < data.length; i++) {

                    var plantilla = `<tr>
     <td>${data[i].decripcion}</td>
     <td>${data[i].cantidad}</td>
     </tr>`;

                    $('.EstadisticaEdad tbody').append(plantilla);
                }

                $('.EstadisticaEdad').DataTable({
                    responsive: true,
                    searching: true,
                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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



            }

        });
    }


    //3.- CANTIDAD DE VISITAS POR ESCOLARIDAD

    $('#Rfecha2Escolaridad').on('change', function () {

        if ($('#Rfecha1Escolaridad').val() !== '') {
            if (areValidDates($('#Rfecha1Escolaridad').val(), $('#Rfecha2Escolaridad').val())) {

                $('.errorFechasEscolaridad').hide();

                EstadisticaEscolaridad($('#Rfecha1Escolaridad').val(), $('#Rfecha2Escolaridad').val());

            } else {
                $('.errorFechasEscolaridad').show();
            }
        }

    });

    $('#Rfecha1Escolaridad').on('change', function () {

        if ($('#Rfecha2Escolaridad').val() !== '') {
            if (areValidDates($('#Rfecha1Escolaridad').val(), $('#Rfecha2Escolaridad').val())) {

                $('.errorFechasEscolaridad').hide();

                EstadisticaEscolaridad($('#Rfecha1Escolaridad').val(), $('#Rfecha2Escolaridad').val());

            } else {
                $('.errorFechasEscolaridad').show();
            }
        }

    });

    function EstadisticaEscolaridad(fecha1, fecha2) {
        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarEstadisticaEscolaridad",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".cantidadEstadisticaEscolaridad").dataTable().fnDestroy();

                $('.cantidadEstadisticaEscolaridad tbody').children().remove();

                var data = JSON.parse(response);

                for (var i = 0; i < data.length; i++) {

                    var plantilla = `<tr>
     <td>${data[i].decripcion}</td>
     <td>${data[i].cantidad}</td>
     </tr>`;

                    $('.cantidadEstadisticaEscolaridad tbody').append(plantilla);
                }

                $('.cantidadEstadisticaEscolaridad').DataTable({
                    responsive: true,
                    searching: true,
                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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



            }

        });
    }



    //4.- CANTIDAD DE VISITAS POR RESIDENCIA

    $('#Rfecha2Residencia').on('change', function () {

        if ($('#Rfecha1Residencia').val() !== '') {
            if (areValidDates($('#Rfecha1Residencia').val(), $('#Rfecha2Residencia').val())) {

                $('.errorFechasResidencia').hide();

                EstadisticaResidencia($('#Rfecha1Residencia').val(), $('#Rfecha2Residencia').val());

            } else {
                $('.errorFechasResidencia').show();
            }
        }

    });

    $('#Rfecha1Residencia').on('change', function () {

        if ($('#Rfecha2Residencia').val() !== '') {
            if (areValidDates($('#Rfecha1Residencia').val(), $('#Rfecha2Residencia').val())) {

                $('.errorFechasResidencia').hide();

                EstadisticaResidencia($('#Rfecha1Residencia').val(), $('#Rfecha2Residencia').val());

            } else {
                $('.errorFechasResidencia').show();
            }
        }

    });


    function EstadisticaResidencia(fecha1, fecha2) {

        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarEstadisticaLugarResidencia",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".cantidadEstadisticaResidencia").dataTable().fnDestroy();

                $('.cantidadEstadisticaResidencia tbody').children().remove();

                var data = JSON.parse(response);

                for (var i = 0; i < data.length; i++) {

                    var plantilla = `<tr>
     <td>${data[i].decripcion}</td>
     <td>${data[i].cantidad}</td>
     </tr>`;

                    $('.cantidadEstadisticaResidencia tbody').append(plantilla);

                }

                $('.cantidadEstadisticaResidencia').DataTable({
                    responsive: true,
                    searching: true,
                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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



            }

        });

    }





    //5.- CANTIDAD DE VISITAS POR NIVEL SOCIECONOMICO

    $('#Rfecha2Economico').on('change', function () {

        if ($('#Rfecha1Economico').val() !== '') {
            if (areValidDates($('#Rfecha1Economico').val(), $('#Rfecha2Economico').val())) {

                $('.errorFechasEconomico').hide();

                EstadisticaEconomico($('#Rfecha1Economico').val(), $('#Rfecha2Economico').val());

            } else {
                $('.errorFechasEconomico').show();
            }
        }

    });

    $('#Rfecha1Economico').on('change', function () {

        if ($('#fecha2Economico').val() !== '') {
            if (areValidDates($('#fecha1Economico').val(), $('#fecha2Economico').val())) {

                $('.errorFechasEconomico').hide();

                EstadisticaEconomico($('#Rfecha1Economico').val(), $('#Rfecha2Economico').val());

            } else {
                $('.errorFechasEconomico').show();
            }
        }

    });

    function EstadisticaEconomico(fecha1, fecha2) {

        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarEstadisticaNivelSocioEconomico",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".cantidadEstadisticaNivel").dataTable().fnDestroy();

                $('.cantidadEstadisticaNivel tbody').children().remove();

                var data = JSON.parse(response);

                for (var i = 0; i < data.length; i++) {

                    var plantilla = `<tr>
     <td>${data[i].decripcion}</td>
     <td>${data[i].cantidad}</td>
     </tr>`;

                    $('.cantidadEstadisticaNivel tbody').append(plantilla);
                }

                $('.cantidadEstadisticaNivel').DataTable({
                    responsive: true,
                    searching: true,
                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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



            }

        });

    }



    //6.- CCANTIDAD DE VISITAS POR DECISION PRE CONSULTA

    $('#Rfecha2Pre').on('change', function () {

        if ($('#fecha1Pre').val() !== '') {
            if (areValidDates($('#Rfecha1Pre').val(), $('#Rfecha2Pre').val())) {

                $('.errorFechasPre').hide();

                EstadisticaDecisionPreconsulta($('#Rfecha1Pre').val(), $('#Rfecha2Pre').val());

            } else {
                $('.errorFechasPre').show();
            }
        }

    });

    $('#Rfecha1Pre').on('change', function () {

        if ($('#Rfecha2Pre').val() !== '') {
            if (areValidDates($('#Rfecha1Pre').val(), $('#Rfecha2Pre').val())) {

                $('.errorFechasPre').hide();

                EstadisticaDecisionPreconsulta($('#Rfecha1Pre').val(), $('#Rfecha2Pre').val());

            } else {
                $('.errorFechasPre').show();
            }
        }

    });

    function EstadisticaDecisionPreconsulta(fecha1, fecha2) {

        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarEstadisticaDecisionPreconsulta",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".cantidadEstadisticaPre").dataTable().fnDestroy();

                $('.cantidadEstadisticaPre tbody').children().remove();

                var data = JSON.parse(response);

                for (var i = 0; i < data.length; i++) {



                    var plantilla = `<tr>
     <td>${data[i].decripcion}</td>
     <td>${data[i].cantidad}</td>
     </tr>`;

                    $('.cantidadEstadisticaPre tbody').append(plantilla);
                }

                $('.cantidadEstadisticaPre').DataTable({
                    responsive: true,
                    searching: true,
                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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

            }

        });

    }



    //7.- Cantidad de visitas por resultado patologia

    $('#Rfecha2Patologia').on('change', function () {

        if ($('#Rfecha1Patologia').val() !== '') {
            if (areValidDates($('#Rfecha1Patologia').val(), $('#Rfecha2Patologia').val())) {

                $('.errorFechasPatologia').hide();

                EstadisticaPatologia($('#Rfecha1Patologia').val(), $('#Rfecha2Patologia').val());

            } else {
                $('.errorFechasPatologia').show();
            }
        }

    });

    $('#Rfecha1Patologia').on('change', function () {

        if ($('#Rfecha2Patologia').val() !== '') {
            if (areValidDates($('#Rfecha1Patologia').val(), $('#Rfecha2Patologia').val())) {

                $('.errorFechasPatologia').hide();

                EstadisticaPatologia($('#Rfecha1Patologia').val(), $('#Rfecha2Patologia').val());

            } else {
                $('.errorFechasPatologia').show();
            }
        }

    });

    function EstadisticaPatologia(fecha1, fecha2) {

        $.ajax({

            url: "ReporteController",
            method: "POST",
            cache: false,
            data: {
                key: "mostrarEstadisticaResultadoPatologia",
                fecha1: fecha1,
                fecha2: fecha2
            },
            success: function (response) {

                $(".cantidadEstadisticaPatologia").dataTable().fnDestroy();

                $('.cantidadEstadisticaPatologia tbody').children().remove();

                var data = JSON.parse(response);

                for (var i = 0; i < data.length; i++) {

                    var plantilla = `<tr>
     <td>${data[i].decripcion}</td>
     <td>${data[i].cantidad}</td>
     </tr>`;

                    $('.cantidadEstadisticaPatologia tbody').append(plantilla);
                }

                $('.cantidadEstadisticaPatologia').DataTable({
                    responsive: true,
                    searching: true,
                    dom: 'lBfrtip',
                    buttons: [

                        {
                            extend: 'excel',
                            text: 'Exportar a Excel',
                            className: 'btn-outline-success mr-3 btnExcel mt-3'
                        },
                        {
                            extend: 'pdf',
                            text: 'Exportar a pdf',
                            className: 'btn-outline-info mr-3 btnPDF mt-3 '
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

            }

        });

    }



    $('.btnExcel').prepend("<i class='fas fa-file-excel mr-1'></i > ");
    $('.btnPDF').prepend("<i class='far fa-file-pdf mr-1'></i>");



    function formatDate(date) {
        var d = new Date(date),
                month = '' + (d.getMonth() + 1),
                day = '' + d.getDate(),
                year = d.getFullYear();

        if (month.length < 2)
            month = '0' + month;
        if (day.length < 2)
            day = '0' + day;

        return [year, month, day].join('-');
    }

    function areValidDates(fecha1, fecha2) {

        var fecha1Final = new Date(fecha1);
        var fecha2Final = new Date(fecha2);

        if (fecha1 > fecha2) {
            return false;
        }


        return true;

    }

});


