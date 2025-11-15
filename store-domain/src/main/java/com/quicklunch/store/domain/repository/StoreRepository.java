package com.quicklunch.store.domain.repository;

import com.quicklunch.store.domain.model.store.Store;

import java.util.Optional;

public interface StoreRepository {

    void save(Store store);

    Store findById(Long id);

    void updateStatus(Long id, Integer status);

    void updateOperatingStatus(Long id, Integer operatingStatus);
}
