package com.quicklunch.store.domain.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StoreOperatingStatusEnum {

    OPEN(1, "OPEN"),

    CLOSE(2, "CLOSE");;

    private final int value;
    private final String desc;
}
