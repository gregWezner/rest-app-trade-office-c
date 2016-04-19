package hello;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CompanyController {

    private static Map<String, Company> companyByName = new HashMap<>();
    private static Map<String, Company> companyBySymbol = new HashMap<>();

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public HttpStatus save(@RequestBody Company company) {
        companyByName.put(company.getName(), company);
        companyBySymbol.put(company.getSymbol(), company);
        return HttpStatus.OK;
    }

    @RequestMapping("/read/name")
    public Company readByCompany(@RequestParam String name) {
        return companyByName.get(name);
    }

    @RequestMapping("/read/symbol")
    public Company readBySymbol(@RequestParam String name) {
        return companyByName.get(name);
    }

}
