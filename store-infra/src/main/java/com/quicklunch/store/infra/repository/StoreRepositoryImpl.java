package com.quicklunch.store.infra.repository;

import com.quicklunch.store.domain.model.store.Store;
import com.quicklunch.store.domain.repository.StoreRepository;
import com.quicklunch.store.infra.persist.repository.JdbcStoreBusinessHourRepository;
import com.quicklunch.store.infra.persist.repository.JdbcStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreRepositoryImpl implements StoreRepository {

    @Autowired
    private JdbcStoreRepository jdbcStoreRepository;
    @Autowired
    private JdbcStoreBusinessHourRepository jdbcStoreBusinessHourRepository;


    @Override
    public void save(Store store) {

    }

    @Override
    public Store findById(Long id) {
        return null;
    }


}
