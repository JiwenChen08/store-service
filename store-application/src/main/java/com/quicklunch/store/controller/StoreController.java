package com.quicklunch.store.controller;

import com.quicklunch.store.dto.page.PageDTO;
import com.quicklunch.store.dto.store.NewStoreDTO;
import com.quicklunch.store.dto.store.StoreDTO;
import com.quicklunch.store.dto.store.StoreQueryDTO;
import com.quicklunch.store.service.StoreAppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreAppService storeAppService;


    @GetMapping
    public ResponseEntity<PageDTO<StoreDTO>> list(StoreQueryDTO queryDTO) {
        PageDTO<StoreDTO> all = storeAppService.list(queryDTO);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<StoreDTO> readOne(@PathVariable("storeId") Long storeId) {
        StoreDTO storeDTO = storeAppService.findById(storeId);
        return ResponseEntity.ok(storeDTO);
    }


    @PostMapping("/")
    public ResponseEntity<StoreDTO> createOne(@Valid @RequestBody NewStoreDTO newStoreDTO) {

        StoreDTO storeDTO = storeAppService.create(newStoreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(storeDTO);
    }

    @PutMapping("/{storeId}")
    public ResponseEntity<StoreDTO> updateOne(@PathVariable("storeId") Long storeId,
                                              @RequestBody StoreDTO storeDTO) {
        storeDTO.setId(storeId);
        StoreDTO updated = storeAppService.updateById(storeDTO);
        return ResponseEntity.ok(updated);
    }


}
