$(document).ready(function () {

    //Esconder menu lateral a presionar click en el menu hamburguesa
    $('#sidebarCollapse').on('click', () => {
        $('#sidebar, #content').toggleClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
        
       
    });
    
    ///////////////////////////////ADMINISTRADORES
    
    //TABLA MEDICOS
    $('#tablaAdministradores').DataTable({
        responsive: true,
        dom: 'lBfrtip',
        buttons: [

            {
                extend: 'excel',
                text: 'Exportar a Excel',
                className: 'btn-outline-success mr-2 btnExcel'
            },
            {
                extend: 'pdf',
                text: 'Exportar a pdf',
                className: 'btn-outline-info btnPdf'
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

    ///////////////////////////////MEDICOS


    //TABLA MEDICOS
    $('#tablaMedicos').DataTable({
        responsive: true,
        dom: 'lBfrtip',
        buttons: [

            {
                extend: 'excel',
                text: 'Exportar a Excel',
                className: 'btn-outline-success mr-2 btnExcel'
            },
            {
                extend: 'pdf',
                text: 'Exportar a pdf',
                className: 'btn-outline-info btnPdf'
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


    ///////////////////////////////NAVEGADORAS


    //TABLA NAVEGADORAS
    $('#tablaNavegadoras').DataTable({
        responsive: true,
        dom: 'lBfrtip',
        buttons: [

            {
                extend: 'excel',
                text: 'Exportar a Excel',
                className: 'btn-outline-success mr-2 btnExcel'
            },
            {
                extend: 'pdf',
                text: 'Exportar a pdf',
                className: 'btn-outline-info btnPdf'
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

    ///////////////////////////////PACIENTES

    $('#tablaPacientes').DataTable({
        responsive: true,
        dom: 'lBfrtip',
        buttons: [

            {
                extend: 'excel',
                text: 'Exportar a Excel',
                className: 'btn-outline-success mr-2 btnExcel mt-3'
            },
            {
                extend: 'pdf',
                text: 'Exportar a pdf',
                className: 'btn-outline-info btnPdf mt-3'
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

    //Pone iconos en los botones de exportar
    $('.btnExcel').prepend("<i class='fas fa-file-excel mr-2'></i>");
    $('.btnPdf').prepend("<i class='far fa-file-pdf mr-2'></i>");

    //Limpiar campos

    $("body").on("click", ".clearAddMedicosModal", function () {
        $("#agregar-nombreMedico").val("");
        $("#agregar-telefonoMedico").val("");
        $("#agregar-primerApellidoMedico").val("");
        $("#agregar-segundoApellidoMedico").val("");
        $("#agregar-correoMedico").val("");
        $("#agregar-noEmpleadoMedico").val("");
        $("#agregar-especialidadMedico").val("");
        $("#agregar-posiciondMedico").val("");
        $("#agregar-cedulaMedico").val("");
        $("#agregar-passwordMedico").val("");
        $("#agregar-password2Medico").val("");

        $('#errorNombreMedico').hide();
        $('#errorTelefonoMedico').hide();
        $('#errorApellidoPaternoMedico').hide();
        $('#errorApellidoMaternoMedico').hide();
        $('#errorCorreoMedico').hide();
        $('#errorCorreoRepetido').hide();
        $('#errorNumEmpleado').hide();
        $('#errorCedulaMedicos').hide();
        $('#errorPass1Medico').hide();
        $('#noEqualPasswordsError').hide();
        $('#error-campos').hide();
        $('#error-datosRepetidos').hide();
        $('#errorTerminos').hide();

        $('#agregar-nombreMedico').css('border', '');
        $('#agregar-nombreMedico').css('color', '');

        $('#agregar-telefonoMedico').css('border', '');
        $('#agregar-telefonoMedico').css('color', '');

        $('#agregar-primerApellidoMedico').css('border', '');
        $('#agregar-primerApellidoMedico').css('color', '');

        $('#agregar-segundoApellidoMedico').css('border', '');
        $('#agregar-segundoApellidoMedico').css('color', '');

        $('#agregar-correoMedico').css('border', '');
        $('#agregar-correoMedico').css('color', '');

        $('#agregar-noEmpleadoMedico').css('border', '');
        $('#agregar-noEmpleadoMedico').css('color', '');

        $('#agregar-cedulaMedico').css('border', '');
        $('#agregar-cedulaMedico').css('color', '');

        $('#agregar-passwordMedico').css('border', '');
        $('#agregar-passwordMedico').css('color', '');

        $('#agregar-password2Medico').css('border', '');
        $('#agregar-password2Medico').css('color', '');

    });

    $("body").on("click", ".clearCancelEditMedicosModal", function () {

        $('#errorEditarNombreMedico').hide();
        $('#errorEditarTelefonoMedico').hide();
        $('#errorEditarApellidoPaternoMedico').hide();
        $('#errorEditarApellidoMaternoMedico').hide();
        $('#errorEditarCorreoMedico').hide();
        $('#errorEditarCorreoRepetido').hide();
        $('#errorEditarNumEmpleado').hide();
        $('#errorEditarCedulaMedicos').hide();
        $('#error-editarDatosRepetidos').hide();

        $('#editar-nombreMedico').css('border', '');
        $('#editar-nombreMedico').css('color', '');

        $('#editar-primerApellidoMedico').css('border', '');
        $('#editar-primerApellidoMedico').css('color', '');

        $('#editar-segundoApellidoMedico').css('border', '');
        $('#editar-segundoApellidoMedico').css('color', '');

        $('#editar-correoMedico').css('border', '');
        $('#editar-correoMedico').css('color', '');

        $('#agregar-correoMedico').css('border', '');
        $('#agregar-correoMedico').css('color', '');

        $('#editar-telefonoMedico').css('border', '');
        $('#editar-telefonoMedico').css('color', '');

        $('#editar-noEmpleadoMedico').css('border', '');
        $('#editar-noEmpleadoMedico').css('color', '');

        $('#editar-cedulaProfesionalMedico').css('border', '');
        $('#editar-cedulaProfesionalMedico').css('color', '');

    });

    $("body").on("click", ".clearAddNavegadoraModal", function () {
        $("#agregar-nombreNavegadora").val("");
        $("#agregar-telefonoNavegadora").val("");
        $("#agregar-primerApellidoNavegadora").val("");
        $("#agregar-segundoApellidoNavegadora").val("");
        $("#agregar-correoNavegadora").val("");
        $("#agregar-noEmpleadoNavegadora").val("");
        $("#agregar-especialidadNavegadora").val("");
        $("#agregar-cedulaNavegadora").val("");
        $("#agregar-passwordNavegadora").val("");
        $("#agregar-password2Navegadora").val("");

    });


});