package com.quicklunch.store.domain.model.store;

import com.quicklunch.store.domain.model.enums.DayTypeEnum;
import lombok.Data;

import java.time.LocalTime;

@Data
public class BizHour {
    private DayTypeEnum dayType;
    private LocalTime openTime;
    private LocalTime closeTime;
}
