package com.quicklunch.store.dto.store;


import com.quicklunch.store.dto.page.PageQueryDTO;

public class StoreQueryDTO extends PageQueryDTO {
    private String storeNo;
    private String name;
    private Long cityId;
    private Long phone;
}
