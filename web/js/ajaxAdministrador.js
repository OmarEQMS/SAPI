$(document).ready(function () {

    /////////////////////////////// GESTION MEDICOS

    /**AGREGAR MEDICO */
    $('#btn-agregarMedico').on('click', function () {

        var nombre = $('#agregar-nombreMedico');
        var telefono = $('#agregar-telefonoMedico');
        var primerApellido = $('#agregar-primerApellidoMedico');
        var segundoApellido = $('#agregar-segundoApellidoMedico');
        var correo = $('#agregar-correoMedico');
        var noEmpleado = $('#agregar-noEmpleadoMedico');
        var especialidad = $('#agregar-especialidadMedico');
        var subEspecialidad = $('#agregar-subespecialidadMedico');
        var cedula = $('#agregar-cedulaMedico');
        var password = $('#agregar-passwordMedico');;

        $.ajax({

            url: 'AdminController',
            cache: false,
            method: 'POST',
            data: {
                key: 'agregarMedico',
                nombre: nombre.val(),
                telefono: telefono.val(),
                primerApellido: primerApellido.val(),
                segundoApellido: segundoApellido.val(),
                correo: correo.val(),
                noEmpleado: noEmpleado.val(),
                especialidad: especialidad.val(),
                subEspecialidad: subEspecialidad.val(),
                cedula: cedula.val(),
                password: password.val()
            }
        })
            .done(function (response) {


            });

    });

    /**EDITAR MEDICO */
    //RECUPERA EL MEDICO PARA PONERLO EN EL MODAL
    $('body').on('click', '.btn-editarMedico', function () {

        var idMedico = $(this).data('id');

        $.ajax({

            url: 'AdminController',
            cache: false,
            dataType: 'JSON',
            method: "POST",
            data: {
                key: 'recuperaMedico',
                id: idMedico,
            },
            beforeSend: function () {

            },
            success: function (response) {

                $("#idMedico").val(response.id);
            }

        });

    });



    //GUARDA EL MEDICO DESDE EL MODAL
    $('#btn-guardarMedico').on('click', function () {

        var idMedico = $('#idMedico');

        var nombre = $('#editar-nombreMedico');
        var telefono = $('#editar-telefonoMedico');
        var primerApellido = $('#editar-primerApellidoMedico');
        var segundoApellido = $('#editar-segundoApellidoMedico');
        var correo = $('#editar-correoMedico');
        var noEmpleado = $('#editar-noEmpleadoMedico');
        var especialidad = $('#editar-especialidadMedico');
        var subEspecialidad = $('#editar-subespecialidadMedico');
        var cedula = $('#editar-cedulaMedico');
        var password = $('#editar-passwordMedico');

        $.ajax({

            url: 'AdminController',
            cache: false,
            method: 'POST',
            data: {
                key: 'recuperaMedico',
                idMedico: idMedico.val(),
                nombre: nombre.val(),
                telefono: telefono.val(),
                primerApellido: primerApellido.val(),
                segundoApellido: segundoApellido.val(),
                correo: correo.val(),
                noEmpleado: noEmpleado.val(),
                especialidad: especialidad.val(),
                subEspecialidad: subEspecialidad.val(),
                cedula: cedula.val(),
                password: password.val()
            }
        })
            .done(function (response) {


            });

    });

    /** ELIMINAR MEDICO */
    $('body').on('click', '#btn-eliminarMedico', function () {

        var idMedico = $(this).data('id');

        //Modal editar medicos
        swal({
            title: "Estas segura(o)?",
            text: "Los datos se eliminarán y no podrás recuperarlos.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
            .then((eliminar) => {
                if (eliminar) {

                    $.ajax({

                        url: 'AdminController',
                        cache: false,
                        method: 'POST',
                        data: {
                            key: 'eliminarMedico',
                            idMedico: idMedico
                        },
                        success: function (response) {

                        }


                    });

                } else {

                }
            });

    });

    ///////////////////////////////GESTIÓN NAVEGADORAS

    /**AGREGAR NAVEGADORA */
    $('#btn-agregarNavegadora').on('click', function () {

        var nombre = $('#agregar-nombreNavegadora');
        var telefono = $('#agregar-telefonoNavegadora');
        var primerApellido = $('#agregar-primerApellidoNavegadora');
        var segundoApellido = $('#agregar-segundoApellidoNavegadora');
        var correo = $('#agregar-correoNavegadora');
        var noEmpleado = $('#agregar-noEmpleadoNavegadora');
        var especialidad = $('#agregar-especialidadNavegadora');
        var cedula = $('#agregar-cedulaNavegadora');
        var password = $('#agregar-passwordNavegadora');

        $.ajax({

            url: 'AdminController',
            cache: false,
            method: 'POST',
            data: {
                key: 'agregarNavegadora',
                nombre: nombre.val(),
                telefono: telefono.val(),
                primerApellido: primerApellido.val(),
                segundoApellido: segundoApellido.val(),
                correo: correo.val(),
                noEmpleado: noEmpleado.val(),
                especialidad: especialidad.val(),
                cedula: cedula.val(),
                password: password.val()
            }
        })
            .done(function (response) {


            });

    });

    /**EDITAR NAVEGADORA */
    //RECUPERA LA NAVEGADORA PARA PONERLO EN EL MODAL
    $('body').on('click', '.btn-editarNavegadora', function () {

        var idNavegadora = $(this).data('id');

        $.ajax({

            url: 'AdminController',
            cache: false,
            dataType: 'JSON',
            method: "POST",
            data: {
                key: 'recuperaNavegadora',
                id: idNavegadora,
            },
            beforeSend: function () {

            },
            success: function (response) {

                $("#idNavegadora").val(response.id);
            }

        });

    });

    //GUARDA EL MEDICO DESDE EL MODAL
    $('#btn-guardarNavegadora').on('click', function () {

        var idNavegadora = $('#idNavegadora');

        var nombre = $('#editar-nombreNavegadora');
        var telefono = $('#editar-telefonoNavegadora');
        var primerApellido = $('#editar-primerApellidoNavegadora');
        var segundoApellido = $('#editar-segundoApellidoNavegadora');
        var correo = $('#editar-correoNavegadora');
        var noEmpleado = $('#editar-noEmpleadoNavegadora');
        var especialidad = $('#editar-especialidadNavegadora');
        var cedula = $('#editar-cedulaNavegadora');
        var password = $('#editar-passwordNavegadora');

        $.ajax({

            url: 'AdminController',
            cache: false,
            method: 'POST',
            data: {
                key: 'recuperaNavegadora',
                idNavegadora: idNavegadora.val(),
                nombre: nombre.val(),
                telefono: telefono.val(),
                primerApellido: primerApellido.val(),
                segundoApellido: segundoApellido.val(),
                correo: correo.val(),
                noEmpleado: noEmpleado.val(),
                especialidad: especialidad.val(),
                subEspecialidad: subEspecialidad.val(),
                cedula: cedula.val(),
                password: password.val()
            }
        })
            .done(function (response) {


            });

    });

    /** ELIMINAR NAVEGADORA */
    $('body').on('click', '#btn-eliminarNavegadora', function () {

        var idNavegadora = $(this).data('id');

        //Modal editar medicos
        swal({
            title: "Estas seguro?",
            text: "Los datos se eliminarán y no podrás recuperarlos.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
            .then((eliminar) => {
                if (eliminar) {

                    $.ajax({

                        url: 'AdminController',
                        cache: false,
                        method: 'POST',
                        data: {
                            key: 'eliminarNavegadora',
                            idNavegadora: idNavegadora
                        },
                        success: function (response) {

                        }


                    });

                } else {

                }
            });

    });


    /////////////////////////////// GESTION PACIENTES

    /**AGREGAR PACIENTES */
    $('#btn-agregarPaciente').on('click', function () {

        var nombre = $('#agregar-nombrePaciente');
        var curp = $('#agregar-curpPaciente');
        var primerApellido = $('#agregar-primerApellidoPaciente');
        var segundoApellido = $('#agregar-segundoApellidoPaciente');
        var usuario = $('#agregar-usuarioPaciente');
        var estadoCivil = $('#agregar-estadoCivilPaciente');
        var fechaNacimiento = $('#agregar-fechaNacimientoPaciente');
        var calle = $('#agregar-callePaciente');
        var noInt = $('#agregar-noIntPaciente');
        var noExt = $('#agregar-noExtPaciente');
        var estado = $('#agregar-estadoPaciente');
        var ciudad = $('#agregar-ciudadPaciente');
        var telefono = $('#agregar-telefonoPaciente');
        var correo = $('#agregar-correoPaciente');
        var colonia = $('#agregar-coloniaPaciente');
        var password = $('#agregar-passwordPaciente');;

        $.ajax({

            url: 'AdminController',
            cache: false,
            method: 'POST',
            data: {
                key: 'agregarPaciente',
                nombre: nombre.val(),
                curp: curp.val(),
                primerApellido: primerApellido.val(),
                segundoApellido: segundoApellido.val(),
                usuario: usuario.val(),
                estadoCivil: estadoCivil.val(),
                fechaNacimiento: fechaNacimiento.val(),
                calle: calle.val(),
                noInt: noInt.val(),
                noExt: noExt.val(),
                estado: estado.val(),
                ciudad: ciudad.val(),
                telefono: telefono.val(),
                correo: correo.val(),
                colonia: colonia.val(),
                password: password.val()
            }
        })
            .done(function (response) {


            });

    });

    /**EDITAR PACIENTE */
    //RECUPERA EL MEDICO PARA PONERLO EN EL MODAL
    $('body').on('click', '.btn-editarMedico', function () {

        var idPaciente = $(this).data('id');

        $.ajax({

            url: 'AdminController',
            cache: false,
            dataType: 'JSON',
            method: "POST",
            data: {
                key: 'recuperaPaciente',
                id: idPaciente,
            },
            beforeSend: function () {

            },
            success: function (response) {

                $("#idPaciente").val(response.id);
            }

        });

    });

    //GUARDA EL PACIENTE DESDE EL MODAL
    $('#btn-guardarPaciente').on('click', function () {

        var idPaciente = $('#idPaciente');

        var prz = $('#editar-przPaciente');
        var nombre = $('#editar-nombrePaciente');
        var primerApellido = $('#editar-primerApellidoMedico');
        var segundoApellido = $('#editar-segundoApellidoMedico');
        var usuario = $('#editar-usuarioPaciente');
        var estadoCivil = $('#editar-estadoCivilPaciente');
        var fechaNacimiento = $('#editar-fechaNacimientoPaciente');
        var tratamiento = $('#editar-tratamientoPaciente');
        var estadio = $('#editar-estadioPaciente');
        var calle = $('#editar-callePaciente');
        var noInt = $('#editar-noIntPaciente');
        var noExt = $('#editar-noExtPaciente');
        var telefono = $('#editar-telefonoPaciente');
        var correo = $('#editarcorreoPaciente');

        $.ajax({

            url: 'AdminController',
            cache: false,
            method: 'POST',
            data: {
                key: 'recuperaPaciente',
                idPaciente: idPaciente.val(),
                prz: prz.val(),
                nombre: nombre.val(),
                primerApellido: primerApellido.val(),
                segundoApellido: segundoApellido.val(),
                usuario: usuario.val(),
                estadoCivil: estadoCivil.val(),
                fechaNacimiento: fechaNacimiento.val(),
                tratamiento: tratamiento.val(),
                estadio: estadio.val(),
                calle: calle.val(),
                noInt: noInt.val(),
                noExt: noExt.val(),
                telefono: telefono.val(),
                correo: correo.val()


            }
        })
            .done(function (response) {


            });

    });

    /** ELIMINAR MEDICO */
    $('body').on('click', '#btn-eliminarPaciente', function () {

        var idPaciente = $(this).data('id');

        //Modal editar medicos
        swal({
            title: "Estas seguro?",
            text: "Los datos se eliminarán y no podrás recuperarlos.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
            .then((eliminar) => {
                if (eliminar) {

                    $.ajax({

                        url: 'AdminController',
                        cache: false,
                        method: 'POST',
                        data: {
                            key: 'eliminarPaciente',
                            idPaciente: idPaciente
                        },
                        success: function (response) {

                        }


                    });

                } else {

                }
            });

    });


});