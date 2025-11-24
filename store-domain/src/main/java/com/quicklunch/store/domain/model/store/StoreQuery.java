package com.quicklunch.store.domain.model.store;

import com.quicklunch.store.domain.model.common.PageQuery;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreQuery extends PageQuery {
    private String storeNo;
    private String name;
    private Long cityId;
    private String phone;
    private String email;
    private Long id;
}
