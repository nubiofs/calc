package calc.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("calculator")
public class CalculatorREST {
	
	@POST
	@Path("sum")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("text/plain")
	public Integer sum(@FormParam("a") Integer a, @FormParam("b") Integer b) {
		return a + b;
	}

}
