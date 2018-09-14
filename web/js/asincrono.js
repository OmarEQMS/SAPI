$(document).ready(function () {

    /*$.ajax({
     
     url: 'ZonaController',
     cache: false,
     method: 'POST',
     data: {
     
     key: "mostrar"
     
     },
     success: function(response){
     
     console.log(response);
     
     }
     
     });*/



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



});