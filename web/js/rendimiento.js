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

        if ($('#fecha1Mes').val() != '') {
            if (areValidDates($('#fecha1Mes').val(), $('#fecha2Mes').val())) {
                
                $('.errorFechasMes').hide();

                totalVisitasMes($('#fecha1Mes').val(), $('#fecha2Mes').val());

                console.log($('#fecha1Mes').val());
                console.log($('#fecha2Mes').val());

            } else {
                $('.errorFechasMes').show();
            }
        }

    });

    $('#fecha1Mes').on('change', function () {

        if ($('#fecha2Mes').val() != '') {
            if (areValidDates($('#fecha1Mes').val(), $('#fecha2Mes').val())) {

                $('.errorFechasMes').hide();

                totalVisitasMes($('#fecha1Mes').val(), $('#fecha2Mes').val());

                console.log($('#fecha1Mes').val());
                console.log($('#fecha2Mes').val());

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

                console.log(data);

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

                console.log($('#fecha1Edad').val());
                console.log($('#fecha2Edad').val());

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

                console.log($('#fecha1Edad').val());
                console.log($('#fecha2Edad').val());

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



                console.log(data);

            }

        });
    }


    //3.- CANTIDAD DE VISITAS POR ESCOLARIDAD

    $('#fecha2Escolaridad').on('change', function () {

        if ($('#fecha1Escolaridad').val() != '') {
            if (areValidDates($('#fecha1Escolaridad').val(), $('#fecha2Escolaridad').val())) {
                
                $('.errorFechasEscolaridad').hide();

                cantidadPorEscolaridad($('#fecha1Escolaridad').val(), $('#fecha2Escolaridad').val());

                console.log($('#fecha1Escolaridad').val());
                console.log($('#fecha2Escolaridad').val());

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

                console.log($('#fecha1Escolaridad').val());
                console.log($('#fecha2Escolaridad').val());

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



                console.log(data);

            }

        });
    }



    //4.- CANTIDAD DE VISITAS POR RESIDENCIA

    $('#fecha2Residencia').on('change', function () {

        if ($('#fecha1Residencia').val() != '') {
            if (areValidDates($('#fecha1Residencia').val(), $('#fecha2Residencia').val())) {
                
                $('.errorFechasResidencia').hide();

                cantidadPorResidencia($('#fecha1Residencia').val(), $('#fecha2Residencia').val());

                console.log($('#fecha1Residencia').val());
                console.log($('#fecha2Residencia').val());

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

                console.log($('#fecha1Residencia').val());
                console.log($('#fecha2Residencia').val());

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



                console.log(data);

            }

        });

    }





    //5.- CANTIDAD DE VISITAS POR NIVEL SOCIECONOMICO

    $('#fecha2Economico').on('change', function () {

        if ($('#fecha1Economico').val() != '') {
            if (areValidDates($('#fecha1Economico').val(), $('#fecha2Economico').val())) {
                
                $('.errorFechasEconomico').hide();

                cantidadPorEconomico($('#fecha1Economico').val(), $('#fecha2Economico').val());

                console.log($('#fecha1Economico').val());
                console.log($('#fecha2Economico').val());

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

                console.log($('#fecha1Economico').val());
                console.log($('#fecha2Economico').val());

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



                console.log(data);

            }

        });

    }



    //6.- CCANTIDAD DE VISITAS POR DECISION PRE CONSULTA

    $('#fecha2Pre').on('change', function () {

        if ($('#fecha1Pre').val() != '') {
            if (areValidDates($('#fecha1Pre').val(), $('#fecha2Pre').val())) {
                
                $('.errorFechasPre').hide();

                cantidadPorDecisionPreconsulta($('#fecha1Pre').val(), $('#fecha2Pre').val());

                console.log($('#fecha1Pre').val());
                console.log($('#fecha2Pre').val());

            } else {
                $('.errorFechasPre').show();
            }
        }

    });

    $('#fecha1Pre').on('change', function () {

        if ($('#fecha2Pre').val() != '') {
            if (areValidDates($('#fecha1Pre').val(), $('#fecha2Pre').val())) {

                $('.errorFechasPre').hide();

                cantidadPorDecisionPreconsulta($('#fecha1Pre').val(), $('#fecha2Pre').val());

                console.log($('#fecha1Pre').val());
                console.log($('#fecha2Pre').val());

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

                console.log(data);

            }

        });

    }



    //7.- Cantidad de visitas por resultado patologia

    $('#fecha2Patologia').on('change', function () {

        if ($('#fecha1Patologia').val() != '') {
            if (areValidDates($('#fecha1Patologia').val(), $('#fecha2Patologia').val())) {
                
                $('.errorFechasPatologia').hide();

                cantidadPorPatologia($('#fecha1Patologia').val(), $('#fecha2Patologia').val());

                console.log($('#fecha1Patologia').val());
                console.log($('#fecha2Patologia').val());

            } else {
                $('.errorFechasPatologia').show();
            }
        }

    });

    $('#fecha1Patologia').on('change', function () {

        if ($('#fecha2Patologia').val() != '') {
            if (areValidDates($('#fecha1Patologia').val(), $('#fecha2Patologia').val())) {

                $('.errorFechasPatologia').hide();

                cantidadPorPatologia($('#fecha1Patologia').val(), $('#fecha2Patologia').val());

                console.log($('#fecha1Patologia').val());
                console.log($('#fecha2Patologia').val());

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

                console.log(data);

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
            console.log('NO SEAS MAMON NO PUEDES');
            return false;
        }

        console.log(fecha1Final);
        console.log(fecha2Final);

        return true;

    }

});


