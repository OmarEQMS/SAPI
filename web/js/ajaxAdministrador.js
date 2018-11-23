$(document).ready(function () {

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

    /*ESTADO CIVIL EN EL REGISTRO
     $('#estadoCivil').on('change', function () {
     
     if (isValidSelect($(this))) {
     $('#errorECivil').hide();
     } else {
     $('#errorECivil').show();
     }
     
     });*/

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

<<<<<<< HEAD
||||||| merged common ancestors
        var nombre = $('#editar-nombreNavegadora');
        var telefono = $('#editar-telefonoNavegadora');
        var primerApellido = $('#editar-primerApellidoNavegadora');
        var segundoApellido = $('#editar-segundoApellidoNavegadora');
        var correo = $('#editar-correoNavegadora');
        var noEmpleado = $('#editar-no-empleadoNavegadora');
        var especialidad = $('#editar-especialidad');
        var usuario = $('#editar-usuario');
        
        console.log(idNavegadora.val());
        console.log(nombre.val());
        console.log(telefono.val());
        console.log(primerApellido.val());
        console.log(segundoApellido.val());
        console.log(correo.val());
        console.log(noEmpleado.val());
        console.log(especialidad.val());
        console.log(usuario.val());
        
=======
        var nombre = $('#editar-nombreNavegadora');
        var telefono = $('#editar-telefonoNavegadora');
        var primerApellido = $('#editar-primerApellidoNavegadora');
        var segundoApellido = $('#editar-segundoApellidoNavegadora');
        var correo = $('#editar-correoNavegadora');
        var noEmpleado = $('#editar-no-empleadoNavegadora');
        var especialidad = $('#editar-especialidad');
        var usuario = $('#editar-usuario');

        console.log(idNavegadora.val());
        console.log(nombre.val());
        console.log(telefono.val());
        console.log(primerApellido.val());
        console.log(segundoApellido.val());
        console.log(correo.val());
        console.log(noEmpleado.val());
        console.log(especialidad.val());
        console.log(usuario.val());

>>>>>>> origin/MontoyaRosas

        $.ajax({

            url: 'AdministradorController',
            cache: false,
            method: 'POST',
            data: {
                key: 'actualiza-navegadora',
<<<<<<< HEAD
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
||||||| merged common ancestors
                idNavegadora: idNavegadora.val(),
                nombre: nombre.val(),
                telefono: telefono.val(),
                primerApellido: primerApellido.val(),
                segundoApellido: segundoApellido.val(),
                correo: correo.val(),
                noEmpleado: noEmpleado.val(),
                especialidad: especialidad.val(),                
                usuario: usuario.val(),                
=======
                idNavegadora: idNavegadora.val(),
                nombre: nombre.val(),
                telefono: telefono.val(),
                primerApellido: primerApellido.val(),
                segundoApellido: segundoApellido.val(),
                correo: correo.val(),
                noEmpleado: noEmpleado.val(),
                especialidad: especialidad.val(),
                usuario: usuario.val(),
>>>>>>> origin/MontoyaRosas
            }
<<<<<<< HEAD
        });
||||||| merged common ancestors
        })
            .done(function (response) {


            });
=======
        })
                .done(function (response) {


                });
>>>>>>> origin/MontoyaRosas

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
<<<<<<< HEAD
        cache: false,
        method: 'POST',
        data: {key: "autocompletarPosiciones"}
    })
||||||| merged common ancestors
                cache: false,
                method: 'POST',
                data: {key: "autocompletarPosiciones"}
        })
=======
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
>>>>>>> origin/MontoyaRosas

<<<<<<< HEAD
            .done(function (response) {

                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {

                    var newObjeto = $('<option value="' + json[i].nombre + '"></option>');
                    posiciones.append(newObjeto);
                }


                console.log(JSON.stringify(posiciones));

            });
||||||| merged common ancestors
        .done(function (response) {
       
            var json = JSON.parse(response);
            for (var i = 0; i < json.length; i++) {
                                      
                   var newObjeto = $('<option value="'+json[i].nombre+'"></option>');                                      
                   posiciones.append(newObjeto);
            }
    
       
        console.log(JSON.stringify(posiciones));
       
        });
=======
>>>>>>> origin/MontoyaRosas
});