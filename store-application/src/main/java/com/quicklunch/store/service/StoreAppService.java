package com.quicklunch.store.service;

import com.quicklunch.store.convert.StoreDTOConvert;
import com.quicklunch.store.domain.model.store.Store;
import com.quicklunch.store.domain.repository.StoreRepository;
import com.quicklunch.store.dto.NewStoreDTO;
import com.quicklunch.store.dto.StoreDTO;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StoreAppService {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private StoreDTOConvert storeDTOConvert;


    public StoreDTO findById(Long storeId) {
        Store store = storeRepository.findById(storeId);
        if (store == null) {
            throw new NoSuchElementException("storeId=" + storeId + " doesn't exist.");
        }

        return storeDTOConvert.toDTO(store);
    }

    public StoreDTO create(NewStoreDTO newStoreDTO) {

        // TODO unique no generator
        int no = RandomUtils.secure().randomInt(0, 10000);
        String storeNo = "ST" + StringUtils.leftPad(String.valueOf(no), 5,'0');

        Store store = storeDTOConvert.fromNewStoreDTO(newStoreDTO, storeNo);
        store.init();

        Store save = storeRepository.save(store);

        return storeDTOConvert.toDTO(save);
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
