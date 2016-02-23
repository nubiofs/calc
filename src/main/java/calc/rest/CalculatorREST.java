package calc.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

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
	public Integer sum(Numero num) {
		return num.a + num.b;
	}
	
	//Anotação para @Consumes("application/xml")
	@XmlRootElement
	public static class Numero {
		public Integer a;
		public Integer b;
	}
	
}
