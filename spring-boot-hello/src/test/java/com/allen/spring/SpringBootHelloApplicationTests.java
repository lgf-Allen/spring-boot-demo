package com.allen.spring;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.allen.spring.controller.UserController;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class SpringBootHelloApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFindUserByUsername() throws Exception {
		this.mockMvc.perform(get("/users/user?username=Lisi"))
					.andDo(print())
					.andExpect(status().isOk())
					.andDo(document("user" ,
							requestParameters(parameterWithName("username").description("Username must not be null or empty.")),
							responseFields(
									fieldWithPath("username").description("Uername"),
									fieldWithPath("password").description("Password"),
									fieldWithPath("age").description("Age"),
									fieldWithPath("gender").description("Gender"))));
	}

}
