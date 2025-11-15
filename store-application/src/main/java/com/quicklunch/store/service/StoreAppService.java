package com.quicklunch.store.service;

import com.quicklunch.store.domain.repository.StoreRepository;
import com.quicklunch.store.dto.StoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreAppService {

    @Autowired
    private StoreRepository storeRepository;


    public StoreDTO findById(Long storeId) {

        return new StoreDTO();
    }

    public StoreDTO updateById(StoreDTO storeDTO) {

        return new StoreDTO();
    }

    public StoreDTO updateStatus(Long storeId, Integer status) {

        return null;
    }

    public StoreDTO updateOperatingStatus(Long storeId, Integer operating) {
        return null;
    }


}
