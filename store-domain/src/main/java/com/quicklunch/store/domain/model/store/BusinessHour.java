package com.quicklunch.store.domain.model.store;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record BusinessHour(
        DayOfWeek dayType,
        LocalTime openTime,
        LocalTime closeTime
) {
}
