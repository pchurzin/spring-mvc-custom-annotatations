package ru.pchurzin.spring.customannotations;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig(WebConfig.class)
class TestControllerTest {

    @Test
    void testHandlingNoParamsRequest() throws Exception {
        TestController controller = new TestController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(result ->
                        assertEquals(TestController.HANDLE_REQUEST_WITHOUT_PARAMS, result.getResponse().getContentAsString()));
    }
}