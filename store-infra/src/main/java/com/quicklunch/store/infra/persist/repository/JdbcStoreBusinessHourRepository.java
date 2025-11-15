package com.quicklunch.store.infra.persist.repository;

import com.quicklunch.store.infra.persist.po.StoreBusinessHourPO;
import com.quicklunch.store.infra.persist.po.StorePO;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JdbcStoreBusinessHourRepository extends ListCrudRepository<StoreBusinessHourPO, Long> {

    void deleteByStoreId(Long storeId);

    List<StoreBusinessHourPO> findListByStoreId(Long storeId);

}
