package com.quicklunch.store.infra.persist.repository;

import com.quicklunch.store.infra.persist.po.StorePO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JdbcStoreRepository extends
        PagingAndSortingRepository<StorePO, Long>,
        CrudRepository<StorePO, Long> {

}
