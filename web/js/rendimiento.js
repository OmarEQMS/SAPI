/* 
 * author: Julio
 */

$(document).ready(function () {

    //Enviar la fecha actual
    var now = new Date();
    //alert(formatDate(now));

    //1.- Total de visitas por mes
    $.ajax({

        url: "ReporteController",
        method: "POST",
        cache: false,
        data: {
            key: "mostrarVisitaMes",
            fecha: formatDate(now)
        },
        success: function (response) {

            var data = JSON.parse(response);

            console.log(data);

            var plantilla = `<tr>
                    <td>${data.decripcion}</td>
                    <td>${data.cantidad}</td>
                  </tr>`;

            $('#totalVisitasMes tbody').append(plantilla);

            $('#totalVisitasMes').DataTable({
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
                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
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

    //2.- Cantidad de visitas por edades
    $.ajax({

        url: "ReporteController",
        method: "POST",
        cache: false,
        data: {
            key: "mostrarVisitaEdad",
            fecha: formatDate(now)
        },
        success: function (response) {

            var data = JSON.parse(response);

            for (var i = 0; i < data.length; i++) {

                var plantilla = `<tr>
                    <td>${data[i].decripcion}</td>
                    <td>${data[i].cantidad}</td>
                  </tr>`;

                $('#cantidadVisitasEdades tbody').append(plantilla);
            }

            $('#cantidadVisitasEdades').DataTable({
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
                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
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


    //3.- Cantidad de visitas por escolaridad
    $.ajax({

        url: "ReporteController",
        method: "POST",
        cache: false,
        data: {
            key: "mostrarVisitaEscolaridad",
            fecha: formatDate(now)
        },
        success: function (response) {

            var data = JSON.parse(response);

            for (var i = 0; i < data.length; i++) {

                var plantilla = `<tr>
                    <td>${data[i].decripcion}</td>
                    <td>${data[i].cantidad}</td>
                  </tr>`;

                $('#cantidadVisitasEscolaridad tbody').append(plantilla);
            }

            $('#cantidadVisitasEscolaridad').DataTable({
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
                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
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

    //4.- Cantidad de visitas por lugar de residencia
    $.ajax({

        url: "ReporteController",
        method: "POST",
        cache: false,
        data: {
            key: "mostrarVisitaLugarResidencia",
            fecha: formatDate(now)
        },
        success: function (response) {

            var data = JSON.parse(response);

            for (var i = 0; i < data.length; i++) {

                var plantilla = `<tr>
                    <td>${data[i].decripcion}</td>
                    <td>${data[i].cantidad}</td>
                  </tr>`;

                $('#cantidadVisitasLugar tbody').append(plantilla);

            }

            $('#cantidadVisitasLugar').DataTable({
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
                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
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

    //5.- Cantidad de visitas por nivelsocioeconomico
    $.ajax({

        url: "ReporteController",
        method: "POST",
        cache: false,
        data: {
            key: "mostrarVisitaNivelSocioEconomico",
            fecha: formatDate(now)
        },
        success: function (response) {

            var data = JSON.parse(response);

            for (var i = 0; i < data.length; i++) {

                var plantilla = `<tr>
                    <td>${data[i].decripcion}</td>
                    <td>${data[i].cantidad}</td>
                  </tr>`;

                $('#cantidadVisitasNivel tbody').append(plantilla);
            }

            $('#cantidadVisitasNivel').DataTable({
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
                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
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

    //6.- Cantidad de visitas por decision de preconsulta
    $.ajax({

        url: "ReporteController",
        method: "POST",
        cache: false,
        data: {
            key: "mostrarVisitaDecisionPreconsulta",
            fecha: formatDate(now)
        },
        success: function (response) {

            var data = JSON.parse(response);

            for (var i = 0; i < data.length; i++) {

                var plantilla = `<tr>
                    <td>${data[i].decripcion}</td>
                    <td>${data[i].cantidad}</td>
                  </tr>`;

                $('#cantidadVisitasDecision tbody').append(plantilla);
            }

            $('#cantidadVisitasDecision').DataTable({
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
                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
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

    //7.- Cantidad de visitas por resultado patologia
    $.ajax({

        url: "ReporteController",
        method: "POST",
        cache: false,
        data: {
            key: "mostrarVisitaResultadoPatologia",
            fecha: formatDate(now)
        },
        success: function (response) {

            var data = JSON.parse(response);

            for (var i = 0; i < data.length; i++) {

                var plantilla = `<tr>
                    <td>${data[i].decripcion}</td>
                    <td>${data[i].cantidad}</td>
                  </tr>`;

                $('#cantidadVisitasResultado tbody').append(plantilla);
            }

            $('#cantidadVisitasResultado').DataTable({
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
                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
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

    $('.btnExcel').prepend("<i class='fas fa-file-excel mr-1'></i>");
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

});


