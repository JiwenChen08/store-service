package com.quicklunch.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreBusinessHourDTO {
    private Integer dayOfWeek;
    private LocalTime openTime;
    private LocalTime closeTime;
}
