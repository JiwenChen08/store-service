package com.quicklunch.store.infra.persist.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("t_store")
public class StorePO {
    @Id
    private Long id;
    private String storeCode;
    private String name;
}
