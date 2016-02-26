package calc.rest;


import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.hibernate.validator.constraints.Length;

import br.gov.frameworkdemoiselle.util.ValidatePayload;

/**
 * TESTE PARA:
 * 
 * "Exercício - Módulo 1: Básico" - (Atividade Avaliativa - Módulo 1)
 * 
 * (http://localhost:8080/calc/api/concatenacao/concat)
 * 
 * @author 02963357460
 *
 */
@Path("concatenacao")
public class ConcatenacaoREST {

	@POST
	@Path("concat")
	@Consumes("application/json")
	@Produces("application/json")
	@ValidatePayload
	public String concatenar(Bean bean) {
		return bean.getTexto1() + bean.getTexto2();
	}

	public static class Bean {

		@Length(min=2)
		private String texto1;

		@NotNull
		private String texto2;

		public String getTexto1() {
			return texto1;
		}

		public void setTexto1(String texto1) {
			this.texto1 = texto1;
		}

		public String getTexto2() {
			return texto2;
		}

		public void setTexto2(String texto2) {
			this.texto2 = texto2;
		}

	}

}
