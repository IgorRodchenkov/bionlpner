package org.pathwaycommons.factoid.nlp;


import org.clulab.reach.export.apis.ApiRuler;
import org.junit.Ignore;
import org.junit.Test;
import java.util.Map;

@Ignore //TODO: start/init Reach?
public class ReachTest {

    /**
     * Example call into the Reach system, providing textual input and
     * receiving a JSON string in a result Map.
     * (start the server separately, from reach repo as: sbt 'run-main org.clulab.processors.server.ProcessorServer')
     */
    @Test
    public void testText() {
        // the text to be passed to Reach:
        String text = "The inhibition of AICAR suppresses the phosphorylation of TBC1D1.\n";

        // The return value is a java.util.Map with information about the status of the call.
        // Valid JSON output formats are 'fries' and 'indexcard'.
        Map resultMap = ApiRuler.annotateText(text, "indexcard");

        // Check for a processing error on return
        if ((boolean)resultMap.get("hasError"))
            // if there was a processing error, retrieve the error message
            System.err.println(resultMap.get("errorMessage"));
        else
            // if there was not an error, then the result JSON is available
            System.out.println(resultMap.get("resultJson"));
    }
}
