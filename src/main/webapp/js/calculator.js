/**
 * Proxy para integração com o(s) serviço(s) do recurso 
 * Calculator (back-end REST java). 
 */
//Variavel Calculator (chave:function), como um agregado 
//de serviços do recurso REST 'Calculator' disponível no back-end java
var Calculator = {
 
	//Serviço soma
    sum : function(input) {//função anônima
    	
        var settings = {
        	//api/ --> pronto de acesso para a API REST
        	//calculator/ --> recurso da API REST
        	//sum/ --> serviço do recurso 'calculator' da API REST
            url : 'api/calculator/sum',
            type : 'POST',
            data : JSON.stringify(input),
            contentType : 'application/json'
        };
 
        return $.ajax(settings);
        
    }

};