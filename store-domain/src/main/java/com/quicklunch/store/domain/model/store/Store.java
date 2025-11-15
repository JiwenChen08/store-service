package com.quicklunch.store.domain.model.store;

import com.quicklunch.store.domain.model.enums.StoreOperatingStatusEnum;
import com.quicklunch.store.domain.model.enums.StoreStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Store {

    private Long id;
    private String storeNo;

    private String name;

    private String address;
    private String city;
    private String phone;
    private String email;

    private String longitude;
    private String latitude;

    private StoreStatusEnum status;
    private StoreOperatingStatusEnum operatingStatus;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private List<BusinessHour> businessHourList;

    public Store() {

    }

    public static Store create(String storeNo,
                               String name,
                               String address,
                               String city,
                               String phone,
                               String email,
                               String longitude,
                               String latitude) {

        Store store = new Store();
        store.setStoreNo(storeNo);
        store.setName(name);
        store.setAddress(address);
        store.setCity(city);
        store.setPhone(phone);
        store.setEmail(email);

        store.setLongitude(longitude);
        store.setLatitude(latitude);

        store.setStatus(StoreStatusEnum.CREATED);
        store.setOperatingStatus(StoreOperatingStatusEnum.CLOSE);

        store.setCreateAt(LocalDateTime.now());
        store.setUpdateAt(LocalDateTime.now());

        store.setBusinessHourList(new ArrayList<>());

        return store;
    }

    // Store Status
    public void pending() {
        this.status = StoreStatusEnum.OPEN;
    }

    public void open() {
        this.status = StoreStatusEnum.OPEN;
    }

    public void close() {
        this.status = StoreStatusEnum.CLOSE;
    }


    // Store Operating Status
    public void operatingOpen() {
        this.operatingStatus = StoreOperatingStatusEnum.OPEN;
    }

    public void operatingClose() {
        this.operatingStatus = StoreOperatingStatusEnum.CLOSE;
    }

    public void updateBusinessHours(List<BusinessHour> businessHourList) {
        if (businessHourList == null) return;
        this.businessHourList = businessHourList;
    }

    public void updateLocation(String longitude, String latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
