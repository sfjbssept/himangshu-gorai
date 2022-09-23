package com.secure.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@WebMvcTest({ AppController.class })
@ActiveProfiles(value = "true")
public class AppControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Value("${employee.post.url}")
	private String postURL;

	@Value("${employee.get.url}")
	private String getURL;

	@Value("${employee.get.username}")
	private String user1;

	@Value("${employee.get.password}")
	private String userPwd;

	@Test
	public void getEmployee_Test() throws Exception {
		ResultActions responseEntity = processApiRequest(getURL, HttpMethod.GET, null, null, user1, userPwd);

		try {
			responseEntity.andExpect(status().isOk());
			String result = responseEntity.andReturn().getResponse().getContentAsString();
			assertEquals("Get Details", result);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private ResultActions processApiRequest(String getURL2, HttpMethod get, Object object, Object object2,
			String user12, String userPwd2) {

		return null;
	}
}
