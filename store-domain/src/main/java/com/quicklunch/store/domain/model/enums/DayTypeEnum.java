package com.quicklunch.store.domain.model.enums;

import com.quicklunch.store.common.utils.BaseEnum;
import lombok.Getter;

@Getter
public enum DayTypeEnum implements BaseEnum<Integer> {

    MONDAY(1, "星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(4, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六"),
    SUNDAY(7, "星期日"),
    ;

    DayTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private final Integer value;
    private final String desc;
}
