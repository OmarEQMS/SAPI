$(document).ready(function () {

    
    mostrarContrasena($('#medicoContrasena'),'agregar-passwordMedico');
    mostrarContrasena($('#medicoContrasenaConfirmacion'),'agregar-password2Medico');
    mostrarContrasena($('#navegadoraContrasena'),'agregar-passwordNavegadora');
    mostrarContrasena($('#navegadoraContrasenaConfirmacion'),'agregar-password2Navegadora');
    mostrarContrasena($('#cambio1Contrasena'),'password');
    mostrarContrasena($('#cambio2Contrasena'),'password2');
    mostrarContrasena($('#adminContrasena'),'agregar-passwordAdministrador');
    mostrarContrasena($('#adminConfirmContrasena'),'agregar-password2Administradores');
    mostrarContrasena($('#pacienteContrasena'),'contraPaciente');
    mostrarContrasena($('#pacienteContrasenaConfirmacion'),'confContraPaciente');


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
    $("body").on("click", ".clearAddPacientesModal", function () {

        $('#nombrePaciente').val("");
        $('#nombrePaciente').css('border', '');
        $('#nombrePaciente').css('color', '');

        $('#curpPaciente').val("");
        $('#curpPaciente').css('border', '');
        $('#curpPaciente').css('color', '');

        $("#cumplePaciente").attr("type", "text").val('').attr("placeholder", "Fecha de nacimiento");
        $('#cumplePaciente').css('border', '');
        $('#cumplePaciente').css('color', '');

        $('#primer-apellidoPaciente').val("");
        $('#primer-apellidoPaciente').css('border', '');
        $('#primer-apellidoPaciente').css('color', '');

        $('#segundo-apellidoPaciente').val("");
        $('#segundo-apellidoPaciente').css('border', '');
        $('#segundo-apellidoPaciente').css('color', '');

        $('#usuarioPaciente').val("");
        $('#usuarioPaciente').css('border', '');
        $('#usuarioPaciente').css('color', '');

        $("#estado-civilPaciente").prop('selectedIndex', 0);
        $('#estado-civilPaciente').css('border', '');
        $('#estado-civilPaciente').css('color', '');

        $('#colPaciente').val("");
        $('#colPaciente').css('border', '');
        $('#colPaciente').css('color', '');

        $('#callePaciente').val("");
        $('#callePaciente').css('border', '');
        $('#callePaciente').css('color', '');

        $('#numIntPaciente').val("");
        $('#numIntPaciente').css('border', '');
        $('#numIntPaciente').css('color', '');

        $('#numExtPaciente').val("");
        $('#numExtPaciente').css('border', '');
        $('#numExtPaciente').css('color', '');

        $('#estadoPaciente').prop('selectedIndex', 0);
        $('#estadoPaciente').css('border', '');
        $('#estadoPaciente').css('color', '');

        $('#municipioPaciente').append("<option disabled selected>" + "Seleccione un Municipio" + "</option>");
        $('#municipioPaciente').css('border', '');
        $('#municipioPaciente').css('color', '');
        
        $("#acepto-terminos").prop("checked", false);
        
        
        $('#telPaciente').val("");
        $('#telPaciente').css('border', '');
        $('#telPaciente').css('color', '');

        $('#correoPaciente').val("");
        $('#correoPaciente').css('border', '');
        $('#correoPaciente').css('color', '');
        
        $('#contraPaciente').val("");
        $('#contraPaciente').css('border', '');
        $('#contraPaciente').css('color', '');
        
        $('#confContraPaciente').val("");
        $('#confContraPaciente').css('border', '');
        $('#confContraPaciente').css('color', '');


        $('#errorNombrePaciente').hide();
        $('#errorCurpPaciente').hide();
        $('#errorCurpRepetidoPaciente').hide();
        $('#errorFechaPaciente').hide();
        $('#errorApellidoPaternoPaciente').hide();
        $('#errorApellidoMaternoPaciente').hide();
        $('#errorNombreUsuarioPaciente').hide();
        $('#errorUsuarioRepetidoPaciente').hide();
        $('#errorECivilPaciente').hide();
        $('#errorColoniaPaciente').hide();
        $('#errorCallePaciente').hide();
        $('#errorNoInteriorPaciente').hide();
        $('#errorNoExteriorPaciente').hide();
        $('#errorEstadoPaciente').hide();
        $('#errorMunicipioPaciente').hide();
        $('#errorTelefonoPaciente').hide();
        $('#errorCorreoPaciente').hide();
        $('#errorPasscurpPacientePaciente').hide();
        $('#errorPasscumplePacientePaciente').hide();
        $('#error-CPexistePaciente').hide();
        $('#errorCodigoPostalPaciente').hide();
        $('#errorPass1Paciente').hide();
        $('#noEqualPasswordsErrorPaciente').hide();
        $('#errorCorreoRepetidoPaciente').hide();
        $('#error-terminos').hide();

    });

    $("body").on("click", ".clearEditPacientesModal", function () {

        $('#editarNombreAdministradorAPaciente').css('border', '');
        $('#editarNombreAdministradorAPaciente').css('color', '');

        $('#editarCurpAdministradorAPaciente').css('border', '');
        $('#editarCurpAdministradorAPaciente').css('color', '');

        $('#editarCumpleAdministradorAPaciente').css('border', '');
        $('#editarCumpleAdministradorAPaciente').css('color', '');

        $('#editarPrimer-apellidoAdministradorAPaciente').css('border', '');
        $('#editarPrimer-apellidoAdministradorAPaciente').css('color', '');

        $('#editarSegundo-apellidoAdministradorAPaciente').css('border', '');
        $('#editarSegundo-apellidoAdministradorAPaciente').css('color', '');

        $('#editarUsuarioAdministradorAPaciente').css('border', '');
        $('#editarUsuarioAdministradorAPaciente').css('color', '');

        $('#editarEstado-civilPaciente').css('border', '');
        $('#editarEstado-civilPaciente').css('color', '');

        $('#editarColAdministradorAPaciente').css('border', '');
        $('#editarColAdministradorAPaciente').css('color', '');

        $('#editarCalleAdministradorAPaciente').css('border', '');
        $('#editarCalleAdministradorAPaciente').css('color', '');

        $('#editarNumIntAdministradorAPaciente').css('border', '');
        $('#editarNumIntAdministradorAPaciente').css('color', '');

        $('#editarNumExtAdministradorAPaciente').css('border', '');
        $('#editarNumExtAdministradorAPaciente').css('color', '');

        $('#editarEstadoAdministradorAPaciente').css('border', '');
        $('#editarEstadoAdministradorAPaciente').css('color', '');

        $('#editarTelAdministradorAPaciente').css('border', '');
        $('#editarTelAdministradorAPaciente').css('color', '');

        $('#editarCorreoAdministradorAPaciente').css('border', '');
        $('#editarCorreoAdministradorAPaciente').css('color', '');


        $('#error-editar-NombrePaciente').hide();
        $('#error-editar-ApellidoPaternoPaciente').hide();
        $('#error-editar-ApellidoMaternoPaciente').hide();
        $('#error-editar-NombreUsuarioPaciente').hide();
        $('#error-editar-CorreoPaciente').hide();
        $('#error-editar-CurpPaciente').hide();
        $('#error-editar-ColoniaPaciente').hide();
        $('#error-editar-CallePaciente').hide();
        $('#error-editar-NoExteriorPaciente').hide();
        $('#error-editar-NoInteriorPaciente').hide();
        $('#error-editar-CurpRepetidoPaciente').hide();
        $('#error-editar-TelefonoPaciente').hide();
        $('#error-editar-ECivilPaciente').hide();
        $('#error-editar-FechaPaciente').hide();
        $('#error-editar-EstadoPaciente').hide();
        $('#error-editar-MunicipioPaciente').hide();
        $('#error-editar-UsuarioRepetidoPaciente').hide();
        $('#errorEditarPacienteCorreoRepetido').hide();
        $('#error-editarDatosRepetidosPaciente').hide();
        

    });

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
        $('#errorAgregarPosicion').hide();
        $('#errorAgregarEspecialidad').hide();

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

        $('#agregar-especialidadMedico').css('border', '');
        $('#agregar-especialidadMedico').css('color', '');

        $('#agregar-posiciondMedico').css('border', '');
        $('#agregar-posiciondMedico').css('color', '');

        $('#agregar-passwordMedico').css('border', '');
        $('#agregar-passwordMedico').css('color', '');

        $('#agregar-password2Medico').css('border', '');
        $('#agregar-password2Medico').css('color', '');

        $("#terminosMedico").prop("checked", false);

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
        $('#errorEditarPosicion').hide();
        $('#errorEditarEspecialidad').hide();

        $('#editar-nombreMedico').css('border', '');
        $('#editar-nombreMedico').css('color', '');

        $('#editar-primerApellidoMedico').css('border', '');
        $('#editar-primerApellidoMedico').css('color', '');

        $('#editar-segundoApellidoMedico').css('border', '');
        $('#editar-segundoApellidoMedico').css('color', '');

        $('#editar-correoMedico').css('border', '');
        $('#editar-correoMedico').css('color', '');

        $('#editar-correoMedico').css('border', '');
        $('#editar-correoMedico').css('color', '');

        $('#editar-telefonoMedico').css('border', '');
        $('#editar-telefonoMedico').css('color', '');

        $('#editar-noEmpleadoMedico').css('border', '');
        $('#editar-noEmpleadoMedico').css('color', '');

        $('#editar-cedulaProfesionalMedico').css('border', '');
        $('#editar-cedulaProfesionalMedico').css('color', '');

        $('#editar-especialidadMedico').css('border', '');
        $('#editar-especialidadMedico').css('color', '');

        $('#editar-posicionMedico').css('border', '');
        $('#editar-posicionMedico').css('color', '');

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
        $("#terminosNavegadora").prop("checked", false);

        $('#errorNombreNavegadora').hide();
        $('#errorTelefonoNavegadora').hide();
        $('#errorApellidoPaternoNavegadora').hide();
        $('#errorApellidoMaternoNavegadora').hide();
        $('#errorCorreoNavegadora').hide();
        $('#errorCorreoRepetidoNavegadora').hide();
        $('#errorNumEmpleadoNavegadora').hide();
        $('#errorAgregarEspecialidadNavegadora').hide();
        $('#errorCedulaNavegadora').hide();
        $('#errorPass1Navegadora').hide();
        $('#noEqualPasswordsError').hide();
        $('#error-camposNavegadora').hide();
        $('#error-datosRepetidosNavegadora').hide();

        $('#agregar-nombreNavegadora').css('border', '');
        $('#agregar-nombreNavegadora').css('color', '');

        $('#agregar-telefonoNavegadora').css('border', '');
        $('#agregar-telefonoNavegadora').css('color', '');

        $('#agregar-primerApellidoNavegadora').css('border', '');
        $('#agregar-primerApellidoNavegadora').css('color', '');

        $('#agregar-segundoApellidoNavegadora').css('border', '');
        $('#agregar-segundoApellidoNavegadora').css('color', '');

        $('#agregar-correoNavegadora').css('border', '');
        $('#agregar-correoNavegadora').css('color', '');

        $('#agregar-noEmpleadoNavegadora').css('border', '');
        $('#agregar-noEmpleadoNavegadora').css('color', '');

        $('#agregar-especialidadNavegadora').css('border', '');
        $('#agregar-especialidadNavegadora').css('color', '');

        $('#agregar-cedulaNavegadora').css('border', '');
        $('#agregar-cedulaNavegadora').css('color', '');

        $('#agregar-passwordNavegadora').css('border', '');
        $('#agregar-passwordNavegadora').css('color', '');

        $('#agregar-password2Navegadora').css('border', '');
        $('#agregar-password2Navegadora').css('color', '');

    });

    $("body").on("click", ".clearCancelEditNavegadoraModal", function () {

        $('#errorEditarNombreNavegadora').hide();
        $('#errorEditarTelefonoNavegadora').hide();
        $('#errorEditarApellidoPaternoNavegadora').hide();
        $('#errorEditarApellidoMaternoNavegadora').hide();
        $('#errorEditarCorreoNavegadora').hide();
        $('#errorEditarCorreoRepetidoNavegadora').hide();
        $('#errorEditarNumNavegadora').hide();
        $('#errorEditarCedulaNavegadora').hide();
        $('#errorEditarEspecialidadNavegadora').hide();
        $('#error-editarDatosRepetidosNavegadora').hide();


        $('#editar-nombreNavegadora').css('border', '');
        $('#editar-nombreNavegadora').css('color', '');

        $('#editar-primerApellidoNavegadora').css('border', '');
        $('#editar-primerApellidoNavegadora').css('color', '');

        $('#editar-segundoApellidoNavegadora').css('border', '');
        $('#editar-segundoApellidoNavegadora').css('color', '');

        $('#editar-correoNavegadora').css('border', '');
        $('#editar-correoNavegadora').css('color', '');

        $('#editar-telefonoNavegadora').css('border', '');
        $('#editar-telefonoNavegadora').css('color', '');

        $('#editar-noEmpleadoNavegadora').css('border', '');
        $('#editar-noEmpleadoNavegadora').css('color', '');

        $('#editar-cedulaProfesionalNavegadora').css('border', '');
        $('#editar-cedulaProfesionalNavegadora').css('color', '');

    });
    
    $("body").on("click", ".clearCancelEditAdminModal", function () {

        $('#errorEditarNombreAdministrador').hide();
        $('#errorEditarApellidoPaternoAdministrador').hide();
        $('#errorEditarApellidoMaternoAdministrador').hide();
        $('#errorEditarCorreoAdministrador').hide();
        $('#errorEditarCorreoRepetidoAdministrador').hide();
        $('#errorEditarTelefonoAdministrador').hide();
        $('#errorEditarNumEmpleadoAdministrador').hide();
        $('#errorEditarEspecialidadAdministrador').hide();
        $('#errorEditarPosicionAdministrador').hide();
        $('#errorEditarCedulaAdministrador').hide();
        $('#error-editarDatosRepetidosAdministrador').hide();


        $('#editar-nombreAdministrador').css('border', '');
        $('#editar-nombreAdministrador').css('color', '');

        $('#editar-primerApellidoAdministrador').css('border', '');
        $('#editar-primerApellidoAdministrador').css('color', '');

        $('#editar-segundoApellidoAdministrador').css('border', '');
        $('#editar-segundoApellidoAdministrador').css('color', '');

        $('#editar-correoAdministrador').css('border', '');
        $('#editar-correoAdministrador').css('color', '');

        $('#editar-telefonoAdministrador').css('border', '');
        $('#editar-telefonoAdministrador').css('color', '');

        $('#editar-noEmpleadoAdministrador').css('border', '');
        $('#editar-noEmpleadoAdministrador').css('color', '');
        
        $('#editar-especialidadAdministrador').css('border', '');
        $('#editar-especialidadAdministrador').css('color', '');
        
        $('#editar-posicionAdministrador').css('border', '');
        $('#editar-posicionAdministrador').css('color', '');

        $('#editar-cedulaProfesionalAdministrador').css('border', '');
        $('#editar-cedulaProfesionalAdministrador').css('color', '');

    });
    
    $("body").on("click", ".clearAddAdminModal", function () {
        
        $("#agregar-nombreAdministrador").val("");
        $("#agregar-telefonoAdministrador").val("");
        $("#agregar-primerApellidoAdministrador").val("");
        $("#agregar-segundoApellidoAdministrador").val("");
        $("#agregar-correoAdministrador").val("");
        $("#agregar-noEmpleadoAdministrador").val("");
        $("#agregar-especialidadAdministrador").val("");
        $("#agregar-posiciondAdministrador").val("");
        $("#agregar-cedulaAdministrador").val("");
        $("#agregar-passwordAdministrador").val("");
        $("#agregar-password2Administradores").val("");
        $("#terminosAdministrador").prop("checked", false);

        $('#errorNombreAdministrador').hide();
        $('#errorTelefonoAdministrador').hide();
        $('#errorApellidoPaternoAdministrador').hide();
        $('#errorApellidoMaternoAdministrador').hide();
        $('#errorCorreoAdministrador').hide();
        $('#errorCorreoRepetidoAdministrador').hide();
        $('#errorNumEmpleadoAdministrador').hide();
        $('#errorAgregarEspecialidadAdministrador').hide();
        $('#errorAgregarPosicionAdministrador').hide();
        $('#errorCedulaAdministrador').hide();
        $('#errorPass1Administrador').hide();
        $('#errorPass2Administrador').hide();
        $('#noEqualPasswordsError').hide();
        $('#errorTerminosAdministrador').hide();
        $('#error-camposAdministrador').hide();
        $('#error-datosRepetidosAdministrador').hide();

        $('#agregar-nombreAdministrador').css('border', '');
        $('#agregar-nombreAdministrador').css('color', '');

        $('#agregar-telefonoAdministrador').css('border', '');
        $('#agregar-telefonoAdministrador').css('color', '');

        $('#agregar-primerApellidoAdministrador').css('border', '');
        $('#agregar-primerApellidoAdministrador').css('color', '');

        $('#agregar-segundoApellidoAdministrador').css('border', '');
        $('#agregar-segundoApellidoAdministrador').css('color', '');

        $('#agregar-correoAdministrador').css('border', '');
        $('#agregar-correoAdministrador').css('color', '');

        $('#agregar-noEmpleadoAdministrador').css('border', '');
        $('#agregar-noEmpleadoAdministrador').css('color', '');

        $('#agregar-especialidadAdministrador').css('border', '');
        $('#agregar-especialidadAdministrador').css('color', '');

        $('#agregar-posiciondAdministrador').css('border', '');
        $('#agregar-posiciondAdministrador').css('color', '');

        $('#agregar-cedulaAdministrador').css('border', '');
        $('#agregar-cedulaAdministrador').css('color', '');

        $('#agregar-passwordAdministrador').css('border', '');
        $('#agregar-passwordAdministrador').css('color', '');

        $('#agregar-password2Administradores').css('border', '');
        $('#agregar-password2Administradores').css('color', '');

    });

    function mostrarContrasena(myButton, myField) {
        myButton.on('mousedown', function () {
            var x = document.getElementById(myField);
            x.type = "text";
        });
        myButton.on('mouseup', function () {
            var x = document.getElementById(myField);
            x.type = "password";
        });
    }


});