package hello;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public HttpStatus save(@RequestBody Company company) throws IOException {
        FileOutputStream fout = new FileOutputStream("~/build/output.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(company);
        }
        return HttpStatus.OK;
    }

    @RequestMapping("/read")
    public Company read() throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream("~/build/output.ser");
        try (ObjectInputStream reader = new ObjectInputStream(fin)) {
            return (Company) reader.readObject();
        }
    }

}
