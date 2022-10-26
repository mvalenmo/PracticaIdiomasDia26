package ntt.data.bootcamp.pruebasclientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.saludoidioma.domain.Saludo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class PruebaController {
	@Autowired
	private Saludo saludo;
	
	private Counter counter;

	public PruebaController(MeterRegistry registry) {
	        this.counter = Counter.builder("invocaciones.hello").description("Invocaciones totales").register(registry);
	    }

	@GetMapping(path="/helloWorld")
	    public String helloWorld() {
	        counter.increment();
	        return "hello World";
	    }
	@GetMapping(path="/prueba")
	public String pruebaSaludo() {
		return saludo.mensajeSaludo();
	}

}
