package com.quicklunch.store.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quicklunch.store.dto.store.StoreDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;


    @Test
    void TestQuery() throws Exception {
        mockMvc.perform(get("/stores/1"))
                .andDo(print())
                .andExpect(status().isOk());
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
                    }
                  ]
                }
                """;
        mockMvc.perform(post("/stores/")
                        .contentType("application/json")
                        .content(storeJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.storeNo").isNotEmpty());

    }

    @Test
    void TestCreateFailed() throws Exception {

        String storeJson = """
                {
                    "name": "Hello Kitty"
                }
                """;

        mockMvc.perform(post("/stores/")
                        .contentType("application/json")
                        .content(storeJson)
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message.address").value("must not be blank"));
    }


    @Test
    public void testUpdate() throws Exception {

        Long storeId = 11L;

        MvcResult mvcResult = mockMvc.perform(get("/stores/{storeId}", storeId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        StoreDTO storeDTO = mapper.readValue(contentAsString, StoreDTO.class);

        String updateStr = """
                    {
                        "name": "Starlight Convenience Store new",
                        "bizHourList": [
                            {"dayType": 1, "openTime": "09:00:00", "closeTime":"21:00:00"},
                            {"dayType": 3, "openTime": "09:00:00", "closeTime":"21:00:00"},
                            {"dayType": 4, "openTime": "09:00:00", "closeTime":"21:00:00"}
                        ],
                        "longitude": "116.397128",
                         "latitude": "39.916527"
                    }
                """;
        mockMvc.perform(put("/stores/{storeId}", storeId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateStr)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Starlight Convenience Store new"))
                .andExpect(jsonPath("$.bizHourList", hasSize(3)))
                .andExpect(jsonPath("$.address").value(storeDTO.getAddress()))
                .andExpect(jsonPath("$.longitude").value("116.397128"))
                .andExpect(jsonPath("$.latitude").value("39.916527"));

    }




}
