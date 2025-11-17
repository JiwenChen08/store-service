package com.quicklunch.store.controller;

import com.quicklunch.store.common.utils.JsonUtils;
import com.quicklunch.store.dto.NewStoreDTO;
import com.quicklunch.store.dto.StoreDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StoreCreateTest {

    @Autowired
    private StoreController storeController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertThat(storeController).isNotNull();
    }

    @Test
    void TestView() throws Exception {
        mockMvc.perform(get("/stores/100"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void TestCreateFailed() throws Exception {

        String storeJson = """
                {
                    "name": "Hello Kitty"
                }
                """;

        NewStoreDTO parse = JsonUtils.parse(storeJson, NewStoreDTO.class);
        mockMvc.perform(post("/stores/")
                        .contentType("application/json")
                        .content(storeJson)
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message.address").value("must not be blank"));
    }

    @Test
    void TestCreateSuccess() throws Exception {

        String storeJson = """
                {
                  "name": "Starlight Convenience Store",
                  "address": "100 Jianguo Road, Chaoyang District, Beijing",
                  "cityName": "Beijing",
                  "phone": "+86-10-12345678",
                  "email": "StarlightConvenienceStore@quickluch.com",
                  "bizHourList": [
                    {
                      "dayType": "1",
                      "openTime": "09:00",
                      "closeTime": "21:00"
                    },
                    {
                      "dayType": "2",
                      "openTime": "09:00",
                      "closeTime": "21:00"
                    },
                    {
                      "dayType": "3",
                      "openTime": "09:00",
                      "closeTime": "21:00"
                    }
                  ]
                }
                """;
        mockMvc.perform(post("/stores/")
                        .contentType("application/json")
                        .content(storeJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.storeNo").isNotEmpty());

    }


}
