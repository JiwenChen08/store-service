package com.quicklunch.store.domain.model.enums;

import com.quicklunch.store.common.utils.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StoreStatusEnum implements BaseEnum<Integer> {

    CREATED(0, "CREATED"),

    OPEN(1, "OPEN"),

    PENDING(2, "PENDING"),

    CLOSE(3, "CLOSE");

    private final Integer value;
    private final String desc;
}
