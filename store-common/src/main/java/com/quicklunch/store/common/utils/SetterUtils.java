package com.quicklunch.store.common.utils;

import java.util.Optional;
import java.util.function.Consumer;

public class SetterUtils {
    public static <T> void setIfPresent(T value, Consumer<T> setter) {
        Optional.ofNullable(value).ifPresent(setter);
    }
}
