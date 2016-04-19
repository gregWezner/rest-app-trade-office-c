package hello;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public HttpStatus save(@RequestBody Company company) throws IOException {

        FileOutputStream fout = new FileOutputStream("output.ser");

        try (ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(company);
        }
        return HttpStatus.OK;
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
