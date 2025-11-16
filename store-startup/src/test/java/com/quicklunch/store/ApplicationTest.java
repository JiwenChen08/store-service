package com.quicklunch.store;

import com.quicklunch.store.controller.StoreController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private StoreController storeController;


    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {

        assertThat(storeController).isNotNull();
    }
}
