package ru.pchurzin.spring.customannotations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig(WebConfig.class)
class TestControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    void testHandleRequestWithoutParams() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/test"))
                .andExpect(status().isOk())
                .andExpect(result ->
                        assertEquals(TestController.HANDLE_REQUEST_WITHOUT_PARAMS, result.getResponse().getContentAsString()));
    }

    @Test
    void testHandleRequestWithParams() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders
                .get("/test")
                .param("someparam", "somevalue"))
                .andExpect(status().isOk())
                .andExpect(result ->
                        assertEquals(TestController.HANDLE_REQUEST_WITH_PARAMS, result.getResponse().getContentAsString()));
    }
}