package com.quicklunch.store.domain.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StoreStatusEnum {

    CREATED(0, "CREATED"),

    OPEN(1, "OPEN"),

    PENDING(2, "PENDING"),

    CLOSE(3, "CLOSE");

    private final int value;
    private final String desc;
}
