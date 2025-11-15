package com.quicklunch.store.infra.persist.repository;

import com.quicklunch.store.infra.persist.po.StoreBusinessHourPO;
import com.quicklunch.store.infra.persist.po.StorePO;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JdbcStoreBusinessHourRepository extends ListCrudRepository<StoreBusinessHourPO, Long> {

}
