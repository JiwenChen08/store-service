package com.quicklunch.store.infra.persist.po;

import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalTime;

@Table("t_store_business_hour")
public class StoreBusinessHourPO {
    private Long id;
    private Long storeId;
    private Integer datOfWeek;
    private LocalTime openTime;
    private LocalTime closeTime;
}
