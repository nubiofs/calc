package calc.rest;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("calculator")
public class CalculatorREST {
	
	//No Postman (para '@Consumes("application/x-www-form-urlencoded")':
	//
	//URL -> http://localhost:8080/calc/api/calculator/sum
	//Body -> x-www-form-urlencoded
	//		a=1
	//		b=2
	//Método -> POST
	//
	/*
	@POST
	@Path("sum")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("text/plain")
	public Integer sum(@FormParam("a") Integer a, @FormParam("b") Integer b) {
		return a + b;
	}
	*/
	
	//No Postman (para '@Consumes("application/json")'):
	//
	//URL -> http://localhost:8080/calc/api/calculator/sum
	//Body -> raw
	//		{
	//			"a":"1",
	//			"b":"2"
	//		}
	//'Content-Type' -> JSON(application/json)
	//Método -> POST
	//
	/*
	@POST
	@Path("sum")
	@Consumes("application/json")
	@Produces("text/plain")
	public Integer sum(Numero num) {
		return num.a + num.b;
	}
	*/

	//No Postman (para '@Consumes("application/xml")'):
	//
	//URL -> http://localhost:8080/calc/api/calculator/sum
	//Body -> raw
	//		<numero>
	//			<a>1</a>
	//			<b>2</b>
	//		</numero>
	//'Content-Type' -> JSON(application/xml)
	//Método -> POST
	//
	/*
	@POST
	@Path("sum")
	@Consumes("application/xml")
	@Produces("text/plain")
	public Integer sum(Numero num) {
		return num.a + num.b;
	}
	*/

	//No Postman (para '@Consumes({"application/json", "application/xml"})'):
	//
	//URL -> http://localhost:8080/calc/api/calculator/sum
	//Body -> raw
	//		<numero>
	//			<a>1</a>
	//			<b>2</b>
	//		</numero>
	//
	//	"ou":
	//
	//		{
	//			"a":"1",
	//			"b":"2"
	//		}
	//
	//'Content-Type' -> JSON(application/xml) "ou" JSON(application/json) 
	//Método -> POST
	//
	@POST
	@Path("sum")
	@Consumes({"application/json", "application/xml"})
	@Produces("text/plain")
	//Para a integração entre a implementação JAX-RS 1.1 com a Bean Validation.
	@ValidatePayload
	public Integer sum(Numero num) {
		return num.a + num.b;
	}
	
	//Anotação para @Consumes("application/xml")
	@XmlRootElement
	public static class Numero {
		
		/*
		 * Para Body "ray" (application/json) da solicitação com:
		 * 
		 * {
		 *		"a":"  ",
		 *		"b":""
		 *	}
		 * 
		 * Tem-se o Body do retorno:
		 * 
		 * [ 
		 * 		{ "property": "b", "message": "não pode ser nulo" }, 
		 * 		{ "property": "a", "message": "não pode ser nulo" } 
		 * ]
		 * 
		 * Com status: 422 que representa uma "Unprocessable Entity"
		 * (Definido pelo demoiselle para um erro provocado pela requisição do cliente 
		 * no qual indica um problema de semântica "no caso dados nulos")
		 * 
		 */		
		
		@NotNull
		public Integer a;
		
		@NotNull
		public Integer b;
		
	}
	
}
