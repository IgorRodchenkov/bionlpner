package org.pathwaycommons.factoid.nlp;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class FactoidNlpController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot (factoid-nlp)!";
    }

}
