package com.quicklunch.store.dto.store;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class StoreDTO {

    private Long id;

    @NotBlank
    private String storeNo;
    @NotBlank
    private String name;
    @NotNull
    private String address;

    private Long cityId;
    @NotBlank
    private String cityName;
    @NotNull
    private String phone;
    @Email
    private String email;

    private String longitude;
    private String latitude;

    private Integer status;
    private Integer operatingStatus;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    @NotNull
    private List<@Valid BizHourDTO> bizHourList;

}
