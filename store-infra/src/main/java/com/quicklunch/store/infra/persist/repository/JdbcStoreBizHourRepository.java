package com.quicklunch.store.infra.persist.repository;

import com.quicklunch.store.infra.persist.po.StoreBizHourPO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JdbcStoreBizHourRepository extends
        PagingAndSortingRepository<StoreBizHourPO, Long>,
        CrudRepository<StoreBizHourPO, Long> {

    void deleteByStoreId(Long storeId);

    List<StoreBizHourPO> findListByStoreId(Long storeId);

}
