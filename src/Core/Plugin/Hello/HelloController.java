package Core.Plugin.Hello;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/hello/{name}")
	public Hello hello(@PathVariable String name) {
		return new Hello(counter.incrementAndGet(), String.format(template, name));
	}
	
	@RequestMapping(value = "/hello/test", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Hello helloTest(@Valid @RequestBody HelloObj helloObj) {
		return new Hello(counter.incrementAndGet(), helloObj.getName());
	}
}