package hello;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {

    private static Map<String, Company> companyByName = new HashMap<>();

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public HttpStatus save(@RequestBody Company company) {
        companyByName.put(company.getName(), company);
        return HttpStatus.OK;
    }

    @RequestMapping("/read/company")
    public Company readByCompany(@RequestParam String name) {
        return companyByName.get(name);
    }

}
