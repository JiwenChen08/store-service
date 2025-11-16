package com.quicklunch.store.service;

import com.quicklunch.store.convert.StoreDTOConvert;
import com.quicklunch.store.domain.model.store.Store;
import com.quicklunch.store.domain.repository.StoreRepository;
import com.quicklunch.store.dto.StoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreAppService {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private StoreDTOConvert storeDTOConvert;


    public StoreDTO findById(Long storeId) {
        Store store = storeRepository.findById(storeId);
        return storeDTOConvert.toDTO(store);
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
