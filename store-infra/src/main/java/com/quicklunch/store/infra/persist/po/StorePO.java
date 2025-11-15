package com.quicklunch.store.infra.persist.po;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.sql.In;

import java.time.LocalDateTime;

@Table("t_store")
@Getter
@Setter
public class StorePO {
    @Id
    private Long id;
    private String storeNo;
    private String name;
    private String address;
    private String city;
    private String phone;
    private String email;

    private String longitude;
    private String latitude;

    private Integer status;
    private Integer operatingStatus;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
