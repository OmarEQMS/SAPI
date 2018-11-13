/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(document).ready(function () {

//VALIDACIONES CUENTA

     $('.error-correo').hide();
     $('#error-fecha').hide();
     $('#error-fechaFin').hide();
     $('#error-fechaInicio').hide();
     $("#error-telefono").hide();
        
    //1.- Correo
    $('#correo').on('change', function(){
        
        if(isValidEmail($('#correo'))){
            $('.error-correo').hide();
        }else{
            $('.error-correo').show();
        }
    }); 

    //2.- No expediente
    $('#noExpediente').on('change', function(){
        if(isValidNoExpediente($('#noExpediente'))){
            $('#error-noExpediente').hide();
        }else{
            $('#error-noExpediente').show();
        }
    }); 

    //3.- Telefono
    $('#telefono').on('change', function(){
        if(isValidPhoneNumber($('#telefono'))){
            $('#error-telefono').hide();
        }else{
            $('#error-telefono').show();
        }
    }); 

    //4.- Tipo Sangre
    $('#tipo-sangre').on('change', function(){
        if(isValidBloodType($('#tipo-sangre'))){
            $('#error-tipoSangre').hide();
        }else{
            $('#error-tipoSangre').show();
        }
    });

    //5.- Contraseña
    $('#password').on('change', function(){
        if(isValidPassword($('#password'))){
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

    //VALIDACIONES TRATAMIENTO

    //1.- Fecha inicio
    $('#fechaInicioTratamiento').on('change', function(){
        
        
        if(isValidDate($('#fechaInicioTratamiento'))){
            $('#error-fechaInicio').hide();
        }else{
            $('#error-fechaInicio').show();
        }
    }); 
    
        //1.- Fecha fin
    $('#fechaFinTratamiento').on('change', function(){
        if(isValidDate2($('#fechaFinTratamiento'), $("#fechaInicio-"+$("#botonHidden").val()).val())){
            $('#error-fechaFin').hide();
        }else{
            $('#error-fechaFin').show();
        }
    }); 
    
    //VALIDACIONES INDEX
    /*
    //1.- Fecha cita
    $('#fechaFinTratamiento').on('change', function(){
        alert($("#fechaInicio-"+$("#botonHidden").val()).val());


        if(isValidDate2($('#fechaFinTratamiento'), $("#fechaInicio-"+$("#botonHidden").val()).val())){
            $('#error-fechaFin').hide();
        }else{
            $('#error-fechaFin').show();
        }
    }); 

    //2.- Tipo cita
    $('#RegistrarCita_tipo').on('change', function(){
        if(isValidSelect($('#RegistrarCita_tipo'))){
            $('#error-tipoCita').hide();
        }else{
            $('#error-tipoCita').show();
        }
    });

     //3.- Médico
     $('#RegistrarCita_medico').on('change', function(){
        if(isValidSelect($('#RegistrarCita_medico'))){
            $('#error-medico').hide();
        }else{
            $('#error-medico').show();
        }
    });*/
    
    function isValidNoExpediente (input) {

        var m = input.val();

        var expreg = /^[a-zA-Z0-9]{9,9}$/;


        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;


    };
    
    function isValidEmail (input)  {

        var m = input.val();

        ////Expresion regular por el estandard: RFC 5322
        var expreg = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;

    };
    
    function isValidPhoneNumber (input) {

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
    };
    
    function isValidDate (input) {

        //Obtener fecha
        let today = new Date();

        //Valor seleccionado del input
        let date_from = input.val();
        date_from = new Date(date_from);
        var todayYear= today.getFullYear();
        var inicioYear = date_from.getFullYear();
        var event = false;
        
        if(today > date_from && inicioYear >= todayYear-5){
            event=false;
            console.log("Valido");
        }
        else{
            event=true;
            console.log("Invalido");
        }
        

       


        if (!input.val() || event) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;


    };

    function isValidDate2 (input, fechaInicio) {

        //var mydate = new Date('2014-04-03');
        //Obtener fecha
        let today = new Date();

        //Valor seleccionado del input
        let date_from = input.val();
       
        console.log(fechaInicio);
        date_from = new Date(date_from);
        var date_Inicio = new Date(fechaInicio);

        var event = false;
        
        console.log(input.val());
        
        console.log("Date inicio"+date_Inicio);
        console.log("El años es: "+date_Inicio.getFullYear());
        console.log("Date from" +date_from);
        console.log("El años es: "+date_from.getFullYear());
         
        var inicioYear = date_Inicio.getFullYear();
        var inputYear = date_from.getFullYear();
        
        if(inputYear < inicioYear+5 &&  date_Inicio <= date_from ){
            event = false;
            console.log(event);
            console.log("fechaValida");
        }
        else{
            event= true;
            console.log(event);
            console.log("fechaInValida");
        }
        
       // date_Inicio > date_from ? event = true : event = false;

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

   function isValidExpediente(input){

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


    };
    
     function isValidPassword(input){

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

    };

});
