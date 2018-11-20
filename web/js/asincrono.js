$(document).ready(function () {


    //Esconder mensajes de error
    $('#msj-error').hide();
    $('#error-terminos').hide();
    $('#noEqualPasswordsError').hide();
    $('#errorNombre').hide();
    $('#errorApellidoPaterno').hide();
    $('#errorApellidoMaterno').hide();
    $('#errorNombreUsuario').hide();
    $('#errorCorreo').hide();
    $('#errorPass1').hide();
    $('#errorPass2').hide();
    $('#errorCurp').hide();
    $('#errorCurpRepetido').hide();
    $('#errorCodigoPostal').hide();
    $('#error-CPexiste').hide();
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

    $('#errorCorreoRepetido').hide();
    $('#error-terminos').hide();
    $('#error-CPexiste').hide();

    $("#error-campos").hide();
    $("#error-datosRepetidos").hide();

    var repiteUsuario;
    var repiteCURP;
    var repiteCorreo;

    $('#btn-registro').on('click', function () {

        if (!repiteUsuario && !repiteCURP && !repiteCorreo) {
            $("#error-datosRepetidos").hide();
            //Verificar que todos los campos que han marcado
            if (isValidName($('#nombre')) && isValidLastName($('#apellido1')) && isValidUserName($('#usuario')) && isValidEmail($('#correo')) && isValidPassword($('#pass1')) && isValidCURP($('#curp')) && isValidPhoneNumber($('#telefono')) && isValidDate($('#fechaNacimiento')) && isValidSelect($('#estado')) && isValidSelect($('#municipio')) && $('#errorCorreoRepetido').hide()) {
                $("#error-campos").hide();

                swal(
                        "¿Te han tratado por cáncer de mama previamente?", {
                            buttons: {
                                primeraVez: "No",
                                segundaOpinion: "Sí",
                            }
                        })
                        .then((value) => {
                            switch (value) {
                                case "primeraVez":
                                    $('#tipoPaciente').val(0);
                                    break;
                                case "segundaOpinion":
                                    $('#tipoPaciente').val(1);
                                    break;
                            }

                            console.log($('#tipoPaciente').val());
                            $('#modalTerminos').modal('toggle');
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

    $('#btnAceptar').on('click', function () {

        if (!isValidCheckbox($('#acepto-datos')) || !isValidCheckbox($('#acepto-datos-anonimos'))) {

            $('#error-terminos').show();

        } else {

            $('#error-terminos').hide();

            //ajax para registrar

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
                    codigoPostal: $('#codigoPostal').val(),
                    tipoPaciente: $('#tipoPaciente').val()


                }

            })
                    .done(function (response) {
                        console.log(response);

                        swal({
                            title: 'Buen Trabajo',
                            text: "Cuenta registrada correctamente.",
                            icon: "success",
                            confirmButtonColor: '#3085d6',
                            buttons: [, 'Aceptar']
                        })
                                .then(function () {
                                    console.log("Redirección a login");
                                    $.get("LoginController", {
                                        key: "ir-a-login"
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
                    })
                    .fail(function (xhr, textStatus, errorThrown) {
                        console.log(xhr.responseText);
                    });
        }

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


    //CONTRASEÑAS IGUALES EN EL REGISTRO
    $('#pass2').on('change', function () {

        var pass1 = $('#pass1');
        var pass2 = $('#pass2');

        areEqualPasswords(pass1, pass2);

    });
    
    $('#codigoPostal').on('change',function(){
        
        if (isValidFormatCP($(this))) {
            $('#errorCodigoPostal').hide();
        }  else {
            $('#errorCodigoPostal').show();
        }
        
    })

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


    //CONTRASEÑAS IGUALES DE RECUPERAR CONTRASEÑA
    $('#cambio2').on('change', function () {

        var pass1 = $('#cambio1');
        var pass2 = $('#cambio2');

        areEqualPasswords(pass1, pass2);

    });


    //////////////////////////////////VALIDACIONES

    //NOMBRE EN EL REGISTRO
    $('#nombre').on('change', function () {

        if (isValidName($(this))) {
            $('#errorNombre').hide();
        } else if ($(this).val() == '') {
            $('#errorNombre').hide();
        } else {
            $('#errorNombre').show();
        }

    });

    //PRIMER APELLIDO EN EL REGISTRO
    $('#apellido1').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoPaterno').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoPaterno').hide();
        } else {
            $('#errorApellidoPaterno').show();
        }

    });

    //SEGUNDO APELLIDO EN EL REGISTRO
    $('#apellido2').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoMaterno').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoMaterno').hide();
        } else {
            $('#errorApellidoMaterno').show();
        }

    });

    //NOMBRE DE USUARIO EN EL REGISTRO
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
                if (response === 'UsuarioAlreadyExists') {
                    $('#usuario').css('color', 'orange');
                    $('#errorUsuarioRepetido').show();
                    repiteUsuario = true;
                } else {
                    $('#errorUsuarioRepetido').hide();
                    repiteUsuario = false;
                }

            }

        });

        if (isValidUserName($(this))) {
            $('#errorNombreUsuario').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreUsuario').hide();
        } else {
            $('#errorNombreUsuario').show();
        }

    });

    //CORREO EN EL REGISTRO
    $('#correo').on('change', function () {
        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteCorreo",
                correo: $('#correo').val()


            },
            success: function (response) {

                if (response === 'CorreoAlreadyExists') {
                    console.log("correo repetidooo")
                    $('#correo').css('color', 'orange');
                    $('#errorCorreoRepetido').show();
                    repiteCorreo = true;
                } else {
                    $('#errorCorreoRepetido').hide();
                    repiteCorreo = false;
                }

            }

        });

        if (isValidEmail($(this))) {
            $('#errorCorreo').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreo').hide();
        } else {
            $('#errorCorreo').show();
        }

    });

    //CORREO EN RECUPERAR CONTRASEÑA
    $('#email').on('change', function () {

        if (isValidEmail($(this))) {
            $('#errorCorreo').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreo').hide();
        } else {
            $('#errorCorreo').show();
        }

    });

    //CONTRASEÑA1 EN EL REGISTRO
    $('#pass1').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass1').hide();
        } else if ($(this).val() == '') {
            $('#errorPass1').hide();
        } else {
            $('#errorPass1').show();
        }

    });

    //CONTRASEÑA1 RECUPERAR CONTRASEÑA
    $('#cambio1').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass1').hide();
        } else if ($(this).val() == '') {
            $('#errorPass1').hide();
        } else {
            $('#errorPass1').show();
        }

    });

    //CONTRASEÑA2 RECUPERAR CONTRASEÑA
    $('#cambio2').on('change', function () {

        var pass1 = $('#cambio1');
        var pass2 = $('#cambio2');

        areEqualPasswords(pass1, pass2);

    });

    //CURP EN EL REGISTRO
    $('#curp').on('change', function () {

        $.ajax({
            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {
                key: "repiteCurp",
                curp: $('#curp').val()
            },
            success: function (response) {

                if (response === 'CurpAlreadyExists') {
                    $('#curp').css('color', 'orange');
                    $('#errorCurpRepetido').show();
                } else {
                    $('#errorCurpRepetido').hide();
                }

            }
        });


        if (isValidCURP($(this))) {
            $('#errorCurp').hide();
        } else if ($(this).val() == '') {
            $('#errorCurp').hide();
        } else {
            $('#errorCurp').show();
        }

    });

    //CODIGO POSTAL EN EL REGISTRO
    $('#codigoPostal').on('change', function () {

        if ($(this).val().length === 0) {

            //Obtener estados

            $.ajax({

                url: 'ZonaController',
                cache: false,
                method: 'POST',
                data: {

                    key: "getEstados"


                },
                success: function (response) {

                    var data = JSON.parse(response);

                    //Limpia los campos de estado 
                    $("#estado").each(function () {
                        $(this).children().remove();
                    });

                    //Limpia los campos de municipio 
                    $("#municipio").each(function () {
                        $(this).children().remove();
                    });

                    //Primera opcion de estado
                    $('#estado').append("<option disabled selected>" + "Seleccione un estado" + "</option>");

                    //Primera opcion de municipio
                    $('#municipio').append("<option disabled selected>" + "Seleccione un municipio" + "</option>");

                    for (var i = 0; i < data.length; i++) {
                        //Carga estado
                        $('#estado').append("<option value='" + data[i].idEstado + "'>" + data[i].nombre + "</option>");
                    }

                    $('#estado').prop('selectedIndex', 0);
                    $('#municipio').prop('selectedIndex', 0);

                    console.log(data);

                }

            });


        } else if ($(this).val().length === 5) {


            $.ajax({

                url: 'ZonaController',
                cache: false,
                method: 'POST',
                data: {

                    key: "getEstadoyMunicipio",
                    numeroCP: $('#codigoPostal').val()

                },
                success: function (response) {

                    if (response == 'postalCodeDoesntExist') {
                        $('#error-CPexiste').show();
                        repiteCURP = true;

                    } else {
                        $('#error-CPexiste').hide();
                        repiteCURP = false;
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

                }

            });

        }



    });

    //TELEFONO EN EL REGISTRO
    $('#telefono').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#errorTelefono').hide();
        } else if ($(this).val() == '') {
            $('#errorTelefono').hide();
        } else {
            $('#errorTelefono').show();
        }

    });

    //ESTADO CIVIL EN EL REGISTRO
    $('#estadoCivil').on('change', function () {

        if (isValidSelect($(this))) {
            $('#errorECivil').hide();
        } else {
            $('#errorECivil').show();
        }

    });

    //FECHA DE NACIMIENTO EN EL REGISTRO
    $('#fechaNacimiento').on('change', function () {

        if (isValidDate($(this))) {
            $('#errorFecha').hide();
        } else {
            $('#errorFecha').show();
        }

    });

    //ESTADO EN EL REGISTRO
    $('#estado').on('change', function () {

        if (isValidSelect($(this))) {
            $('#errorEstado').hide();
        } else {
            $('#errorEstado').show();
        }

    });

    //MUNICIPIO EN EL REGISTRO
    $('#municipio').on('change', function () {

        if (isValidSelect($(this))) {
            $('#errorMunicipio').hide();
        } else {
            $('#errorMunicipio').show();
        }

    });

    //COLONIA EN EL REGISTRO
    $('#colonia').on('change', function () {

        if (isValidColonia($(this))) {
            $('#errorColonia').hide();
        } else {
            $('#errorColonia').show();
        }

    });

    //CALLE EN EL REGISTRO
    $('#calle').on('change', function () {

        if (isValidStreet($(this))) {
            $('#errorCalle').hide();
        } else {
            $('#errorCalle').show();
        }

    });

    //NUMERO EXTERIOR EN EL REGISTRO
    $('#noExterior').on('change', function () {

        if (isValidExtNumber($(this))) {
            $('#errorNoExterior').hide();
        } else {
            $('#errorNoExterior').show();
        }

    });

    //NUMERO INTERIOR EN EL REGISTRO
    $('#noInterior').on('change', function () {

        if (isValidIntNumber($(this))) {
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

    //VALIDACIONES

    function isValidCheckbox(input) {

        if (input.is(':checked')) {
            return true;
        }

        return false;

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

        ////Expresion regular por el estandard: RFC 5322
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
    
    function isValidFormatCP (input){
        
         var m = input.val();

        var expreg = /^\d{5}$/;

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

    function isValidDate(input) {

        //Obtener fecha
        let today = new Date();

        //Valor seleccionado del input
        let date_from = input.val();
        date_from = new Date(date_from);

        let event = false;

        today < date_from ? event = true : event = false;


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

});