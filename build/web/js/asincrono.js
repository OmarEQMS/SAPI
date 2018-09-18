import {validation} from './validaciones.js';

$(document).ready(function () {


    //Esconder mensajes de error
    $('#msj-error').hide();
    $('#noEqualPasswordsError').hide();
    $('#errorNombre').hide();
    $('#errorApellidoPaterno').hide();
    $('#errorApellidoMaterno').hide();
    $('#errorNombreUsuario').hide();
    $('#errorCorreo').hide();
    $('#errorPass1').hide();
    $('#errorPass2').hide();
    $('#errorCurp').hide();
    $('#errorCodigoPostal').hide();
    $('#errorTelefono').hide();
    $('#errorECivil').hide();
    $('#errorFecha').hide();
    $('#errorEstado').hide();
    $('#errorMunicipio').hide();
    $('#errorColonia').hide();
    $('#errorCalle').hide();
    $('#errorNoExterior').hide();
    $('#errorNoInterior').hide();
    $('#errorUsuarioRepetido').hide();

    $('#btn-registro').on('click', function () {

        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {
                key: "registraUsuario",
                nombre: $('#nombre').val(),
                apellido1: $('#apellido1').val(),
                apellido2: $('#apellido2').val(),
                usuario: $("#usuario").val(),
                correo: $('#correo').val(),
                curp: $('#curp').val(),
                colonia: $('#colonia').val(),
                calle: $('#calle').val(),
                noExterior: $("#noExterior").val(),
                noInterior: $("#noInterior").val(),
                pass1: $("#pass1").val(),
                pass2: $("#pass2").val(),
                telefono: $("#telefono").val(),
                estadoCivil: $("#estadoCivil").val(),
                fechaNacimiento: $("#fechaNacimiento").val(),
                estado: $("#estado").val(),
                municipio: $("#municipio").val(),
                codigoPostal: $('#codigoPostal').val()


            }

        })
                .done(function (response) {
                    console.log(response);


                    swal({
                        title: 'Buen Trabajo',
                        text: "Cuenta registrada correctamente",
                        type: 'success',
                        confirmButtonColor: '#3085d6',
                        confirmButtonText: 'Ok'
                    }).then((result) => {
                        if (result.value) {
                            window.location.reload();
                        };
                    });
                })
                .fail(function (xhr, textStatus, errorThrown) {
                    console.log(xhr.responseText);
                });


    });


    //Cargar los municipios con base en el estado
    $('#estado').on('change', function () {

        $.ajax({

            url: 'ZonaController',
            cache: false,
            method: 'POST',
            data: {

                key: "getByEstado",
                idEstado: $('#estado').val()

            },
            success: function (response) {

                //Limpiar el select antes de que haga una consulta para que no se emapalmen los municipios
                $(".municipios select").each(function () {
                    $(this).children().remove();
                });

                var json = JSON.parse(response);

                for (var i = 0; i < json.length; i++) {
                    $('.municipios select').append("<option value=" + json[i].idMunicipio + ">" + json[i].nombre + "</option>");
                }

                $('.municipios select').prop('selectedIndex', 0);

                console.log(json);

            }

        });


    });


    //Verificar que las contraseñas sean iguales
    $('#pass2').on('change', function () {

        var pass1 = $('#pass1');
        var pass2 = $('#pass2');

        areEqualPasswords(pass1, pass2);

    });

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

    //////////////////////////////////VALIDACIONES

    //1.- NOMBRE
    $('#nombre').on('change', function () {

        if (validation.isValidName($(this))) {
            $('#errorNombre').hide();
        } else if ($(this).val() == '') {
            $('#errorNombre').hide();
        } else {
            $('#errorNombre').show();
        }

    });

    //2.- APELLIDO PATERNO
    $('#apellido1').on('change', function () {

        if (validation.isValidLastName($(this))) {
            $('#errorApellidoPaterno').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoPaterno').hide();
        } else {
            $('#errorApellidoPaterno').show();
        }

    });

    //3.- APELLIDO MATERNO
    $('#apellido2').on('change', function () {

        if (validation.isValidLastName($(this))) {
            $('#errorApellidoMaterno').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoMaterno').hide();
        } else {
            $('#errorApellidoMaterno').show();
        }

    });

    //4.- NOMBRE DE USUARIO
    $('#usuario').on('change', function () {
        
        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteUsuario",
                usuario: $('#usuario').val()
                

            },
            success: function (response) {                

                if(response==='UsuarioAlreadyExists'){
                    $('#usuario').css('color', 'orange');
                    $('#errorUsuarioRepetido').show();
                }else{
                    $('#errorUsuarioRepetido').hide();
                }

            }

        });

        if (validation.isValidLastName($(this))) {
            $('#errorNombreUsuario').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreUsuario').hide();
        } else {
            $('#errorNombreUsuario').show();
        }

    });

    //5.- CORREO
    $('#correo').on('change', function () {

        if (validation.isValidEmail($(this))) {
            $('#errorCorreo').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreo').hide();
        } else {
            $('#errorCorreo').show();
        }

    });

    //6.- CONTRASEÑA1
    $('#pass1').on('change', function () {

        if (validation.isValidPassword($(this))) {
            $('#errorPass1').hide();
        } else if ($(this).val() == '') {
            $('#errorPass1').hide();
        } else {
            $('#errorPass1').show();
        }

    });

    //7.- CONTRASEÑA2
    $('#pass2').on('change', function () {

        if (validation.isValidPassword($(this))) {
            $('#errorPass2').hide();
        } else if ($(this).val() == '') {
            $('#errorPass2').hide();
        } else {
            $('#errorPass2').show();
        }

    });

    //8.- CURP
    $('#curp').on('change', function () {

        if (validation.isValidCURP($(this))) {
            $('#errorCurp').hide();
        } else if ($(this).val() == '') {
            $('#errorCurp').hide();
        } else {
            $('#errorCurp').show();
        }

    });

    //9.- CODIGO POSTAL
    $('#codigoPostal').on('change', function () {

        $.ajax({

            url: 'ZonaController',
            cache: false,
            method: 'POST',
            data: {

                key: "getEstadoyMunicipio",
                numeroCP: $('#codigoPostal').val()

            },
            success: function (response) {

                var json = JSON.parse(response);

                if ($('#codigoPostal').val().length === 5) {

                    //Limpia los campos 
                    $("#estado").each(function () {
                        $(this).children().remove();
                    });

                    $("#municipio").each(function () {
                        $(this).children().remove();
                    });

                    //Carga estado
                    $('#estado').append("<option value='" + json[0] + "'>" + json[1] + "</option>");

                    //Carga Municipio
                    $('#municipio').append("<option value='" + json[2] + "'>" + json[3] + "</option>");

                } else {

                    $('#estado').removeAttr('disabled');
                    $('#estado').removeAttr('selected');



                }

                console.log(json);

            }

        });


    });

    //10.- TELEFONO
    $('#telefono').on('change', function () {

        if (validation.isValidPhoneNumber($(this))) {
            $('#errorTelefono').hide();
        } else if ($(this).val() == '') {
            $('#errorTelefono').hide();
        } else {
            $('#errorTelefono').show();
        }

    });

    //11.- ESTADO CIVIL
    $('#estadoCivil').on('change', function () {

        if (validation.isValidSelect($(this))) {
            $('#errorECivil').hide();
        } else {
            $('#errorECivil').show();
        }

    });

    //12.- FECHA
    $('#fechaNacimiento').on('change', function () {

        if (validation.isValidDate($(this))) {
            $('#errorFecha').hide();
        } else {
            $('#errorFecha').show();
        }

    });

    //12.- ESTADO
    $('#estado').on('change', function () {

        if (validation.isValidSelect($(this))) {
            $('#errorEstado').hide();
        } else {
            $('#errorEstado').show();
        }

    });

    //13.- MUNICIPIO
    $('#municipio').on('change', function () {

        if (validation.isValidSelect($(this))) {
            $('#errorMunicipio').hide();
        } else {
            $('#errorMunicipio').show();
        }

    });

    //13.- COLONIA
    $('#colonia').on('change', function () {

        if (validation.isValidColonia($(this))) {
            $('#errorColonia').hide();
        } else {
            $('#errorColonia').show();
        }

    });

    //14.- CALLE
    $('#calle').on('change', function () {

        if (validation.isValidStreet($(this))) {
            $('#errorCalle').hide();
        } else {
            $('#errorCalle').show();
        }

    });

    //15.- NUMERO EXTERIOR
    $('#noExterior').on('change', function () {

        if (validation.isValidNumber($(this))) {
            $('#errorNoExterior').hide();
        } else {
            $('#errorNoExterior').show();
        }

    });

    //16.- NUMERO INTERIOR
    $('#noInterior').on('change', function () {

        if (validation.isValidNumber($(this))) {
            $('#errorNoInterior').hide();
        } else {
            $('#errorNoInterior').show();
        }

    });
    
    ///////////////////////////////////////////////LOGIN
    $('#btn-login').on('click', function () {

        var usuario = $('#user');
        var password = $('#password');

        $.ajax({

            url: 'LoginController',
            cache: false,
            method: 'POST',
            data: {
                key: 'verificar',
                usuario: usuario.val(),
                password: password.val()
            },
            success: function (response) {

                if (response == 'success') {

                    $('#msj-error').hide();

                } else {
                    $('#msj-error').show();
                }


            }


        });

    });


});