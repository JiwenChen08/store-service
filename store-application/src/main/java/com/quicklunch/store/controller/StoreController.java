package com.quicklunch.store.controller;

import com.quicklunch.store.dto.*;
import com.quicklunch.store.service.StoreAppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreAppService storeAppService;

    @GetMapping("/{storeId}")
    public ResponseEntity<StoreDTO> view(@PathVariable("storeId") Long storeId) {
        StoreDTO storeDTO = storeAppService.findById(storeId);
        return ResponseEntity.ok(storeDTO);
    }


    @PostMapping("/")
    public ResponseEntity<StoreDTO> create(@Valid @RequestBody NewStoreDTO newStoreDTO) {

        StoreDTO storeDTO = storeAppService.create(newStoreDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()       // 当前请求 /stores
                .path("/{id}")              // 拼接 /{id}
                .buildAndExpand(storeDTO.getId())
                .toUri();

        return ResponseEntity.created(location).body(storeDTO);
    }

    @PatchMapping("/{storeId}")
    public ResponseEntity<StoreDTO> update(@PathVariable("storeId") Long storeId,
                                           @Validated @RequestBody StoreDTO storeDTO) {


        return null;
    }

    @PatchMapping("/{storeId}/status")
    public ResponseEntity<StoreDTO> updateStatus(@PathVariable("storeId") Long storeId,
                                                 @RequestBody StoreStatusDTO storeStatus) {
        return null;
    }

    @PatchMapping("/{storeId}/operating_status")
    public ResponseEntity<StoreDTO> updateOperatingStatus(@PathVariable("storeId") Long storeId,
                                                          @RequestBody StoreOperatingStatusDTO operatingStatus) {

        return null;
    }

    @PatchMapping("/{storeId}/biz_hours")
    public ResponseEntity<StoreBizHourDTO> updateStoreBizHours(@PathVariable("storeId") Long storeId,
                                                               @RequestBody StoreBizHourDTO storeBizHourDTO) {
        return null;
    }


}
