/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * autor: Alexis España Rodríguez
 */

// Pantalla 1
/*
 var form = $("form")[0];
 var data = new FormData(form);
 
 */

$(document).ready(function () {

    console.log("---formNavegadora.js---1"); 
    $('#btn-save1, #btn-save2,#btn-save3,#btn-save4,#btn-save5').on('click', function () {
        console.log("click on 'btn-save[i]'");
        
        var data = new FormData();
        var form;
        var dataTemp;
        var formValues;

        for (var i = 0; i < 5; i++) {
            form = $("form")[i];
            dataTemp = new FormData(form);
            formValues = dataTemp.entries();
            while (!(ent = formValues.next()).done) {
                // ent.value[0] es la 'key' and ent.value[1] es el valor
                data.append(ent.value[0], ent.value[1]);
            }
        }
        data.append("key", "btn-save");
        data.forEach((value, key) => {
            console.log(key + " " + value);
        });
        $.ajax({
            url: "NavegadoraController",
            method: "POST",
            data: data,
            enctype: "multipart/form-data",
            processData: false,
            contentType: false,
            success: function (response) {
                if (response == "success") {
                    console.log("ok");
                } else {
                    console.log("Algo pasó" + response);
                }
            },
            error: function (request, status, error) {
                console.log("Enviar datos Error " + request.responseText);
                console.log("Enviar datos Error status " + status);
                console.log("Enviar datos Error error" + error);
                //alert("No enontre el controlador" + status);                               
            }
        });

    });
   
});