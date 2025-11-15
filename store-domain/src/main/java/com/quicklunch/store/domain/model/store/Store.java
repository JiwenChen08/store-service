package com.quicklunch.store.domain.model.store;

import com.quicklunch.store.domain.model.common.Location;
import com.quicklunch.store.domain.model.enums.StoreOperatingStatusEnum;
import com.quicklunch.store.domain.model.enums.StoreStatusEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter(AccessLevel.PRIVATE)
public class Store {

    private Long id;
    private Long storeCode;

    private String name;

    private String address;

    private String city;
    private String phone;
    private String email;

    private Location location;

    private StoreStatusEnum status;
    private StoreOperatingStatusEnum operatingStatus;

    private Map<DayOfWeek, BusinessHour> businessHourMap = new HashMap<>();


    private LocalDateTime createAt;
    private LocalDateTime updateAt;


    private Store() {

    }

    public static Store create(String name,
                               String address,
                               String city,
                               String phone,
                               String email,
                               String longitude,
                               String latitude) {

        Store store = new Store();

        store.setName(name);
        store.setAddress(address);
        store.setCity(city);
        store.setPhone(phone);
        store.setEmail(email);

        store.setLocation(new Location(longitude, latitude));

        store.setStatus(StoreStatusEnum.CREATED);
        store.setOperatingStatus(StoreOperatingStatusEnum.CLOSE);

        store.setCreateAt(LocalDateTime.now());
        store.setUpdateAt(LocalDateTime.now());

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


    //
    public void updateBusinessHour(Map<DayOfWeek, BusinessHour> businessHourMap) {
        if (businessHourMap == null) {
            return;
        }
        this.businessHourMap.putAll(businessHourMap);
    }

    public void updateLocation(Location location) {
        this.location = location;
    }

}
