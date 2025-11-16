package com.quicklunch.store.common.utils;

import java.util.Arrays;

public class EnumUtils {

    /**
     * 根据 value 获取 Enum
     */
    public static <E extends Enum<E> & BaseEnum<V>, V> E valueOf(Class<E> enumClass, V value) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElse(null); // 或抛异常
    }

    /**
     * Enum 转 value
     */
    public static <E extends Enum<E> & BaseEnum<V>, V> V toValue(E enumInstance) {
        return enumInstance == null ? null : enumInstance.getValue();
    }


    /**
     * Enum 转 value
     */
    public static <E extends Enum<E> & BaseEnum<V>, V> String toName(E enumInstance) {
        return enumInstance == null ? null : enumInstance.name();
    }

    /**
     * Enum 转 value
     */
    public static <E extends Enum<E> & BaseEnum<V>, V> String toDesc(E enumInstance) {
        return enumInstance == null ? null : enumInstance.getDesc();
    }
}