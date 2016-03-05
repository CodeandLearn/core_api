package Core.Plugin.Hello;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicLong;

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