package com.adriens.colisnc.api;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {
    
    @Autowired
    private MockMvc rest;

    @Test
    public void testMinimal() throws Exception {
        rest
            .perform(get("/colis/CA107308006SI").accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk());
    }
}
