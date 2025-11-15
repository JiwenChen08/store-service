package com.quicklunch.store.domain.repository;

import com.quicklunch.store.domain.model.store.Store;

public interface StoreRepository {

    void save(Store store);

    Store findById(Long id);

}
