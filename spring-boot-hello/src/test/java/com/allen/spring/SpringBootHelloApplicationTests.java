package com.allen.spring;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;

import com.allen.spring.controller.HelloController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootHelloApplicationTests {

    private MockMvc mockMvc;
    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(HelloController.class)
                .apply(documentationConfiguration(this.restDocumentation)).build();
    }

    @Test
    public void contextLoads() {
        Assert.notNull(mockMvc, "[Assert failed]");
    }

    @Test
    public void testHello() throws Exception {
        this.mockMvc.perform(get("/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andDo(document("index"));
    }

}
