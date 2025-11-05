package com.quicklunch.store.controller;

import com.quicklunch.store.controller.dto.StoreDTO;
import com.quicklunch.store.utils.JsonUtils;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {


    @GetMapping("/stores/{id}")
    public ResponseEntity<StoreDTO> query(@PathVariable("id") Long id) {
        if (id != 1024L) {
            return ResponseEntity.noContent().build();
        }

        String demoStore = """
                {
                  "id": 1024,
                  "name": "Sunshine Cafe",
                  "cityId": 33,
                  "cityName": "Berlin",
                  "lon": "13.4050",
                  "lat": "52.5200",
                  "phone": "+49 30 12345678",
                  "email": "contact@sunshinecafe.de",
                  "address": "Alexanderplatz 5, 10178 Berlin, Germany"
                }
                """;

        StoreDTO storeDTO = JsonUtils.parse(demoStore, StoreDTO.class);
        return ResponseEntity.ok(storeDTO);
    }

}