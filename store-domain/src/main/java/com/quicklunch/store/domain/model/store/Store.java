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
    private String postCode;

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

//    public static Store create(String storeNo,
//                               String name,
//                               String address,
//                               String city,
//                               String phone,
//                               String email,
//                               String longitude,
//                               String latitude) {
//
//        Store store = new Store();
//        store.setStoreNo(storeNo);
//        store.setName(name);
//        store.setAddress(address);
//        store.setCityName(city);
//        store.setPhone(phone);
//        store.setEmail(email);
//
//        store.setLongitude(longitude);
//        store.setLatitude(latitude);
//
//        store.setStatus(StoreStatusEnum.CREATED);
//        store.setOperatingStatus(StoreOperatingStatusEnum.CLOSE);
//
//        store.setCreateAt(LocalDateTime.now());
//        store.setUpdateAt(LocalDateTime.now());
//
//        store.setBizHourList(new ArrayList<>());
//
//        return store;
//    }

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

    public void updateBusinessHours(List<BizHour> bizHourList) {
        if (bizHourList == null) return;
        this.bizHourList = bizHourList;
    }

    public void updateLocation(String longitude, String latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
