package com.quicklunch.store.infra.convert;

import com.quicklunch.store.common.utils.EnumUtils;
import com.quicklunch.store.domain.model.enums.DayTypeEnum;
import com.quicklunch.store.domain.model.store.BizHour;
import com.quicklunch.store.infra.persist.po.StoreBizHourPO;
import org.springframework.stereotype.Component;


@Component
public class BizHourPOConvert {

    public StoreBizHourPO toPO(BizHour bizHour, Long storeId) {
        if (bizHour == null) {
            return null;
        }

        StoreBizHourPO storeBizHourPO = new StoreBizHourPO();

        storeBizHourPO.setStoreId(storeId);

        DayTypeEnum dayType = bizHour.getDayType();
        if (dayType!=null) {
            storeBizHourPO.setDayType(dayType.getValue());
            storeBizHourPO.setDayName(dayType.getDesc());
        }

        storeBizHourPO.setOpenTime(bizHour.getOpenTime());
        storeBizHourPO.setCloseTime(bizHour.getCloseTime());

        return storeBizHourPO;
    }


    public BizHour toDO(StoreBizHourPO bizHourPO) {
        if (bizHourPO == null) {
            return null;
        }
        BizHour bizHour = new BizHour();

        Integer dayType = bizHourPO.getDayType();
        bizHour.setDayType(EnumUtils.valueOf(DayTypeEnum.class, dayType));

        bizHour.setOpenTime(bizHourPO.getOpenTime());
        bizHour.setCloseTime(bizHourPO.getCloseTime());
        return bizHour;
    }


}
