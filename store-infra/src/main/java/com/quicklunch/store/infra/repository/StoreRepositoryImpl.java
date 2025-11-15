package com.quicklunch.store.infra.repository;

import com.quicklunch.store.domain.model.store.Store;
import com.quicklunch.store.domain.repository.StoreRepository;
import com.quicklunch.store.infra.convert.StorePOConvert;
import com.quicklunch.store.infra.persist.po.StoreBusinessHourPO;
import com.quicklunch.store.infra.persist.po.StorePO;
import com.quicklunch.store.infra.persist.repository.JdbcStoreBusinessHourRepository;
import com.quicklunch.store.infra.persist.repository.JdbcStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class StoreRepositoryImpl implements StoreRepository {

    @Autowired
    private StorePOConvert storePOConvert;
    @Autowired
    private JdbcStoreRepository jdbcStoreRepository;
    @Autowired
    private JdbcStoreBusinessHourRepository jdbcStoreBusinessHourRepository;


    @Override
    @Transactional
    public void save(Store store) {
        StorePO storePO = storePOConvert.toStorePO(store);
        List<StoreBusinessHourPO> newHourList = storePOConvert.convertBusinessHour(store.getBusinessHourList());

        jdbcStoreRepository.save(storePO);

        jdbcStoreBusinessHourRepository.deleteByStoreId(storePO.getId());
        jdbcStoreBusinessHourRepository.saveAll(newHourList);

    }

    @Override
    public Store findById(Long id) {

        Optional<StorePO> storeOptional = jdbcStoreRepository.findById(id);
        if (storeOptional.isEmpty()) {
            return null;
        }

        StorePO storePO = storeOptional.get();
        List<StoreBusinessHourPO> bHPOList = jdbcStoreBusinessHourRepository.findListByStoreId(id);

        return storePOConvert.toDO(storePO, bHPOList);
    }

    @Override
    public void updateStatus(Long id, Integer status) {

    }

    @Override
    public void updateOperatingStatus(Long id, Integer operatingStatus) {

    }
}
