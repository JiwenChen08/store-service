package com.quicklunch.store.domain.model.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageResult<T> {
    private Long total;
    private T data;
}
