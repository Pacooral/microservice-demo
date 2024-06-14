package org.example.userservice;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserServiceApplicationTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void signinTest() throws Exception {
        String url = "/signin/name?username=123&password=123";
        System.out.println(mockMvc);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON_UTF8)).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        String content = response.getContentAsString();
        System.out.println("status:" + status);
        System.out.println("content:" + content);
    }

    @Test
    public void signupTest() throws Exception {
        String url = "/signup/name";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON_UTF8).param("username","David").param("password","123456")).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        String content = response.getContentAsString();
        System.out.println("status:" + status);
        System.out.println("content:" + content);
    }

}
