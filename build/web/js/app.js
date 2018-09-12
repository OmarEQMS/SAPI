$(document).ready(function () {

    $('.btn-eliminar').on('click', function(){  
        var idU = $(this);
        //Modal editar usuario
        swal({ //Sweet Alert
            title: "Estas seguro?",
            text: "Una vez eliminado, el médico y sus datos ya no se podrán recuperar",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then(function(eliminar){               
            if (eliminar) {
                $.ajax({
                   url: "UsuarioController",
                   data: {
                       accion : "eliminar",
                       id: idU.data("id") // $(this).attr("data-id")
                   }, 
                   method : "POST",
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