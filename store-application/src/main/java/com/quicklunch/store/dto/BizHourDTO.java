package com.quicklunch.store.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BizHourDTO {

    @NotNull
    @Range(min = 1, max = 7)
    private Integer dayType;
    private String dayName;
    private LocalTime openTime;
    private LocalTime closeTime;
}
