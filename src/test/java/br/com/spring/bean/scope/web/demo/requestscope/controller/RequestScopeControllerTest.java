package br.com.spring.bean.scope.web.demo.requestscope.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * TTest the bean state when there is more than one request to de API and the bean scope was RequestScope.
 * Whenever a new request arrives inside the server, new instance of the bean annotated with RequestScope would be created.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class RequestScopeControllerTest {

    @Autowired
    private RequestScopeController controller;

    @Autowired
    private MockMvc mvc;

    @Test
    public void test_getMethod_whenWebResource_receive_moreThan_oneRequest_withNoParameter_firstCall() throws Exception {
        this.mvc.perform(get("/request/scope")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.oldName", is("Hello World!")))
                .andExpect(jsonPath("$.name", is("Value of attribute name was changed!")));
    }

    @Test
    public void test_getMethod_whenWebResource_receive_moreThan_oneRequest_withNoParameter_secondCall() throws Exception {
        this.mvc.perform(get("/request/scope")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.oldName", is("Hello World!")))
                .andExpect(jsonPath("$.name", is("Value of attribute name was changed!")));
    }

    @Test
    public void test_getMethod_whenWebResource_receive_moreThan_oneRequest_withNameParameter_thirdCall() throws Exception {
        this.mvc.perform(get("/request/scope/new_value")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.oldName", is("Hello World!")))
                .andExpect(jsonPath("$.name", is("new_value")));
    }



}
