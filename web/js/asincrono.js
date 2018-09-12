/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    console.log("Hola Chrome");
    
   $("#btn-login").click(function(){
      $.ajax({
         url : "UsuarioController",
         data :{
             accion : "registrar",
             nombre : $("#nombre").val(),
             apellidos : $("#apellidos").val(),
             usuario : $("#usuario").val(),
             password : $("#password").val(),
             curp : $("#curp").val(),
             telefono : $("#telefono").val(),
             correo : $("#correo").val()
         },
         method : "POST",
         error : function(xhr){
             alert("Ops! Algo Paso");
         },
         success : function(response){
             swal({title:"El registro se inserto corretamente con el id " + response});
             $("input").val("");
         }
      }); 
   });    
});