package org.pathwaycommons.factoid.nlp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    public Controller() {
    }

    @RequestMapping("/")
    public String index() {
        return "Hello!";
    }

}
