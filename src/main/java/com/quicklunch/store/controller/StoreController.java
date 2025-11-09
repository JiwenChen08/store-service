package com.quicklunch.store.controller;

import com.quicklunch.store.controller.dto.StoreDTO;
import com.quicklunch.store.utils.JsonUtils;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    @Value("${DEFAULT_STORE}")
    private String defaultStore;


    @GetMapping("/stores/{id}")
    public ResponseEntity<StoreDTO> query(@PathVariable("id") Long id) {
        if (id != 1024L) {
            return ResponseEntity.noContent().build();
        }

        StoreDTO storeDTO = JsonUtils.parse(defaultStore, StoreDTO.class);
        return ResponseEntity.ok(storeDTO);
    }

}