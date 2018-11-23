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

    function isValidEmail(input) {

        var m = input.val();

        ////Expresion regular por el estandard: RFC 5322
        var expreg = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;

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

    function isValidPassword(input) {

        var m = input.val();

        //var expreg = /^[a-zA-Z0-9]{8,14}$/;
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
        ;

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
                $('#editar-usuarioMedico').val(json.usuario);
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
        var usuario = $('#editar-usuarioMedico').val();



        console.log("idMédicoooo " + idMedico);
        console.log("nombre " + nombre);
        console.log("phone " + telefono);
        console.log("ape 1 " + primerApellido);
        console.log("ape 2 " + segundoApellido);
        console.log("mail " + correo);
        console.log("empleado no " + noEmpleado);
        console.log("especiliad  " + especialidad);
        console.log("usuario " + usuario);
        console.log("cedula " + cedula);



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
                usuario: usuario,
                cedula: cedula
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

                console.log(response);
            }
        })
                .done(function (response) {


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
                $('#editar-usuario').val(response.usuario);

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


        $.ajax({

            url: 'AdministradorController',
            cache: false,
            method: 'POST',
            data: {
                key: 'actualiza-navegadora',
                idNavegadora: idNavegadora.val(),
                nombre: nombre.val(),
                telefono: telefono.val(),
                primerApellido: primerApellido.val(),
                segundoApellido: segundoApellido.val(),
                correo: correo.val(),
                noEmpleado: noEmpleado.val(),
                especialidad: especialidad.val(),
                usuario: usuario.val(),
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
});