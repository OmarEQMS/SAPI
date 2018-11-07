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

    console.log("---formNavegadora.js---");
    //Pantalla 1
    $('#btn-save1').on('click', function () {
        //console.log("Entra a la acción de btn-save1");
        var form = $("form")[0];
        var data = new FormData(form);

        data.forEach((value, key) => {
            console.log(key + " " + value);
        });
        $.post("NavegadoraController"), {
            key: "guardarP1",
            data: data
        },
                function (response, status, xhr) {
                    if (status == "success") {
                        if (response == "error") {
                            //Manejo de error
                        } else {
                            //Redireccionar
                        }
                    }
                }

    });

    //Pantalla 2
    $('#btn-save2').on('click', function () {
        //console.log("Entra a la acción de btn-save2");

        var data = new FormData();
        var form;
        var dataTemp;
        var formValues;

        for (var i = 0; i < 2; i++) {
            form = $("form")[i];
            dataTemp = new FormData(form);
            formValues = dataTemp.entries();
            while (!(ent = formValues.next()).done) {
                // ent.value[0] es la 'key' and ent.value[1] es el valor
                data.append(ent.value[0], ent.value[1]);
            }
        }
        data.append("key", "guardarP2");
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
    //Pantalla 3
    $('#btn-save3').on('click', function () {
        //console.log("Entra a la acción de btn-save3");

        var data = new FormData();
        var form;
        var dataTemp;
        var formValues;

        for (var i = 0; i < 3; i++) {
            form = $("form")[i];
            dataTemp = new FormData(form);
            formValues = dataTemp.entries();
            while (!(ent = formValues.next()).done) {
                // ent.value[0] es la 'key' and ent.value[1] es el valor
                data.append(ent.value[0], ent.value[1]);
            }
        }
        data.append("key", "guardarP3");
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

    //Pantalla 4
    $('#btn-save4').on('click', function () {
        //console.log("Entra a la acción de btn-save4");

        var data = new FormData();
        var form;
        var dataTemp;
        var formValues;

        for (var i = 0; i < 4; i++) {
            form = $("form")[i];
            dataTemp = new FormData(form);
            formValues = dataTemp.entries();
            while (!(ent = formValues.next()).done) {
                // ent.value[0] es la 'key' and ent.value[1] es el valor
                data.append(ent.value[0], ent.value[1]);
            }
        }
        data.append("key", "guardarP4");
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
    //Pantalla 5
    $('#btn-save5').on('click', function () {
        //console.log("Entra a la acción de btn-save5");

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
        data.append("key", "guardarP4");
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

    $('#btn-sendAll').on('click', function () {
        console.log("Entra a la acción sendAll");

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
        data.append("key", "sendAll");
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