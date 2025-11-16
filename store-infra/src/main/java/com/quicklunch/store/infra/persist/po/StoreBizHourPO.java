package com.quicklunch.store.infra.persist.po;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalTime;

@Table("t_store_biz_hour")
@Getter
@Setter
public class StoreBizHourPO {
    private Long id;

    private Long storeId;

    private Integer dayType;
    private String dayName;

    private LocalTime openTime;
    private LocalTime closeTime;
}
