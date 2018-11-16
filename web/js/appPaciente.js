//import {validation} from './validaciones.js';

$(document).ready(function () {
    
    $('#tipoSangre option[value="'+$('#selectSangre').val()+'"]').prop("selected", true);
    $('#etapaClinica option[value="'+$('#selectEtapa').val()+'"]').prop("selected", true);
    
    //Esconder mensajes de error en cuenta
    $('.error-correo').hide();
    $('#error-noExpediente').hide();
    $('#error-tel').hide();
    $('#error-tipoSangre').hide();
    //$('#error-contraseña').hide();
    $('#error-notEqualPasswords').hide();

    //Esconder mensajes de error en index
    $('#error-fecha').hide();
    $('#error-tipoCita').hide();
    $('#error-medico').hide();
    $('#error-edificio').hide();
    $('#error-piso').hide();

    // Inicializar plug in tooltipster
    $('.questionMark').tooltipster({
        theme: 'tooltipster-shadow',
        delay: '140',
       
    });
    
    $('.questionMarkRight').tooltipster({
        theme: 'tooltipster-shadow',
        delay: '140',
        side: 'right'
    });
    
    

    //Reemplazar el nombre del archivo en el input
    $('.custom-file-input').on('change', function () {
        $(this).next('.custom-file-label').addClass("selected").html($(this).val());
    });

    //Esconder menu lateral a presionar click en el menu hamburguesa
    $('#sidebarCollapse').on('click', () => {
        $('#sidebar, #content').toggleClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
    });


    ///////////////////////////////NAVEGADORAS
    $("#tablaSintomas").DataTable({
        "searching": false,
        responsive: true,
        dom: 'lBfrtip',
        buttons: [

            {
                extend: 'excel',
                text: 'Exportar a Excel',
                className: 'btn-success'
            },
            {
                extend: 'pdf',
                text: 'Exportar a pdf',
                className: 'btn-info'
            }
        ],

        "language": {

            "sProcessing": "Procesando...",
            "sLengthMenu": "Mostrar _MENU_ registros",
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": "Ningún dato disponible en esta tabla",
            "sInfo": "",
            "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }

        }

    });



    $('[data-toggle="tooltip"]').tooltipster({
        theme: 'tooltipster-shadow',
        delay: '140'
    });



    //AGREGAR Y QUITAR TRATAMIENTOS
    $('#add-Tratamiento').on('click', function () {


        //Ajax para treaer otra vez los tratamientos en JSON
        $.ajax({
            url: 'PacienteController',
            method: 'POST',
            cache: false,
            data: {key: 'getTratamientos'},
            success: function (response) {

                var data = JSON.parse(response);

                console.log(data);

                var option = '';
                data.forEach(function (element, index) {

                    console.log("Nombre: " + element.nombre);

                    option += `<option value="${element.idTipoTratamiento}">${element.nombre}</option>`;

                });

                console.log(option);


                var plantilla = `<div class="form-group row justify-content-center contenedor-tratamientos">
        <div class="col-3">
            <select id="tratamiento" class="form-control dataTratamiento select-Tratamiento">
                <option disabled selected>Elegir Tratamiento</option>` +
                        option +
                        ` </select>
        </div>
            <div class="col-3">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fas fa-calendar-alt"></i>
                                            </div>
                                        </div>
                                        <input placeholder="Inicio" class="selectStyle form-control textbox-n fecha-Inicio-Tratamiento" type="text"
                                            onfocus="(this.type='date')" id="fechaInicioTratamiento">
                                    </div>
                                </div>
            <div class="col-1">
                <button type="button" id="remove-Tratamiento" class="btn btn-outline-danger btn-block" style="border-radius: 20px;">
                <i class="fas fa-times"></i></button>
            </div>
            <div class="col-1">
                <button type="button" id="finished-Tratamiento" class="btn btn-outline-success btn-block button-Fin-Tratamiento" style="border-radius: 20px;">
                <i class="fas fa-check"></i></button>
            </div>

    </div>`;


                $('#tratamientos').append(plantilla);


                       var plantilla = `<div class="form-group row justify-content-center contenedor-tratamientos">
                 <div class="col-7">
                 <select id="tratamiento" class="form-control">
                 <option disabled selected>Elegir Tratamiento</option>
                 <option value="${response.id}">${response.nombreTratamiento}</option>
                 </select>
                 </div>
                 <div class="col-1">
                 <button type="button" id="remove-Tratamiento" class="btn btn-outline-danger" style="border-radius: 25px;">
                 <i class="fas fa-times"></i>
                 </div>
                 
                 </div>`;
                 
                 $('#tratamientos').append(plantilla);
                 
                 

            }

        });





    });

    $('body').on('click', '#remove-Tratamiento', function () {

        $(this).parent().parent().remove();

    });

    //Deshabilitar tratamiento cuando ya se seleccionó uno
    $('body').on('change', '.select-Tratamiento', function () {

        $(this).attr('disabled', true);

    });

    //Editar tratamiento
    $('body').on('click', '.remove-Primer-Tratamiento', function () {

        $('.select-Tratamiento').attr('disabled', false);
        $('.fecha-Inicio-Tratamiento').attr('disabled', false);

    });

    //Deshabilitar tratamiento cuando ya se seleccionó uno
    $('body').on('focusout', '.fecha-Inicio-Tratamiento', function () {

        $(this).attr('disabled', true);

    });
    
   $("body").on("click",".myCleaner", function(){
		$(".hora").val("");
                $(".tipo").prop('selectedIndex',0);
                $(".medico").prop('selectedIndex',0);
                $("#RegistrarCita_edificioAntiguo").prop("checked", false);
                $("#RegistrarCita_edificioNuevo").prop("checked", false);
                $('input[name=Pisos]').prop("checked", false);
                $('#pisosDiv').hide();
                
                $('#error-campos').hide();
                $('#RegistrarCita_hora').css('border', '');
                $('#RegistrarCita_hora').css('color', '');
                
	});
        
        $("body").on("click",".passwordCleaner", function(){
		$("#password").val("");
                $("#password2").val("");
                
                $('#error-contrasena').hide();
                $('#noEqualPasswordsError').hide();
                $('#password').css('border', '');
                $('#password').css('color', '');
                $('#password2').css('border', '');
                $('#password2').css('color', '');
                
	});
        
        $("body").on("click",".myCleanerAddTratamientos", function(){
		$(".fechaInicio").attr("type","text").val('').attr("placeholder","Introduce la fecha de inicio");
                $('.error-fecha').hide();
                $('#fechaInicioTratamiento').css('border', '');
                $('#fechaInicioTratamiento').css('color', '');
                $(".tratamiento").prop('selectedIndex',0);
               
	});
        
        
        $("body").on("click",".myCleanerAddFinTratamientos", function(){
		$(".fechaFin").attr("type","text").val('').attr("placeholder","Introduce la fecha de fin");
                $('.error-fechaFin').hide();
                $('#fechaFinTratamiento').css('border', '');
                $('#fechaFinTratamiento').css('color', '');
	});


    //Cambiar color al botón de confirmación de tratamiento terminado
    $('body').on('click', '.button-Fin-Tratamiento', function () {

        $(this).addClass('button-clicked');

    });

    /*
     //VALIDACIONES CUENTA
     
     //1.- Correo
     $('#myEmail').on('change', function(){
     if(validation.isValidEmail($('#myEmail'))){
     $('#error-correo').hide();
     }else{
     $('#error-correo').show();
     }
     }); 
     
     //2.- No expediente
     $('#numExpediente').on('change', function(){
     if(validation.isValidNoExpediente($('#numExpediente'))){
     $('#error-noExpediente').hide();
     }else{
     $('#error-noExpediente').show();
     }
     }); 
     
     //3.- Telefono
     $('#telephoneNum').on('change', function(){
     if(validation.isValidPhoneNumber($('#telephoneNum'))){
     $('#error-tel').hide();
     }else{
     $('#error-tel').show();
     }
     }); 
     
     //4.- Tipo Sangre
     $('#tipo-sangre').on('change', function(){
     if(validation.isValidBloodType($('#tipo-sangre'))){
     $('#error-tipoSangre').hide();
     }else{
     $('#error-tipoSangre').show();
     }
     });
     
     //5.- Contraseña
     $('#password').on('change', function(){
     if(validation.isValidBloodType($('#password'))){
     $('#error-contraseña').hide();
     }else{
     $('#error-contraseña').show();
     }
     });
     
     //Verificar que las contraseñas son iguales
     $('#password-confirm').on('change', function(){
     
     areEqualPasswords($('#password'), $('#password-confirm'));
     
     });
     
     function areEqualPasswords(pass1, pass2) {
     
     if (pass1.val() != pass2.val()) {
     
     pass2.css('border', '1px solid red');
     pass1.css('border', '1px solid red');
     $('#error-notEqualPasswords').show();
     
     return false;
     
     } else {
     
     pass2.css('border', '');
     pass1.css('border', '');
     $('#error-notEqualPasswords').hide();
     
     }
     
     return true;
     }
     
     //VALIDACIONES INDEX
     
     //1.- Fecha
     $('#RegistrarCita_fecha').on('change', function(){
     if(validation.isValidDate($('#RegistrarCita_fecha'))){
     $('#error-fecha').hide();
     }else{
     $('#error-fecha').show();
     }
     }); 
     
     //2.- Tipo cita
     $('#RegistrarCita_tipo').on('change', function(){
     if(validation.isValidSelect($('#RegistrarCita_tipo'))){
     $('#error-tipoCita').hide();
     }else{
     $('#error-tipoCita').show();
     }
     });
     
     //3.- Médico
     $('#RegistrarCita_medico').on('change', function(){
     if(validation.isValidSelect($('#RegistrarCita_medico'))){
     $('#error-medico').hide();
     }else{
     $('#error-medico').show();
     }
     });*/
    
    //TABLA TRATAMIENTOS
    $('#tablaTratamientos').DataTable({
        order: [],
        responsive: true,
        dom: 'lBfrtip',
        buttons: [
        ],

        "language": {

            "sProcessing": "Procesando...",
            "sLengthMenu": "Mostrar _MENU_ registros",
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": "Ningún dato disponible en esta tabla",
            "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_",
            "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }

        }

    });


});