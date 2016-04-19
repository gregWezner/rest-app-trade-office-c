package hello;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/save")
    public Greeting save(@RequestParam(value="name", defaultValue="World") String name) throws IOException {

        Path path = Paths.get("output.js");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(String.format(template, name));
        }
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/read")
    public Greeting read() throws IOException {

        Path path = Paths.get("output.js");
        String val;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            val = String.format(template, reader.readLine());
        }
        return new Greeting(counter.incrementAndGet(),
                val);
    }

}
