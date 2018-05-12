package org.pathwaycommons.factoid.nlp;

import org.clulab.reach.export.apis.ApiRuler;
import org.junit.Ignore;
import org.junit.Test;
import java.util.Map;

/*
 * Remarks.
 *
 * The reach system can be used via its web service, e.g., at reach.baderlab.org:
 *
 * curl -XPOST -F 'file=@myfile.txt' http://reach.baderlab.org/api/uploadFile
 *
 * (myfile.txt is a file that contains e.g. the example text string below, or an abstract, paper in plain text...)
 *
 * or, build and run from reach sources a local ws, using
 * sbt 'run-main org.clulab.reach.export.server.ApiServer' or using the fat jar
 * (e.g., see https://github.com/PathwayCommons/reach-docker/blob/master/Dockerfile)
 * and then, again, -
 *
 * curl -XPOST -F 'file=@myfile.txt' http://localhost:8080/api/uploadFile
 * curl -XPOST -d 'text=Inhibition+of+AICAR+suppresses+the+phosphorylation+of+TBC1D1.' http://localhost:8080/api/textBody
 *
 * etc. fun staff.
 */

@Ignore
public class ReachTest {
    /**
     * Example call into the Reach system, providing textual input and receiving a JSON string in a result Map.
     * (have to start Reach's ProcessorServer from the repo, using sbt, or from the assembly fat jar
     * (not org.clulab.reach.export.server.ApiServer).
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
