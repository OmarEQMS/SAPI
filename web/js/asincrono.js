import {validation} from './validaciones.js';

$(document).ready(function () {

    //Esconder mensajes de error
    $('#noEqualPasswordsError').hide();
    $('#errorNombre').hide();
    $('#errorApellidoPaterno').hide();
    $('#errorApellidoMaterno').hide();
    $('#errorNombreUsuario').hide();
    $('#errorCorreo').hide();

    $('#btn-registro').on('click', function () {

        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {
                key: "registrar",
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
                nombreEstado: $('#estado').val()

            },
            success: function (response) {
                
                //Limpiar el select antes de que haga una consulta para que no se emapalmen los municipios
                $(".municipios select").each(function () {
                    $(this).children().remove();
                });

                var json = JSON.parse(response);

                for (var i = 0; i < json.length; i++) {
                    $('.municipios select').append("<option value="+json[i].nombre +">" + json[i].nombre + "</option>");
                }

                $('.municipios select').prop('selectedIndex', 0);

                //console.log(json);

            }

        });


    });

    //Verificar que las contraseñas sean iguales
    $('#pass2').on('change', function(){

        var pass1 = $('#pass1');
        var pass2 = $('#pass2');

        areEqualPasswords(pass1, pass2);
        
    });

    function areEqualPasswords(pass1, pass2){

        if(pass1.val() != pass2.val()){
            
            pass2.css('border', '1px solid red');
            pass1.css('border', '1px solid red');
            $('#noEqualPasswordsError').show();

            return false;

        }else{
            
            pass2.css('border', '');
            pass1.css('border', '');
            $('#noEqualPasswordsError').hide();
            
        }

        return true;
    }

    //////////////////////////////////VALIDACIONES

    //1.- NOMBRE
    $('#nombre').on('change', function() {
        
        if(validation.isValidName($('#nombre'))){
            $('#errorNombre').hide();
        }else if($(this).val() == ''){
            $('#errorNombre').hide();
        }else{
            $('#errorNombre').show();
        }

    });

    //2.- APELLIDO PATERNO
    $('#apellido1').on('change', function() {
        
        if(validation.isValidLastName($('#apellido1'))){
            $('#errorApellidoPaterno').hide();
        }else if($(this).val() == ''){
            $('#errorApellidoPaterno').hide();
        }else{
            $('#errorApellidoPaterno').show();
        }

    });

    //3.- APELLIDO MATERNO
    $('#apellido2').on('change', function() {
        
        if(validation.isValidLastName($('#apellido2'))){
            $('#errorApellidoMaterno').hide();
        }else if($(this).val() == ''){
            $('#errorApellidoMaterno').hide();
        }else{
            $('#errorApellidoMaterno').show();
        }

    });

    //4.- NOMBRE DE USUARIO
    $('#usuario').on('change', function() {
        
        if(validation.isValidLastName($('#usuario'))){
            $('#errorUsuario').hide();
        }else if($(this).val() == ''){
            $('#errorUsuario').hide();
        }else{
            $('#errorUsuario').show();
        }

    });



});