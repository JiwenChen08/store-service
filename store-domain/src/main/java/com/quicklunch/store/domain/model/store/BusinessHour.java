package com.quicklunch.store.domain.model.store;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
public class BusinessHour {
    private Long storeId;
    private DayOfWeek dayType;
    private LocalTime openTime;
    private LocalTime closeTime;
}
