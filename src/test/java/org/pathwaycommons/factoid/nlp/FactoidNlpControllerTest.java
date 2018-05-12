package org.pathwaycommons.factoid.nlp;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by rodche on 2016-04-11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoidNlpControllerTest {
    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(
                new AbnerController(),
                new SentencesController(),
                new Controller()).build();
    }

    @Test
    public void getSentences() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/sentences?query=Humpty Dumpty sat on a wall. " +
                "Humpty Dumpty had a great fall. All the king's horses and all the King's men " +
                "couldn't put Humpty Dumpty together again.")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(
                    "[\"Humpty Dumpty sat on a wall.\",\"Humpty Dumpty had a great fall.\"," +
                    "\"All the king's horses and all the King's men couldn't put Humpty Dumpty together again.\"]"));
    }

//    @Test
//    public void getAbner() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/abner?query=hello").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("hello")));
//    }

    @Test
    public void getRoot() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello!")));
    }
}
