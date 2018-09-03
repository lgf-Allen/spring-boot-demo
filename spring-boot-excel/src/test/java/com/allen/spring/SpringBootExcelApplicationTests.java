//package com.allen.spring;
//
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.JUnitRestDocumentation;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.allen.spring.controller.HelloController;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//// @WebMvcTest(HelloController.class)
//// @AutoConfigureRestDocs(outputDir = "target/snippets")
//public class SpringBootExcelApplicationTests {
//
//    @Rule
//    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");
//
//    // @Autowired
//    private MockMvc mockMvc;
//
//    @Before
//    public void setUp() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloController())
//                .apply(documentationConfiguration(this.restDocumentation)).build();
//    }
//
//    @Test
//    public void contextLoads() {
//        Assert.assertNotNull(mockMvc);
//    }
//
//    @Test
//    public void testHello() throws Exception {
//        this.mockMvc.perform(get("/hello").accept(MediaType.APPLICATION_JSON))
//                .andDo(print()).andExpect(status().isOk())
//                .andDo(document("index"));
//    }
//
//}
