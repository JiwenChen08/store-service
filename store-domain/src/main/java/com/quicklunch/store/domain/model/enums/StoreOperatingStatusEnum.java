package com.quicklunch.store.domain.model.enums;

import com.quicklunch.store.common.utils.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StoreOperatingStatusEnum implements BaseEnum<Integer> {

    OPEN(1, "OPEN"),

    CLOSE(2, "CLOSE");;

    private final Integer value;
    private final String desc;
}
