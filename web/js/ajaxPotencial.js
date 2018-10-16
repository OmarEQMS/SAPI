$(document).ready(function () {


    $('#eliminarCuentaPotencial').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "Los datos se eliminarán y no podrás recuperarlos.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
                    
        })
            .then((eliminar) => {
                if (eliminar) {



                } else {

                }
            });

    });

    $("#btn-cancelarPreConsulta1").on('click', () => {

        //Modal borrar sintoma
        swal({
            title: "¿Estás segura(o) que deseas cancelar la cita?",
            text: "Tendrás que reiniciar tu solicitud a preconsulta",
            icon: "warning",
            buttons: true,
            buttons: ['Regresar', 'Cancelar cita'],
            dangerMode: true,
        })
            .then((cancelar) => {
                if (cancelar) {

                    $('#modalMotivoCancelacion').modal('toggle');


                } else {

                }
            });

    });

    $("#btn-cancelarPreConsulta2").on('click', () => {

        //Modal borrar sintoma
        swal({
            title: "¿Estás seguro que deseas cancelar la cita?",
            text: "Tendrás que reiniciar tu solicitud a preconsulta",
            icon: "warning",
            buttons: true,
            buttons: ['Regresar', 'Cancelar cita'],
            dangerMode: true,
        })
            .then((cancelar) => {
                if (cancelar) {

                    $('#modalMotivoCancelacion').modal('toggle');
                    $('#modalVerCitaPreConsulta').modal('toggle');

                } else {

                }
            });

    });

    $("#btn-enviarSolicitud").on('click', () => {

        //Modal borrar sintoma
        swal({
            title: "¡Buen Trabajo! se ha enviado tu solicitud",
            text: "En un lapso no mayor a 36 horas recibirás una respuesta",
            icon: "success",
            showCancelButton: false,
            showConfirmButton: true,
            buttons: [, 'Aceptar'],
            dangerMode: true,
        });

        var masculino, femenino, camilla, sillaDeRuedas, baston, oxigeno, biopsia, motivoConsulta,
            identificacionOficial, comprobanteDomicilio, estudioPrevio, estudioBiopsia;

        var data = [];

        masculino = $('#masculino').is(':checked') ? 1 : 0;
        femenino = $('#femenino').is(':checked') ? 1 : 0;

        sillaDeRuedas = $('#sillaRuedas').is(':checked') ? 1 : 0;
        camilla = $('#camilla').is(':checked') ? 1 : 0;
        baston = $('#baston').is(':checked') ? 1 : 0;
        oxigeno = $('#oxigeno').is(':checked') ? 1 : 0;
        motivoConsulta = $('#motivoConsulta').val();
        biopsia = $('#biopsiaInput').is(':checked') ? 1 : 0;

        identificacionOficial = $('#fileIdentificacion').prop('files')[0];
        comprobanteDomicilio = $('#fileComprobanteDomicilio').prop('files')[0];
        estudioPrevio = $('#fileEstudioPrevio').prop('files')[0];
        estudioBiopsia = $('#fileEstudioBiopsia').prop('files')[0];

        data.push(masculino);
        data.push(femenino);
        data.push(sillaDeRuedas);
        data.push(camilla);
        data.push(baston);
        data.push(oxigeno);
        data.push(biopsia);
        data.push(motivoConsulta);
        data.push(identificacionOficial);
        data.push(comprobanteDomicilio);
        data.push(estudioPrevio);
        data.push(estudioBiopsia);

        console.log("masculino: " + masculino + " femenino: " + femenino + " silla:  " + sillaDeRuedas + " camilla: " + camilla + " bastón: " +
            baston + " oxigeno " + oxigeno + " biopsia " + biopsia + " motivo " + motivoConsulta
            + " identificacion: " + identificacionOficial.name + " comprobante: " + comprobanteDomicilio.name + " estudio: " + estudioPrevio.name
            + " biopsia: " + estudioBiopsia.name);

        $.ajax({
            url:/*sin url aún,*/"URL",
            method: "POST",
            data: data,
            enctype: "multipart/form-data",
            processData: false,
            contentType: false,
            success: function (response) {
                if (response == "success") {
                    console.log("ok");
                } else {
                    console.log("Algo pasó");
                }
            },
            error: function () {
                console.log("error");
            }


        });

    });


});