/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Author Angel Gtz

$(document).ready(function () {
    $("#RestablcerContra").on('click', function () {
        console.log("Presionó cmabiar contrasena");
        
        $.ajax({
            url: "RecuperarController",
            data: {
                key: "cambiarContrasena",
            
                password: $("#cambio1").val(),
                password2: $("#cambio2").val()
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
     $("#recuperarContra").on('click', function () {
        console.log("Click en recuperarContra desde el Login");
        
        $.ajax({
            url: "LoginController",
            data: {
                key: "recuperarContra"
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
    
});