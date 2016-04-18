package org.pathwaycommons.factoid.nlp;

import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@RestController
public class FactoidNlpController {

    private final SentenceDetector sentenceDetector;

    FactoidNlpController() {
        InputStream is = null;
        try {
            is = getClass().getResourceAsStream("/en-sent.bin");
            SentenceModel sentenceModel = new SentenceModel(is);
            sentenceDetector = new SentenceDetectorME(sentenceModel);
        } catch (Exception e) {
            throw new RuntimeException("Failed to init SentenceModel (using en-sent.bin)", e);
        } finally {
            if (is != null) { //close quietly
                try {is.close();} catch (IOException e) {}
            }
        }
    }

    @RequestMapping("/sentences")
    public List<String> sentences(@RequestParam String query) {
        String[] sentences = sentenceDetector.sentDetect(query);
        return Arrays.asList(sentences);
//        return Arrays.asList("a","b","c");
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
