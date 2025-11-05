package com.quicklunch.store.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreDTO {
    private Long id;
    private String name;
    private Long cityId;
    private String cityName;
    private String lon;
    private String lat;
    private String phone;
    private String email;
    private String address;
}
