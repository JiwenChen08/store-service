package com.quicklunch.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BizHourDTO {
    private Integer dayType;
    private String dayName;
    private LocalTime openTime;
    private LocalTime closeTime;
}
