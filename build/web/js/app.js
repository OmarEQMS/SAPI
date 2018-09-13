$(document).ready(function () {
    $("#btn-gurdar").on('click', function(){
        var idU = $("#idPersona");
        $.ajax({
           url: "UsuarioController",
           method : "POST",
           cache : false,
           data:{
               accion: "actualiza",
               id: idU.val(),
               nombre: $("#nombre").val(),
               apellidos : $("#apellidos").val()                       
           },
           success: function(response){
               if(response==="YES"){
                   $(".btn-editar[data-id='"+idU.val()+"']").parent().parent().children("td")[0].innerHTML = $("#nombre").val();
                   $(".btn-editar[data-id='"+idU.val()+"']").parent().parent().children("td")[1].innerHTML = $("#apellidos").val();
//                   $("#name-"+idU.val()).html($("#nombre").val());            <td id="<c:out value="name-${persona.idPersona}"/>"><
//                   $("#apellidos-"+idU.val()).html($("#apellidos").val());    <td id="<c:out value="apellidos-${persona.idPersona}"/>">
                   $("#modalEditarUsuario").modal("toggle");
                }
           },
           error: function(xhr){
           
           }
        });
    });
    
    $('body').on('click', '.btn-editar', function(){  
        var idU = $(this);
        $.ajax({
           url: "UsuarioController",           
           method : "POST",
           cache : false,
           dataType: "JSON",
           data:{
               accion: "recupera",
               id: idU.data("id")
           },
           beforeSend: function(){
               $("#nombre").val("Cargando Datos ...");
               $("#apellidos").val("Cargando Datos...");  
           },
           success: function(response){
               //$("#btn-gurdarCambios")
               $("#idPersona").val(response.idPersona)
               $("#nombre").val(response.nombre);
               $("#apellidos").val(response.apellidos);
           },
           error: function(xhr){
           
           }
        });
    });
    
    $('.btn-eliminar').on('click', function(){  
        var idU = $(this);
        //Modal editar usuario
        swal({ //Sweet Alert
            title: "Estas seguro?",
            text: "Una vez eliminado, el médico y sus datos ya no se podrán recuperar",
            icon: "warning",
            buttons: true,
            dangerMode: true
        }).then(function(eliminar){               
            if (eliminar) {
                $.ajax({
                   url: "UsuarioController",
                   method : "POST",
                   cache : false,
                   data: {
                       accion : "eliminar",
                       id: idU.data("id") // $(this).attr("data-id")
                   },                    
                   success: function(response){
                       //Saber que se elimino correctamente
                       idU.parent().parent().hide();
                       if(response==="YES"){
                           swal({
                              title:"Listo!" 
                           });
                       }
                   },
                   error: function(xhr){
                       
                   }
                });
            } else {
                    
            }
        });
    });
    
});