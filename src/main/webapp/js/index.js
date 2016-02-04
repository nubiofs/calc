/**
 * Modifica o comportamento da tela index.html na sua inicialização.
 * 
 * (HTML5 Form Validation)
 * Verificar o “score” de quão aderente seu navegador é ou não ao html5 (https://html5test.com/index.html).
 * Ver implementação recurso "(input type=number) de FORM";
 * 
 */

// Shorthand for block:
/*
$( document ).ready(function() {
	console.log( "ready!" );
});
*/
$(function () {
	
	//Utilizando o "Element Selector" para FORM
	$("form").submit(somar);//Form Events "submit"
	
	//Ou "anonymous function" (no lugar de SOMAR):
	/*
	 $("form").submit(function(event) {
        event.preventDefault();
 
        var a = $("#a").val();
        var b = $("#b").val();
        var result = parseInt(a) + parseInt(b);
 
        $("#result").val(result);
    });
	 */
	
});

function somar(event){
	
	event.preventDefault();
	
	var a = $("#a").val();
	var b = $("#b").val();
	
	var result = parseInt(a) + parseInt(b);
	
	$("#result").val(result);
	
};