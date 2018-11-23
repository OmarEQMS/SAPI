$(document).ready(function () {


    //Errores al agregar a un médico
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

    $('#errorAgregarEspecialidad').hide();
    $('#errorAgregarPosicion').hide();

    //Errores al editar a un médico
    $('#errorEditarNombreMedico').hide();
    $('#errorEditarTelefonoMedico').hide();
    $('#errorEditarApellidoPaternoMedico').hide();
    $('#errorEditarApellidoMaternoMedico').hide();
    $('#errorEditarCorreoMedico').hide();
    $('#errorEditarCorreoRepetido').hide();
    $('#errorEditarNumEmpleado').hide();
    $('#errorEditarCedulaMedicos').hide();
    $('#error-editarDatosRepetidos').hide();
    $('#errorEditarEspecialidad').hide();
    //$('#errorEditarPosicion').hide();
    


    //Errores al agregar a un paciente
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
    $('#errorPass1Paciente').hide();
    $('#errorPass2Paciente').hide();
    $('#error-CPexistePaciente').hide();
    $('#errorCodigoPostalPaciente').hide();
    $('#noEqualPasswordsErrorPaciente').hide();



    var repiteCorreo;


    //TELEFONO EN AGREGAR MÉDICO
    $('#agregar-telefonoMedico').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorTelefonoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorTelefonoMedico').hide();
        } else {
            $('#errorTelefonoMedico').show();
        }

    });

    //CÉDULA PROFESIONAL EN AGREGAR MÉDICO
    $('#agregar-cedulaMedico').on('change', function () {

        if (isValidCedula($(this))) {
            $('#errorCedulaMedicos').hide();
        } else if ($(this).val() == '') {
            $('#errorCedulaMedicos').hide();
        } else {
            $('#errorCedulaMedicos').show();
        }

    });

    //NÚMERO DE EMPLEADO EN AGREGAR MÉDICO
    $('#agregar-noEmpleadoMedico').on('change', function () {

        if (isValidNumEmpleado($(this))) {
            $('#errorNumEmpleado').hide();
        } else if ($(this).val() == '') {
            $('#errorNumEmpleado').hide();
        } else {
            $('#errorNumEmpleado').show();
        }

    });

    //NÚMERO DE EMPLEADO EN AGREGAR MÉDICO
    $('#agregar-especialidadMedico').on('change', function () {

        if (isValidEspecialidad($(this))) {
            $('#errorAgregarEspecialidad').hide();
        } else if ($(this).val() == '') {
            $('#errorAgregarEspecialidad').hide();
        } else {
            $('#errorAgregarEspecialidad').show();
        }

    });
    
    //NÚMERO DE EMPLEADO EN AGREGAR MÉDICO
    $('#editar-especialidadMedico').on('change', function () {

        if (isValidEspecialidad($(this))) {
            $('#errorEditarEspecialidad').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarEspecialidad').hide();
        } else {
            $('#errorEditarEspecialidad').show();
        }

    });

    //NÚMERO DE EMPLEADO EN AGREGAR MÉDICO
    $('#agregar-posiciondMedico').on('change', function () {

        if (isValidPosicion($(this))) {
            $('#errorAgregarPosicion').hide();
        } else if ($(this).val() == '') {
            $('#errorAgregarPosicion').hide();
        } else {
            $('#errorAgregarPosicion').show();
        }

    });
    
    /*
     * 
    //NÚMERO DE EMPLEADO EN AGREGAR MÉDICO
    $('#editar-posiciondMedico').on('change', function () {

        if (isValidPosicion($(this))) {
            $('#errorEditarPosicion').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarPosicion').hide();
        } else {
            $('#errorEditarPosicion').show();
        }

    });
     * 
     */

    //NOMBRE EN AGREGAR MÉDICO
    $('#agregar-nombreMedico').on('change', function () {

        if (isValidName($(this))) {
            $('#errorNombreMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreMedico').hide();
        } else {
            $('#errorNombreMedico').show();
        }
    });

    //PRIMER APELLIDO EN AGREGAR MÉDICO
    $('#agregar-primerApellidoMedico').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoPaternoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoPaternoMedico').hide();
        } else {
            $('#errorApellidoPaternoMedico').show();
        }

    });

    //SEGUNDO APELLIDO EN AGREGAR MÉDICO
    $('#agregar-segundoApellidoMedico').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoMaternoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoMaternoMedico').hide();
        } else {
            $('#errorApellidoMaternoMedico').show();
        }

    });

    //CONTRASEÑA EN AGREGAR MÉDICO
    $('#agregar-passwordMedico').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass1Medico').hide();
        } else if ($(this).val() == '') {
            $('#errorPass1Medico').hide();
        } else {
            $('#errorPass1Medico').show();
        }

    });


    //CONTRASEÑAS IGUALES EN AGREGAR MÉDICO
    $('#agregar-password2Medico').on('change', function () {

        var pass1 = $('#agregar-passwordMedico');
        var pass2 = $('#agregar-password2Medico');

        areEqualPasswords(pass1, pass2);

    });

    $('#terminosMedico').on('change', function () {

        if (isValidCheckbox($(this))) {
            $('#errorTerminos').hide();
        } else {
            $('#errorTerminos').show();
        }
    });

    $('#agregar-correoMedico').on('change', function () {
        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteCorreo",
                correo: $('#agregar-correoMedico').val()


            },
            success: function (response) {

                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#agregar-correoMedico').css('color', 'orange');
                    $('#errorCorreoRepetido').show();
                    repiteCorreo = true;
                } else {
                    $('#errorCorreoRepetido').hide();
                    repiteCorreo = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#errorCorreoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreoMedico').hide();
        } else {
            $('#errorCorreoMedico').show();
        }

    });


    /////////////////////////////// GESTION MEDICOS //////

    /**AGREGAR MEDICO */
    $('#btn-agregarMedico').on('click', function () {

        if (!repiteCorreo) {

            $("#error-datosRepetidos").hide();

            if (isValidName($('#agregar-nombreMedico')) && isValidLastName($('#agregar-primerApellidoMedico')) && isValidLastName($('#agregar-segundoApellidoMedico'))
                    && isValidNumEmpleado($('#agregar-noEmpleadoMedico')) && isValidEmail($('#agregar-correoMedico')) && isValidPassword($('#agregar-passwordMedico')) && isValidCedula($('#agregar-cedulaMedico'))
                    && isValidPhoneNumber($('#agregar-telefonoMedico')) && isValidCheckbox($('#terminosMedico')) && isValidEspecialidad($('#agregar-especialidadMedico')) && isValidPosicion($('#agregar-posiciondMedico'))
                    && areEqualPasswords($('#agregar-passwordMedico'), $('#agregar-password2Medico'))
                    && $('#errorCorreoRepetido').hide()) {

                $("#error-campos").hide();

                var nombre = $('#agregar-nombreMedico');
                var telefono = $('#agregar-telefonoMedico');
                var primerApellido = $('#agregar-primerApellidoMedico');
                var segundoApellido = $('#agregar-segundoApellidoMedico');
                var correo = $('#agregar-correoMedico');
                var noEmpleado = $('#agregar-noEmpleadoMedico');
                var especialidad = $('#agregar-especialidadMedico');
                var posicion = $('#agregar-posiciondMedico');
                var cedula = $('#agregar-cedulaMedico');
                var password = $('#agregar-passwordMedico');

                $.ajax({

                    url: 'RegistraUsuarioController',
                    cache: false,
                    method: 'POST',
                    data: {
                        key: 'agregarMedico',
                        nombre: nombre.val(),
                        primerApellido: primerApellido.val(),
                        segundoApellido: segundoApellido.val(),
                        telefono: telefono.val(),
                        correo: correo.val(),
                        noEmpleado: noEmpleado.val(),
                        especialidad: especialidad.val(),
                        posicion: posicion.val(),
                        cedula: cedula.val(),
                        password: password.val()
                    },
                    success: function (response) {

                        console.log(response);
                        swal({
                            title: "¡Buen trabajo!",
                            text: "Se ha agregado correctamente al médico.",
                            icon: "success",
                            buttons: [, 'Aceptar'],
                        });

                        //Limpiar los campos después de registrarse 

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

                        //Cerrar el modal
                        $('#modalAgregarMedico').modal('toggle');
                    }
                })
                        .done(function (response) {


                        });
            } else {
                console.log("Entro al segundo else");
                $("#error-campos").show(); //No se llenaron los campos obligatorios
            }
        } else {
            console.log("Entro al segundo else");
            $("#error-datosRepetidos").show(); //ya existe un campo
        }
    });

    ////////////////////////////////////////////////////////////// VALIDACIONES EDITAR UN MÉDICO

    //TELEFONO EN EDITAR MÉDICO
    $('#editar-telefonoMedico').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorEditarTelefonoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarTelefonoMedico').hide();
        } else {
            $('#errorEditarTelefonoMedico').show();
        }

    });

    //CÉDULA PROFESIONAL EN EDITAR MÉDICO
    $('#editar-cedulaProfesionalMedico').on('change', function () {

        if (isValidCedula($(this))) {
            $('#errorEditarCedulaMedicos').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarCedulaMedicos').hide();
        } else {
            $('#errorEditarCedulaMedicos').show();
        }

    });

    //NÚMERO DE EMPLEADO EN EDITAR MÉDICO
    $('#editar-noEmpleadoMedico').on('change', function () {

        if (isValidNumEmpleado($(this))) {
            $('#errorEditarNumEmpleado').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarNumEmpleado').hide();
        } else {
            $('#errorEditarNumEmpleado').show();
        }

    });

    //NOMBRE EN EDITAR MÉDICO
    $('#editar-nombreMedico').on('change', function () {

        if (isValidName($(this))) {
            $('#errorEditarNombreMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarNombreMedico').hide();
        } else {
            $('#errorEditarNombreMedico').show();
        }
    });

    //PRIMER APELLIDO EN EDITAR MÉDICO
    $('#editar-primerApellidoMedico').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorEditarApellidoPaternoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarApellidoPaternoMedico').hide();
        } else {
            $('#errorEditarApellidoPaternoMedico').show();
        }

    });

    //SEGUNDO APELLIDO EN EDITAR MÉDICO
    $('#editar-segundoApellidoMedico').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorEditarApellidoMaternoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarApellidoMaternoMedico').hide();
        } else {
            $('#errorEditarApellidoMaternoMedico').show();
        }

    });

    $('#editar-correoMedico').on('change', function () {
        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteCorreo",
                correo: $('#editar-correoMedico').val()


            },
            success: function (response) {

                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#editar-correoMedico').css('color', 'orange');
                    $('#errorEditarCorreoRepetido').show();
                    repiteCorreo = true;
                } else {
                    $('#errorEditarCorreoRepetido').hide();
                    repiteCorreo = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#errorEditarCorreoMedico').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarCorreoMedico').hide();
        } else {
            $('#errorEditarCorreoMedico').show();
        }

    });

    /**EDITAR MEDICO */
    //RECUPERA EL MEDICO PARA PONERLO EN EL MODAL
    $('body').on('click', '.btn-editarMedico', function () {

        var idMedico = $(this).data('id');
        console.log("idMédico " + idMedico);


        $.ajax({

            url: 'AdministradorController',
            cache: false,
            dataType: 'JSON',
            method: "POST",
            data: {
                key: 'obtener-medico',
                idMedicoAdministrador: idMedico
            },
            beforeSend: function () {

            },
            success: function (response) {

                //$("#idMedico").val(response.id);
                console.log(response);

                var json = response;
                $('#idMedico').val(json.idEmpleado);
                $('#editar-nombreMedico').val(json.nombre);
                $('#editar-primerApellidoMedico').val(json.primerApellido);
                $('#editar-segundoApellidoMedico').val(json.segundoApellido);
                $('#editar-correoMedico').val(json.correo);
                $('#editar-telefonoMedico').val(json.telefono);
                $('#editar-noEmpleadoMedico').val(json.noEmpleado);
                $('#editar-especialidadMedico').val(json.nombreEspecialidad);
                $('#editar-cedulaProfesionalMedico').val(json.cedulaProfesional);

            }

        });
    });

    $('#irAInicioAdministrador').on('click', function () {
        $.post("SAPI", {
            file: "administrador/index.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });


    $('#IrAGestionMedicos').on('click', function () {
        $.post("SAPI", {
            file: "administrador/gestionMedicos.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });

    $('#IrAGestionNavegadora').on('click', function () {
        $.post("SAPI", {
            file: "administrador/gestionNavegadora.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });
    $('#IrAGestionPaciente').on('click', function () {
        $.post("SAPI", {
            file: "administrador/gestionPacientes.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });
    $('#IrAGestionAdministrador').on('click', function () {
        $.post("SAPI", {
            file: "administrador/gestionarAdministradores.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });
    $('#IrAReasignarMedico').on('click', function () {
        $.post("SAPI", {
            file: "administrador/reAsignarMedico.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });

    $('#IrAInicio').on('click', function () {
        $.post("SAPI", {
            file: "administrador/gestionMedicos.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });



    $('.btn-success').on('click', function () {

        console.log("VerNavegadora");
        var idNavegadora = $(this).data('id');

        $.post("SAPI", {
            file: "administrador/rendimientoNavegadora.jsp",
            idNavegadora: idNavegadora
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });


    $('#IrAMiCuenta').on('click', function () {
        $.post("SAPI", {
            file: "administrador/cuentaAdministrador.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });



    $('#salirCuenta').on('click', function () {
        console.log("Salir cuenta");
        $.post("LoginController", {
            key: "cerrar-sesion"
        },
                function (response, status, xhr) {
                    console.log(response);
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });


    //GUARDA EL MEDICO DESDE EL MODAL
    $('#btn-guardarMedico').on('click', function () {

        if (!repiteCorreo) {
            $("#error-editarDatosRepetidos").hide();

            if (isValidName($('#editar-nombreMedico')) && isValidLastName($('#editar-primerApellidoMedico')) && isValidLastName($('#editar-segundoApellidoMedico'))
                    && isValidNumEmpleado($('#editar-noEmpleadoMedico')) && isValidEmail($('#editar-correoMedico')) && isValidCedula($('#editar-cedulaProfesionalMedico'))
                    && isValidPhoneNumber($('#editar-telefonoMedico')) && isValidEspecialidad($('#editar-especialidadMedico')) /*&& isValidPosicion($('#editar-posicionMedico'))*/
                    && $('#errorCorreoRepetido').hide()) {
                
                var idMedico = $('#idMedico').val();
                var nombre = $('#editar-nombreMedico').val();
                var telefono = $('#editar-telefonoMedico').val();
                var primerApellido = $('#editar-primerApellidoMedico').val();
                var segundoApellido = $('#editar-segundoApellidoMedico').val();
                var correo = $('#editar-correoMedico').val();
                var noEmpleado = $('#editar-noEmpleadoMedico').val();
                var especialidad = $('#editar-especialidadMedico').val();
                var cedula = $('#editar-cedulaProfesionalMedico').val();

                console.log("idMédicoooo " + idMedico);
                console.log("nombre " + nombre);
                console.log("phone " + telefono);
                console.log("ape 1 " + primerApellido);
                console.log("ape 2 " + segundoApellido);
                console.log("mail " + correo);
                console.log("empleado no " + noEmpleado);
                console.log("especiliad  " + especialidad);
                console.log("cedula " + cedula);


                console.log("Holi, hará el ajax");

                $.ajax({

                    url: 'AdministradorController',
                    cache: false,
                    method: 'POST',
                    data: {
                        key: 'actualizar-medico',
                        idMedico: idMedico,
                        nombre: nombre,
                        telefono: telefono,
                        primerApellido: primerApellido,
                        segundoApellido: segundoApellido,
                        correo: correo,
                        noEmpleado: noEmpleado,
                        especialidad: especialidad,
                        cedula: cedula
                    },
                    success: function (response) {
                        $('#modalEditarMedico').modal('toggle'); //cerrar modal
                        console.log("Cierra el modal");
                        swal({
                            title: "Cambios guardados correctamente",
                            icon: "success",
                            buttons: true,
                            buttons: [, 'Aceptar']
                        });
                        console.log("ESTOY EN EL SUCCESS!! :o");
                        $('#nombre-' + idMedico).html(nombre + " " + primerApellido + " " + segundoApellido);
                        $('#correo-' + idMedico).html(correo);
                        $('#telefono-' + idMedico).html(telefono);
                        $('#noEmpleado-' + idMedico).html(noEmpleado);
                        $('#nombreEspecialidad-' + idMedico).html(especialidad);
                        $('#cedulaProfesional-' + idMedico).html(cedula);
                    }

                });

            }
        } else {
            console.log("Entro al segundo else");
            $("#error-datosRepetidos").show(); //ya existe un campo
        }

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

        console.log(nombre);
        console.log(telefono);
        console.log(primerApellido);
        console.log(segundoApellido);
        console.log(correo);
        console.log(noEmpleado);
        console.log(especialidad);
        console.log(cedula);
        console.log(password);

        $.ajax({

            url: 'RegistraUsuarioController',
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
            },
            success: function (response) {
                $('#modalAgregarNavegadora').modal('toggle'); //cerrar modal
                swal({
                    title: "Cambios guardados correctamente",
                    icon: "success",
                    buttons: true,
                    buttons: [, 'Aceptar']
                });
            }
        });
    });

    /**EDITAR NAVEGADORA */
    //RECUPERA LA NAVEGADORA PARA PONERLO EN EL MODAL
    $('body').on('click', '.btn-editarNavegadora', function () {

        var idNavegadora = $(this).data('id');
        console.log(idNavegadora);

        $.ajax({

            url: 'AdministradorController',
            cache: false,
            dataType: 'JSON',
            method: "POST",
            data: {
                key: 'obtener-navegadora',
                idNavegadora: idNavegadora,
            },
            beforeSend: function () {

            },
            success: function (response) {

                console.log(response);
                $('#idNavegadora').val(response.idEmpleado);
                $('#editar-nombreNavegadora').val(response.nombre);
                $('#editar-telefonoNavegadora').val(response.telefono);
                $('#editar-primerApellidoNavegadora').val(response.primerApellido);
                $('#editar-segundoApellidoNavegadora').val(response.segundoApellido);
                $('#editar-correoNavegadora').val(response.correo);
                $('#editar-no-empleadoNavegadora').val(response.noEmpleado);
                $('#editar-especialidad').val(response.nombreEspecialidad);
                $('#editar-cedulaNavegadora').val(response.cedulaProfesional);
            }

        });

    });

    //GUARDA LA NAVEGADORA DESDE EL MODAL
    $('#btn-guardarNavegadora').on('click', function () {

        var idNavegadora = $('#idNavegadora').val();

        var nombre = $('#editar-nombreNavegadora').val();
        var telefono = $('#editar-telefonoNavegadora').val();
        var primerApellido = $('#editar-primerApellidoNavegadora').val();
        var segundoApellido = $('#editar-segundoApellidoNavegadora').val();
        var correo = $('#editar-correoNavegadora').val();
        var noEmpleado = $('#editar-no-empleadoNavegadora').val();
        var especialidad = $('#editar-especialidad').val();
        var cedula = $('#editar-cedulaNavegadora').val();

        console.log("idNavegadoraaaaa " + idNavegadora);
        console.log("nombre " + nombre);
        console.log("phone " + telefono);
        console.log("ape 1 " + primerApellido);
        console.log("ape 2 " + segundoApellido);
        console.log("mail " + correo);
        console.log("empleado no " + noEmpleado);
        console.log("especiliad  " + especialidad);
        console.log("cedula " + cedula);

        console.log("Holi, hará el ajax");

        $.ajax({

            url: 'AdministradorController',
            cache: false,
            method: 'POST',
            data: {
                key: 'actualiza-navegadora',
                idNavegadora: idNavegadora,
                nombre: nombre,
                telefono: telefono,
                primerApellido: primerApellido,
                segundoApellido: segundoApellido,
                correo: correo,
                noEmpleado: noEmpleado,
                especialidad: especialidad,
                cedula: cedula,
            },
            success: function (response) {
                $('#modalEditarNavegadora').modal('toggle'); //cerrar modal
                console.log("Cierra el modal");
                swal({
                    title: "Cambios guardados correctamente",
                    icon: "success",
                    buttons: true,
                    buttons: [, 'Aceptar']
                });
                console.log("ESTOY EN EL SUCCESS!! :o");
                $('#nombre-' + idNavegadora).html(nombre + " " + primerApellido + " " + segundoApellido);
                $('#correo-' + idNavegadora).html(correo);
                $('#telefono-' + idNavegadora).html(telefono);
                $('#noEmpleado-' + idNavegadora).html(noEmpleado);
                $('#nombreEspecialidad-' + idNavegadora).html(especialidad);
                $('#cedulaProfesional-' + idNavegadora).html(cedula);
            }
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
        var password = $('#agregar-passwordPaciente');
        ;

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

    //AUTOCOMPLETAR Especialidades
    var especialidades = $('#listEspecialidades');

    $.ajax({
        url: 'AdministradorController',
        cache: false,
        method: 'POST',
        data: {key: "autocompletarEspecialidades"}
    })

            .done(function (response) {

                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {

                    var newObjeto = $('<option value="' + json[i].nombre + '"></option>');
                    especialidades.append(newObjeto);
                }


                console.log(JSON.stringify(especialidades));

            });


    // AUTOCOMPLETAR POSICIONES

    var posiciones = $('#listPosiciones');


    $.ajax({
        url: 'AdministradorController',
        cache: false,
        method: 'POST',
        data: {key: "autocompletarPosiciones"}
    })
            .done(function (response) {

                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {

                    var newObjeto = $('<option value="' + json[i].nombre + '"></option>');
                    posiciones.append(newObjeto);
                }

                console.log(JSON.stringify(posiciones));

            });

    //VALIDACIONES

    function isValidPassword(input) {

        var m = input.val();

        var expreg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{8,14}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidIntNumber(input) {

        var m = input.val();

        var expreg = /^[#a-zA-Z0-9]{1,100000}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;


    }

    function isValidExtNumber(input) {

        var m = input.val();

        var expreg = /^[#0-9]{1,100000}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;

    }

    function areEqualPasswords(pass1, pass2) {

        if (pass1.val() != pass2.val()) {

            pass2.css('border', '1px solid red');
            pass1.css('border', '1px solid red');
            $('#noEqualPasswordsError').show();

            return false;

        } else {

            pass2.css('border', '');
            pass1.css('border', '');
            $('#noEqualPasswordsError').hide();

        }

        return true;
    }

    function isValidName(input) {

        var m = input.val();

        var expreg = /^[-a-zA-Z\u00E0-\u00FCñÑ. ]{2,255}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidPosicion(input) {

        var m = input.val();

        var expreg = /^[-a-zA-Z\u00E0-\u00FCñÑ. ]{2,255}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidEspecialidad(input) {

        var m = input.val();

        var expreg = /^[-a-zA-Z\u00E0-\u00FCñÑ. ]{2,255}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidLastName(input) {

        var m = input.val();

        var expreg = /^[-a-zA-Z\u00E0-\u00FCñÑ. ]{2,127}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidUserName(input) {

        var m = input.val();

        var expreg = /^[a-zA-Z0-9]{4,16}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidEmail(input) {

        var m = input.val();

        var expreg = /^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidPhoneNumber(input) {

        var m = input.val();

        var expreg = /^[0-9]{10,10}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidDate(input) {

        //Obtener fecha
        let today = new Date();

        //Valor seleccionado del input
        let date_from = input.val();
        date_from = new Date(date_from);

        //Tomar los valores de hoy
        var year = today.getFullYear();
        var month = today.getMonth();
        var day = today.getDate();

        //Hoy hace 16 años y hoy hace 115 años
        var maxDate = new Date(year - 16, month, day);
        var minDate = new Date(year - 115, month, day);

        let event = true;

        if (maxDate > date_from && date_from > minDate) {
            event = false;
        }

        if (!input.val() || event) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidSelect(input) {

        if (!input.val()) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidNumEmpleado(input) {

        var m = input.val();

        var expreg = /^[0-9]{6,6}$/;


        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidStreet(input) {

        var m = input.val();

        var expreg = /^[a-zA-Z\u00E0-\u00FCñÑ.0-9 ]{1,255}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;


    }

    function isValidColonia(input) {

        var m = input.val();

        var expreg = /^[a-zA-Z\u00E0-\u00FCñÑ.0-9 ]{1,500}$/;


        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidCURP(input) {

        var m = input.val();

        var expreg = /^([A-Z][AEIOUX][A-Z]{2}\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\d])(\d)$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidCedula(input) {

        var m = input.val();

        var expreg = /^[0-9]{7,7}$/;


        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidCheckbox(input) {

        if (input.is(':checked')) {
            return true;
        }

        return false;
    }
});