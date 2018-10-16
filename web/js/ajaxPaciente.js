$(document).ready(function () {

    /*PUSE ESTO PORQUE NO SUPE DE QUE OTRA FORMA CAPTURAR EL VALOR DE RADIO INPUT
    SI CONOCEN UNA FORMA MEJOR, POR FAVOR CAMBIARLO*/
    var selected = $("#RegistrarCita_piso").find("input[name='Pisos']");
    var miPiso = "Piso 1";
    selected.change(function(){
        miPiso = $(this).val();
    });
    var edificios = $("#RegistrarCita_edificio").find("input[name='Edificios']");
    var miEdificio;
    edificios.change(function(){
        miEdificio = $(this).val();
    });
    /*PUSE ESTO PORQUE NO SUPE DE QUE OTRA FORMA CAPTURAR EL VALOR DE RADIO INPUT
    SI CONOCEN UNA FORMA MEJOR, POR FAVOR CAMBIARLO*/

    //REGISTRAR CITA
    $('#btn-citaRegistrar').on('click', () => {
        
        $.ajax({
            url: ''/*VACIO POR EL MOMENTO*/,
            cache: false,
            method: 'POST',
            data: {
                key: '',//FALTA DEFINIR 'key', PUEDE SER "registrar",
                fecha: $('#RegistrarCita_fecha').val(),
                hora: $('#RegistrarCita_hora').val(),
                tipo: $('#RegistrarCita_tipo').val(),
                medico: $('#RegistrarCita_medico').val(),
                piso: miPiso,
                edificio: miEdificio
            }
        })
        .done(function (response) {
            console.log(response);
        })
        .fail(function (xhr, textStatus, errorThrown) {
            console.log(xhr.responseText);
        });
        //VERIFICACION
        console.log($('#RegistrarCita_fecha').val());
        console.log($('#RegistrarCita_hora').val());
        console.log($('#RegistrarCita_tipo').val());
        console.log($('#RegistrarCita_medico').val());
        console.log(miPiso);
        console.log(miEdificio);

         //CERRAR MODAL
        $('#modalAgregarCita').modal('toggle')
    });

    $('#feedbackEdAntiguo').hide();
    $('#feedbackEdTorre').hide();
    $('#pisosDiv').hide();

    $('#EdAntiguo').on('mouseover', function() {
        $('#feedbackEdAntiguo').show();
        $('#feedbackEdAntiguo').disabled = true;
    });
    $('#feedbackEdAntiguo').on('mouseout', function() {
        $('#feedbackEdAntiguo').hide();
    });

    $('#EdTorre').on('mouseover', function() {
        $('#feedbackEdTorre').show();
    });
    $('#feedbackEdTorre').on('mouseout', function() {
        $('#feedbackEdTorre').hide();
    });

    
    $('input:radio[name=Edificios]').change(function() {
        if (this.value == 'Edificio antiguo') {
            $('#pisosDiv').hide();
        }
        else if (this.value == 'Torre de nueva hospitalización') {
            $('#pisosDiv').show();
        }
    });
    
});