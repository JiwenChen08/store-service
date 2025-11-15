package com.quicklunch.store.infra.convert;

import com.quicklunch.store.domain.model.store.BusinessHour;
import com.quicklunch.store.infra.persist.po.StoreBusinessHourPO;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class BusinessHourPOConvert {

    public StoreBusinessHourPO toPO(BusinessHour businessHour) {
        if (businessHour == null) {
            return null;
        }

        StoreBusinessHourPO storeBusinessHourPO = new StoreBusinessHourPO();
        storeBusinessHourPO.setStoreId(businessHour.getStoreId());

        DayOfWeek dayType = businessHour.getDayType();
        if (dayType!=null) {
            storeBusinessHourPO.setDayType(dayType.getValue());
            storeBusinessHourPO.setDayName(dayType.name());
        }

        storeBusinessHourPO.setOpenTime(businessHour.getOpenTime());
        storeBusinessHourPO.setCloseTime(businessHour.getCloseTime());

        return storeBusinessHourPO;
    }


    public BusinessHour toDO(StoreBusinessHourPO businessHourPO) {
        if (businessHourPO == null) {
            return null;
        }
        BusinessHour businessHour = new BusinessHour();
        businessHour.setStoreId(businessHourPO.getStoreId());

        DayOfWeek dayOfWeek = DayOfWeek.of(businessHourPO.getDayType());
        businessHour.setDayType(dayOfWeek);

        businessHour.setOpenTime(businessHourPO.getOpenTime());
        businessHour.setCloseTime(businessHourPO.getCloseTime());
        return businessHour;
    }


}
