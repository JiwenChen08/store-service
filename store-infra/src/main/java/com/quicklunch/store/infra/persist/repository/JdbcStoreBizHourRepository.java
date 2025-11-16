package com.quicklunch.store.infra.persist.repository;

import com.quicklunch.store.infra.persist.po.StoreBizHourPO;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JdbcStoreBizHourRepository extends ListCrudRepository<StoreBizHourPO, Long> {

    void deleteByStoreId(Long storeId);

    List<StoreBizHourPO> findListByStoreId(Long storeId);

}
