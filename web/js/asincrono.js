$('#btn-registro').on('click', function(){
          
           $.ajax({
               
               url: 'RegistraUsuarioController',
               cache: false,
               method: 'POST',
               data: {
                   nombre: $('#nombre').val(),
                   apellido1: $('#apellido1').val(),
                   apellido2: $('#apellido2').val(),
                   usuario: $("#usuario").val(),
                   correo: $('#correo').val(),
                   curp: $('#curp').val(),
                   colonia: $('#colonia').val(),
                   calle: $('#calle').val(),
                   noExterior : $("#noExterior").val(),
                   noInterior : $("#noInterior").val(),
                   pass1 : $("#pass1").val(),
                   pass2 : $("#pass2").val(),
                   telefono : $("#telefono").val(),
                   estadoCivil : $("#estadoCivil").val(),
                   fechaNacimiento: $("#fechaNacimiento").val(),
                   estado: $("#estado").val(),
                   municipio: $("#municipio").val()
                   
                  
               }
      
           })
            .done(function(response){
                console.log(response);
           })
           .fail(function(xhr, textStatus, errorThrown){
               console.log(xhr.responseText);
           });
           
           
       });