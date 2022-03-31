package org.example.swagger.test;

import org.example.scheduled.DataImportScheduledTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileWriter;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
public class SwaggerDocDownloaderApplicationTests {

    private static final String DOCS_PATH = "/v3/api-docs";

    private static final String API_DOC_FILE = "./doc/api.json";

    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * Download API documentation.
     *
     * @throws Exception
     */
    @Test
    public void downloadOpenAPiDoc() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders.get(DOCS_PATH).accept(MediaType.APPLICATION_JSON)).andDo(mvcResult -> {
            mvcResult.getResponse();

            try (FileWriter fileWriter = new FileWriter(new File(API_DOC_FILE))) {
                FileCopyUtils.copy(mvcResult.getResponse().getContentAsString(), fileWriter);
            }
        });

    }
}
