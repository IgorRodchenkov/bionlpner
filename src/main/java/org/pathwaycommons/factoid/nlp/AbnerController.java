package org.pathwaycommons.factoid.nlp;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class AbnerController {

    public AbnerController() {
    }

    @RequestMapping("/abner")
    public String abner(@RequestParam String query) {
        return query; //TODO
    }

    @RequestMapping("/")
    public String index() {
        return "Hello!";
    }

}
