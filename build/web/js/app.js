$(document).ready(function () {

    $('#btn-eliminar').on('click', function(){
        //Modal editar usuario
        swal({ //Sweet Alert
            title: "Estas seguro?",
            text: "Una vez eliminado, el médico y sus datos ya no se podrán recuperar",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then((eliminar) => {
            if (eliminar) {
                    
                    //ajax para eliminar
                    
            } else {
                    
            }
        });
    });
    
});