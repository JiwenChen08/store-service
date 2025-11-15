package com.quicklunch.store.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StoreDTO implements Serializable {
    private Long id;
    private String storeCode;
    private String name;

}
