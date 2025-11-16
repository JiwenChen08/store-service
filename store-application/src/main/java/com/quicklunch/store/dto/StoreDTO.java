package com.quicklunch.store.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class StoreDTO {

    private Long id;
    private String storeNo;
    private String name;

    private String address;

    private Long cityId;
    private String cityName;
    private String phone;
    private String email;

    private String longitude;
    private String latitude;

    private Integer status;
    private Integer operatingStatus;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private List<BizHourDTO> businessHourList;

}
