package org.pathwaycommons.factoid.nlp;

import abner.Tagger;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


@RestController
public class AbnerController {

    private final Tagger tagger;

    public AbnerController() {
        tagger = new Tagger(); //Loads the "NLPBA" model by default (alt.: "BioCreative")
    }

    /**
     * Get matching "segments" using (pre-trained) Abner API.
     *
     * See http://pages.cs.wisc.edu/~bsettles/abner/javadoc/abner/Tagger.html
     *
     * @param query input text (may contain gene/protein names, etc., terms)
     * @return the list of [segment, tag]
     */
    @RequestMapping("/abner")
    public List<String[]> abner(@RequestParam String query) {
        final List<String[]> ret = new ArrayList<String[]>();

        final Vector<String[][]> segments = tagger.getSegments(query);
        for(String[][] seg : segments) {
            Assert.isTrue(seg.length==2);
            String[] tokens = seg[0];
            String[] tags = seg[1];
            Assert.isTrue(tokens.length == tags.length);
            for(int i=0; i < tokens.length; i++) {
                String tag = tags[i];
                if(tag != null && tag.length() > 1) //skip "other" segments (no genomic)?
                    ret.add(new String[]{tokens[i], tags[i]});
            }
        }

        return ret;
    }

}
