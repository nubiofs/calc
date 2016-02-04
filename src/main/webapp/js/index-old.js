/**
 * Modifica o comportamento da tela index.html na sua inicialização.
 */

// Shorthand for block:
/*
$( document ).ready(function() {
	console.log( "ready!" );
});
*/
$(function () {
	
	$("#sum").click(somar);
	
});

function somar(){
	
	var a = $("#a").val();
	var b = $("#b").val();
	
	var result = parseInt(a) + parseInt(b);
	
	$("#result").val(result);
	
};

