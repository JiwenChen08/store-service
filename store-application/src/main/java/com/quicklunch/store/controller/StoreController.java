package com.quicklunch.store.controller;

import com.quicklunch.store.dto.StoreDTO;
import com.quicklunch.store.service.StoreAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreAppService storeAppService;


    @GetMapping("/{storeId}")
    public ResponseEntity<StoreDTO> view(@PathVariable("storeId") Long storeId) {

        return null;
    }


    @PostMapping
    public ResponseEntity<StoreDTO> create(@RequestBody StoreDTO storeDTO) {
        return null;
    }

    @PatchMapping("/{storeId}")
    public ResponseEntity<StoreDTO> update(@PathVariable("storeId") Long storeId,
                                           @RequestBody StoreDTO storeDTO) {

        return null;
    }

    @PatchMapping("/{storeId}/status")
    public ResponseEntity<StoreDTO> updateStatus(@PathVariable("storeId") Long storeId,
                                                 @RequestBody Map<String, Integer> status) {
        return null;
    }

    @PatchMapping("/{storeId}/operatingStatus")
    public ResponseEntity<StoreDTO> updateOperatingStatus(@PathVariable("storeId") Long storeId,
                                                          @RequestBody Map<String, Integer> operatingStatus) {

        return null;
    }


}
