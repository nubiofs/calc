/**
 * Modifica o comportamento da tela index.html na sua inicialização (Controlador).
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
	
	//Utilizando o "Element Selector" para FORM (formulário DOM)
	$("form").submit(somar);//Form Events "submit"
	
	//Ou "anonymous function" (no lugar da função SOMAR):
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

//Execução da soma (no front-end via javascript)
/*
function somar(event){
	
	event.preventDefault();
	
	var a = $("#a").val();
	var b = $("#b").val();
	
	var result = parseInt(a) + parseInt(b);
	
	$("#result").val(result);
	
};
*/

//Execução da soma (no back-end via RESTful Java)
/*
function somar(event){
	
	event.preventDefault();
	
	var a = $("#a").val();
	var b = $("#b").val();
	
	//Chamando, via ajax, o recurso "sum" do servidor REST java (back-end)
	var settings = {
		url : 'api/calculator/sum',
		type : 'POST',
		data : '{"a" : "' + a + '", "b" : "' + b + '"}',
		contentType : 'application/json'
	};

	//callback functions
	$.ajax(settings).done(somaOK);
	
};
*/

//Utilizando função JSON.stringify, que converte um objeto JavaScript 
//em uma string JSON.
/*
function somar(event){
	
	event.preventDefault();
	
	//objeto JavaScript
	var input = {
		a : $("#a").val(),
		b : $("#b").val()
	};
	
	// Chamando, via ajax, o recurso/serviço "sum" do servidor REST java (back-end)
	var settings = {
		url : 'api/calculator/sum',
		type : 'POST',
		data : JSON.stringify(input),
		contentType : 'application/json'
	};

	//callback functions
	$.ajax(settings).done(somaOK);
	
};
*/

//Fazendo a separação (controller x proxy):
//
//Os proxies não conhecem os elementos de tela "front-end html" e 
//os controllers não conhecem os detalhes da integração com os serviços REST
//
//Essa proposta molda o front-end no padrão MVC (model/view/controller)? 
//
//Os elementos de tela (input, form, etc) seriam o V, os proxies seriam o M, 
//e os controllers seriam o C. 
//
//Organização (para garantir o baixo acoplamento):
//
//Um controlador para cada tela "front-end html" e
//Um proxy para cada recurso e seu(s) serviço(s) "disponibilizado no back-end REST"
function somar(event){
	
	event.preventDefault();
	
	//objeto JavaScript
	var input = {
		a : $("#a").val(),
		b : $("#b").val()
	};
	
	// Chamando, via proxy, o serviço "sum" do recurso Calculador no servidor REST java (back-end)
	Calculator.sum(input).done(somaOK);
	
};

function somaOK(data){
	$("#result").val(data);
};