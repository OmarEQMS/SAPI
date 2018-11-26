$(document).ready(function () {


    /////////////////////////////// MI CUENTA ////////

    $('#error-correo').hide();
    $('#error-usuario').hide();
    $('#error-contrasena').hide();
    $('#noEqualPasswordsError').hide();

    $("#guardarCambios").on('click', function () {

        if (isValidUserName($('#username')) && isValidEmail($('#correo'))) {

            console.log("Presionó GuardarCambios");
            var form = $("form")[0];
            console.log(form);
            var data = new FormData(form);
            data.append("key", "cambiarDatos");
            data.forEach((value, key) => {
                console.log(key + " " + value);
            });

            $.ajax({
                url: "AdministradorController",
                data: data,
                method: "POST",
                enctype: 'multipart/form-data',
                processData: false, // Important!
                contentType: false,
                cache: false,
                success: function (response) {

                    swal({
                        title: "Buen trabajo!",
                        text: "Cuenta actualizada correctamente",
                        icon: "success",
                        button: "Ok",
                    })
                            .then((value) => {
                                $.post("SAPI", {
                                    file: "administrador/cuentaAdministrador.jsp"
                                },
                                        function (response, status, xhr) {
                                            console.log("El ajax fue exitoso!!-----------------------");
                                            if (status == "success") {
                                                if (response == "error") {
                                                    swal("Error", "Hubo un error actualizando tus datos", "error");
                                                } else {
                                                    document.open("text/html", "replace");
                                                    document.write(response);
                                                    document.close();

                                                }
                                            }
                                        }
                                );
                            });


                },
                error: function (xhr) {
                    //alert(xhr.statusText);
                }
            });


        } else {
            swal({
                title: "Error",
                text: "Verifica que todos los datos sean validos",
                icon: "error",
                button: "Entendido!",
            });

        }

    });

    //Cambiar imagen temporalmente en elfront
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#ImagenPerfil').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#file-input").on('change', function () {
        console.log("Llegó :)");
        readURL(this);
    });

    ////*****CAMBIAR CONTRASEÑA
    $("#btn-updatePassword").on('click', function () {


        //Modal cambiar contraseña 
        if (isValidPassword($('#password')) && isValidPassword($('#password2')) && areEqualPasswords($('#password'), $('#password2'))) {
            swal({
                title: "¿Estás segura(o) que deseas guardar los cambios de tu contraseña?",
                text: "No podras volver a usar tu contraseña anterior para ingresar",
                icon: "warning",
                buttons: true,
                buttons: ['Regresar', 'Cambiar contraseña'],
                dangerMode: true
            })
                    .then((cambiar) => {
                        if (cambiar) {
                            $.ajax({
                                url: "AdministradorController",
                                data: {
                                    key: "cambiarContrasena",
                                    idCuenta: $("#sesionPaciente").val(),
                                    password: $("#password").val(),
                                    password2: $("#password2").val()
                                },
                                method: "POST",
                                success: function (response) {
                                    if (response == "success") {
                                        swal({
                                            title: "Buen trabajo!",
                                            text: "Contraseña actualizada correctamente!",
                                            icon: "success",
                                            button: "Entendido!",
                                        });
                                        $("#password").val('');
                                        $("#password2").val('');
                                    } else {
                                        //Aqui no se que hace
                                    }
                                },
                                error: function (xhr) {

                                }
                            });
                            $('#modalCambiarContraseña').modal('toggle');
                        }
                    });
        }

    });

    //1.- Usuario
    $('#username').on('change', function () {
        if (isValidUserName($('#username'))) {
            $('#error-usuario').hide();

        } else {
            $('#error-usuario').show();

        }
    });

    //2.- Correo
    $('#correo').on('change', function () {
        if (isValidEmail($('#correo'))) {
            $('#error-correo').hide();

        } else {
            $('#error-correo').show();

        }
    });

    $("#password").on('change', function () {
        if (isValidPassword($(this)))
            $("#error-contrasena").hide();
        else
            $("#error-contrasena").show();
    });

    $("#password2").on('change', function () {
        var pass1 = $('#password');
        var pass2 = $(this);

        areEqualPasswords(pass1, pass2);
    });


    /////////////////////////////// GESTION MEDICOS ////// 

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
    $('#errorEditarPosicion').hide(); //SHANNON



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

    //////////////////////////////////////////////////////
    /////////////////// VALIDACIONES AGREGAR MEDICO //////
    //////////////////////////////////////////////////////
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
    /*
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
     
     });*/

    var isValidAddEspecialidad;
    var dato2 = $("#agregar-especialidadMedico");

    dato2.on('keyup', function (e) {
        var option = $('#listEspecialidades option').filter(function () {
            return this.value === $("#agregar-especialidadMedico").val();
        }).val();

        if (option) {
            $('#errorAgregarEspecialidad').hide();
            dato2.css('border', '');
            dato2.css('color', '');
            isValidAddEspecialidad = true;
        } else if (dato2.val() == '') {
            $('#errorAgregarEspecialidad').hide();
            dato2.css('border', '');
            dato2.css('color', '');
            isValidAddEspecialidad = false;
        } else {
            $('#errorAgregarEspecialidad').show();
            dato2.css('border', '1px solid red');
            dato2.css('color', 'red');
            isValidAddEspecialidad = false;
        }
    });

    var isValidAddPosicion;
    var dato = $("#agregar-posiciondMedico");

    dato.on('keyup', function (e) {
        var option = $('#listPosiciones option').filter(function () {
            return this.value === $("#agregar-posiciondMedico").val();
        }).val();

        if (option) {
            $('#errorAgregarPosicion').hide();
            dato.css('border', '');
            dato.css('color', '');
            isValidAddPosicion = true;
        } else if (dato.val() == '') {
            $('#errorAgregarPosicion').hide();
            dato.css('border', '');
            dato.css('color', '');
            isValidAddPosicion = false;
        } else {
            $('#errorAgregarPosicion').show();
            dato.css('border', '1px solid red');
            dato.css('color', 'red');
            isValidAddPosicion = false;
        }
    });

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


    //////////////////////////////////////////////////////
    ///////////////// VALIDACIONES AGREGAR PACIENTE //////
    //////////////////////////////////////////////////////
    //NOMBRE EN AGREGAR PACIENTE
    $('#nombrePaciente').on('change', function () {

        if (isValidName($(this))) {
            $('#errorNombrePaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorNombrePaciente').hide();
        } else {
            $('#errorNombrePaciente').show();
        }

    });

    //PRIMER APELLIDO EN AGREGAR PACIENTE
    $('#primer-apellidoPaciente').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoPaternoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoPaternoPaciente').hide();
        } else {
            $('#errorApellidoPaternoPaciente').show();
        }

    });

    //SEGUNDO APELLIDO EN AGREGAR PACIENTE
    $('#segundo-apellidoPaciente').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoMaternoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoMaternoPaciente').hide();
        } else {
            $('#errorApellidoMaternoPaciente').show();
        }

    });

    //NOMBRE DE USUARIO EN AGREGAR PACIENTE
    $('#usuarioPaciente').on('change', function () {

        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteUsuario",
                usuario: $('#usuarioPaciente').val()


            },
            success: function (response) {

                if (response == 'UsuarioAlreadyExists') {
                    $('#usuarioPaciente').css('color', 'orange');
                    $('#errorUsuarioRepetidoPaciente').show();
                } else {
                    $('#errorUsuarioRepetidoPaciente').hide();
                }

            }

        });

        if (isValidUserName($(this))) {
            $('#errorNombreUsuarioPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreUsuarioPaciente').hide();
        } else {
            $('#errorNombreUsuarioPaciente').show();
        }

    });


    //CORREO EN AGREGAR PACIENTE
    $('#correoPaciente').on('change', function () {

        if (isValidEmail($(this))) {
            $('#errorCorreoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreoPaciente').hide();
        } else {
            $('#errorCorreoPaciente').show();
        }

    });

    //CONTRASEÑA1 EN AGREGAR PACIENTE
    $('#contraPaciente').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass1Paciente').hide();
        } else if ($(this).val() == '') {
            $('#errorPass1Paciente').hide();
        } else {
            $('#errorPass1Paciente').show();
        }

    });

    //CONTRASEÑA2 EN AGREGAR PACIENTE
    $('#confContraPaciente').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass2Paciente').hide();
        } else if ($(this).val() == '') {
            $('#errorPass2Paciente').hide();
        } else {
            $('#errorPass2Paciente').show();
        }

    });

    //CURP EN AGREGAR PACIENTE
    $('#curpPaciente').on('change', function () {

        $.ajax({
            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {
                key: "repiteCurp",
                curp: $('#curpPaciente').val()
            },
            success: function (response) {

                if (response === 'CurpAlreadyExists') {
                    $('#curpPaciente').css('color', 'orange');
                    $('#errorCurpRepetidoPaciente').show();
                } else {
                    $('#errorCurpRepetidoPaciente').hide();
                }
            }
        });

        if (isValidCURP($(this))) {
            $('#errorCurpPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorCurpPaciente').hide();
        } else {
            $('#errorCurpPaciente').show();
        }
    });

    //TELEFONO EN AGREGAR PACIENTE
    $('#telPaciente').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorTelefonoPaciente').hide();
        } else if ($(this).val() == '') {
            $('#errorTelefonoPaciente').hide();
        } else {
            $('#errorTelefonoPaciente').show();
        }

    });

    //ESTADO CIVIL EN AGREGAR PACIENTE
    $('#estado-civilPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#errorECivilPaciente').hide();
        } else {
            $('#errorECivilPaciente').show();
        }

    });

    //FECHA DE NACIMIENTO EN AGREGAR PACIENTE
    $('#cumplePaciente').on('change', function () {

        if (isValidDate($(this))) {
            $('#errorFechaPaciente').hide();
        } else {
            $('#errorFechaPaciente').show();
        }

    });

    //ESTADO EN AGREGAR PACIENTE
    $('#estadoPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#errorEstadoPaciente').hide();
        } else {
            $('#errorEstadoPaciente').show();
        }

    });

    //MUNICIPIO EN AGREGAR PACIENTE
    $('#municipioPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#errorMunicipioPaciente').hide();
        } else {
            $('#errorMunicipioPaciente').show();
        }

    });

    //COLONIA EN AGREGAR PACIENTE
    $('#colPaciente').on('change', function () {

        if (isValidColonia($(this))) {
            $('#errorColoniaPaciente').hide();
        } else {
            $('#errorColoniaPaciente').show();
        }

    });

    //CALLE EN AGREGAR PACIENTE
    $('#callePaciente').on('change', function () {

        if (isValidStreet($(this))) {
            $('#errorCallePaciente').hide();
        } else {
            $('#errorCallePaciente').show();
        }

    });

    //NUMERO EXTERIOR EN AGREGAR PACIENTE
    $('#numExtPaciente').on('change', function () {

        if (isValidExtNumber($(this))) {
            $('#errorNoExteriorPaciente').hide();
        } else {
            $('#errorNoExteriorPaciente').show();
        }

    });

    //NUMERO INTERIOR EN AGREGAR PACIENTE
    $('#numIntPaciente').on('change', function () {

        if (isValidIntNumber($(this))) {
            $('#errorNoInteriorPaciente').hide();
        } else {
            $('#errorNoInteriorPaciente').show();
        }


    });

    //////////////////////////////////////////////////////
    /////////////////////////////// GESTION MEDICOS ////// 
    //////////////////////////////////////////////////////
    /**AGREGAR MEDICO */
    $('#btn-agregarMedico').on('click', function () {
        if (!repiteCorreo) {

            $("#error-datosRepetidos").hide();

            if (isValidName($('#agregar-nombreMedico')) && isValidLastName($('#agregar-primerApellidoMedico')) && $('#errorApellidoMaternoMedico').hide() && $('#errorCedulaMedicos').hide()
                    && isValidNumEmpleado($('#agregar-noEmpleadoMedico')) && isValidEmail($('#agregar-correoMedico')) && isValidPassword($('#agregar-passwordMedico'))
                    && isValidPhoneNumber($('#agregar-telefonoMedico')) && isValidCheckbox($('#terminosMedico')) && isValidAddEspecialidad && isValidAddPosicion
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

                configureLoadingScreen($('.cargandoAgregarMedico'));
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
                        $("#terminosMedico").prop("checked", false);

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
            $("#error-campos").hide();
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
                $('#editar-posicionMedico').val(json.nombrePosicion); //SHANNON
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

        configureLoadingScreen($('.cargandoEditarMedico'));
        
        if (!repiteCorreo) {
            $("#error-editarDatosRepetidos").hide();

            if (isValidName($('#editar-nombreMedico')) && isValidLastName($('#editar-primerApellidoMedico')) && $('#errorApellidoMaternoMedico').hide() && $('#errorCedulaMedicos').hide()
                    && isValidNumEmpleado($('#editar-noEmpleadoMedico')) && isValidEmail($('#editar-correoMedico'))
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
                var posicion = $('#editar-posicionMedico').val();
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
                        posicion: posicion,
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

    //Errores al agregar a una navegadora
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


    //Errores al editar a una navegadora VICTOR
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

    //////////////////////////////////////////////////////
    /////////////////// VALIDACIONES EDITAR NAVEGADORA ///
    //////////////////////////////////////////////////////

    //TELEFONO EN EDITAR NAVEGADORA
    $('#editar-telefonoNavegadora').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorEditarTelefonoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarTelefonoNavegadora').hide();
        } else {
            $('#errorEditarTelefonoNavegadora').show();
        }

    });

    //CÉDULA PROFESIONAL EN EDITAR MÉDICO
    $('#editar-cedulaProfesionalNavegadora').on('change', function () {

        if (isValidCedula($(this))) {
            $('#errorEditarCedulaNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarCedulaNavegadora').hide();
        } else {
            $('#errorEditarCedulaNavegadora').show();
        }

    });

    //NÚMERO DE EMPLEADO EN EDITAR NAVEGADORA
    $('#editar-noEmpleadoNavegadora').on('change', function () {

        if (isValidNumEmpleado($(this))) {
            $('#errorEditarNumNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarNumNavegadora').hide();
        } else {
            $('#errorEditarNumNavegadora').show();
        }

    });

    //NOMBRE EN EDITAR NAVEGADORA
    $('#editar-nombreNavegadora').on('change', function () {

        if (isValidName($(this))) {
            $('#errorEditarNombreNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarNombreNavegadora').hide();
        } else {
            $('#errorEditarNombreNavegadora').show();
        }
    });

    //PRIMER APELLIDO EN EDITAR NAVEGADORA
    $('#editar-primerApellidoNavegadora').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorEditarApellidoPaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarApellidoPaternoNavegadora').hide();
        } else {
            $('#errorEditarApellidoPaternoNavegadora').show();
        }

    });

    //SEGUNDO APELLIDO EN EDITAR NAVEGADORA
    $('#editar-segundoApellidoNavegadora').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorEditarApellidoMaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarApellidoMaternoNavegadora').hide();
        } else {
            $('#errorEditarApellidoMaternoNavegadora').show();
        }

    });

    $('#editar-correoNavegadora').on('change', function () {
        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteCorreo",
                correo: $('#editar-correoNavegadora').val()


            },
            success: function (response) {

                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#editar-correoNavegadora').css('color', 'orange');
                    $('#errorEditarCorreoRepetidoNavegadora').show();
                    repiteCorreoNavegadora = true;
                } else {
                    $('#errorEditarCorreoRepetidoNavegadora').hide();
                    repiteCorreoNavegadora = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#errorEditarCorreoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorEditarCorreoNavegadora').hide();
        } else {
            $('#errorEditarCorreoNavegadora').show();
        }

    });


    //////////////////////////////////////////////////////
    /////////////////// VALIDACIONES AGREGAR NAVEGADORA //
    //////////////////////////////////////////////////////

    //TELEFONO EN AGREGAR NAVEGADORA
    $('#agregar-telefonoNavegadora').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorTelefonoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorTelefonoNavegadora').hide();
        } else {
            $('#errorTelefonoNavegadora').show();
        }

    });

    //CÉDULA PROFESIONAL EN AGREGAR NAVEGADORA
    $('#agregar-cedulaNavegadora').on('change', function () {

        if (isValidCedula($(this))) {
            $('#errorCedulaNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorCedulaNavegadora').hide();
        } else {
            $('#errorCedulaNavegadora').show();
        }

    });

    //NÚMERO DE EMPLEADO EN AGREGAR NAVEGADORA
    $('#agregar-noEmpleadoNavegadora').on('change', function () {

        if (isValidNumEmpleado($(this))) {
            $('#errorNumEmpleadoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorNumEmpleadoNavegadora').hide();
        } else {
            $('#errorNumEmpleadoNavegadora').show();
        }

    });

    //ESPECIALIDAD EN AGREGAR NAVEGADORA
    $('#agregar-especialidadNavegadora').on('change', function () {

        if (isValidEspecialidad($(this))) {
            $('#errorAgregarEspecialidadNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorAgregarEspecialidadNavegadora').hide();
        } else {
            $('#errorAgregarEspecialidadNavegadora').show();
        }

    });

    //NOMBRE EN AGREGAR NAVEGADORA
    $('#agregar-nombreNavegadora').on('change', function () {

        if (isValidName($(this))) {
            $('#errorNombreNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreNavegadora').hide();
        } else {
            $('#errorNombreNavegadora').show();
        }
    });

    //PRIMER APELLIDO EN AGREGAR NAVEGADORA
    $('#agregar-primerApellidoNavegadora').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoPaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoPaternoNavegadora').hide();
        } else {
            $('#errorApellidoPaternoNavegadora').show();
        }

    });

    //SEGUNDO APELLIDO EN AGREGAR NAVEGADORA
    $('#agregar-segundoApellidoNavegadora').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoMaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoMaternoNavegadora').hide();
        } else {
            $('#errorApellidoMaternoNavegadora').show();
        }

    });

    //CONTRASEÑA EN AGREGAR NAVEGADORA
    $('#agregar-passwordNavegadora').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass1Navegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorPass1Navegadora').hide();
        } else {
            $('#errorPass1Navegadora').show();
        }

    });


    //CONTRASEÑAS IGUALES EN AGREGAR NAVEGADORA
    $('#agregar-password2Navegadora').on('change', function () {

        var pass1 = $('#agregar-passwordNavegadora');
        var pass2 = $('#agregar-password2Navegadora');

        areEqualPasswords(pass1, pass2);

    });

    var repiteCorreoNavegadora;

    $('#agregar-correoNavegadora').on('change', function () {
        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteCorreo",
                correo: $('#agregar-correoNavegadora').val()


            },
            success: function (response) {

                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#agregar-correoNavegadora').css('color', 'orange');
                    $('#errorCorreoRepetidoNavegadora').show();
                    repiteCorreoNavegadora = true;
                } else {
                    $('#errorCorreoRepetidoNavegadora').hide();
                    repiteCorreoNavegadora = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#errorCorreoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreoNavegadora').hide();
        } else {
            $('#errorCorreoNavegadora').show();
        }

    });

    /**AGREGAR NAVEGADORA*/
    $('#btn-agregarNavegadora').on('click', function () {
        if (!repiteCorreoNavegadora) {

            $("#error-datosRepetidosNavegadora").hide();

            if (isValidName($('#agregar-nombreNavegadora')) && isValidLastName($('#agregar-primerApellidoNavegadora')) && $('#errorApellidoMaternoNavegadora').hide() && $('#errorCedulaNavegadora').hide()
                    && isValidNumEmpleado($('#agregar-noEmpleadoNavegadora')) && isValidEmail($('#agregar-correoNavegadora')) && isValidPassword($('#agregar-passwordNavegadora'))
                    && isValidPhoneNumber($('#agregar-telefonoNavegadora')) && isValidCheckbox($('#terminosNavegadora')) && isValidEspecialidad($('#agregar-especialidadNavegadora'))
                    && areEqualPasswords($('#agregar-passwordNavegadora'), $('#agregar-password2Navegadora')) && $('#errorCorreoRepetidoNavegadora').hide()) {

                $("#error-camposNavegadora").hide();

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

                //configureLoadingScreen($('.cargandoAgregarNavegadora'));
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
                        swal({
                            title: "¡Buen trabajo!",
                            text: "Se ha agregado correctamente a la navegadora.",
                            icon: "success",
                            buttons: [, 'Aceptar'],
                        });

                        //Limpiar los campos después de registrarse 

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

                        //Cerrar el modal
                        $('#modalAgregarNavegadora').modal('toggle');
                    }
                });
            } else {
                console.log("Entro al segundo else");
                $("#error-camposNavegadora").show(); //No se llenaron los campos obligatorios
            }
        } else {
            console.log("Entro al segundo else");
            $("#error-datosRepetidosNavegadora").show(); //ya existe un campo
            $("#error-camposNavegadora").hide();
        }
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

    //GUARDA LA NAVEGADORA DESDE EL MODAL ELIZABETH
    $('#btn-guardarNavegadora').on('click', function () {

        if (!repiteCorreoNavegadora) {
            $("#error-editarDatosRepetidosNavegadora").hide();

            if (isValidName($('#editar-nombreNavegadora')) && isValidLastName($('#editar-primerApellidoNavegadora')) && $('#errorApellidoMaternoNavegadora').hide() && $('#errorCedulaNavegadora').hide()
                    && isValidNumEmpleado($('#editar-no-empleadoNavegadora')) && isValidEmail($('#editar-correoNavegadora'))
                    && isValidPhoneNumber($('#editar-telefonoNavegadora')) && isValidEspecialidad($('#editar-especialidad'))
                    && $('#errorCorreoRepetidoNavegadora').hide()) {

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
                //configureLoadingScreen($('.cargandoEditarNavegadora'));
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

            } else {
                console.log("Entro al segundo else");
                $("#error-datosRepetidosNavegadora").show(); //ya existe un campo
            }
        }
    });


    /** ELIMINAR NAVEGADORA */
    $('body').on('click', '#btn-eliminarNavegadora', function () {

        var idNavegadora = $(this).data('id');

        //Modal editar medicos
        swal({
            title: "¿Estás seguro?",
            text: "Los datos se eliminarán y no podrás recuperarlos.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((eliminar) => {
                    if (eliminar) {

                        $.ajax({

                            url: 'AdministradorController',
                            cache: false,
                            method: 'POST',
                            data: {
                                key: 'eliminarNavegadora',
                                idCuenta: idNavegadora
                            },
                            success: function (response) {
                                if (response == "error") {
                                    alert("Error al cargar");
                                } else {
                                    console.log("Intentando redireccionar");
                                    document.open("text/html", "replace");
                                    document.write(response);
                                    document.close();
                                }
                            },
                            error: function (xhr) {

                            }


                        });

                    } else {

                    }
                });

    });

    //////////////////////////////////////////////////////
    ///////////////////////////// GESTION PACIENTES //////
    //////////////////////////////////////////////////////
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

function configureLoadingScreen(screen) {
    $(document)
            .ajaxStart(function () {
                screen.fadeIn();
            })
            .ajaxStop(function () {
                screen.fadeOut();
            })
}