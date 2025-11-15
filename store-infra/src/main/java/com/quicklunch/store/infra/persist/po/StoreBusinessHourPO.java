package com.quicklunch.store.infra.persist.po;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalTime;

@Table("t_store_business_hour")
@Getter
@Setter
public class StoreBusinessHourPO {
    private Long id;

    private Long storeId;

    private Integer dayType;
    private String dayName;

    private LocalTime openTime;
    private LocalTime closeTime;
}
