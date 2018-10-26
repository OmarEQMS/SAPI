/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Author Angel Gtz


$("#btn-RestablcerContra").on('click', function () {

    $.ajax({
        url: "RecuperarController",
        data: {
            key: "cambiarContrasena",
            idCuenta: $("#sesionPaciente").val(),
            password: $("#contra-Cambio").val(),
            password2: $("#confirmarContra-Cambio").val()
        },
        method: "POST",
        success: function (response) {
            if (response == "success") {

            } else {
                
            }
        },
        error: function (xhr) {

        }
    });

});