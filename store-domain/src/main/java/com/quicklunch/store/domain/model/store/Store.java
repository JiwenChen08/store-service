package com.quicklunch.store.domain.model.store;

import com.quicklunch.store.domain.model.enums.StoreOperatingStatusEnum;
import com.quicklunch.store.domain.model.enums.StoreStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Store {

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

    private StoreStatusEnum status;
    private StoreOperatingStatusEnum operatingStatus;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private List<BizHour> bizHourList;

    public Store() {
    }

    public void init() {
        this.status = StoreStatusEnum.CREATED;
        this.operatingStatus = StoreOperatingStatusEnum.CLOSE;
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    // Store Status
    public void pending() {
        this.status = StoreStatusEnum.PENDING;
    }

    public void open() {
        this.status = StoreStatusEnum.OPEN;
    }

    public void close() {
        this.status = StoreStatusEnum.CLOSE;
    }


}
