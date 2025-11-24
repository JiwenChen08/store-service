package com.quicklunch.store.dto.store;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewStoreDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String cityName;
    @NotBlank
    private String phone;
    @Email
    private String email;

    private List<@Valid BizHourDTO> bizHourList;
}
