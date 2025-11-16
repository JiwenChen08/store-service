package com.quicklunch.store.infra.convert;


import com.quicklunch.store.common.utils.EnumUtils;
import com.quicklunch.store.domain.model.enums.StoreOperatingStatusEnum;
import com.quicklunch.store.domain.model.enums.StoreStatusEnum;
import com.quicklunch.store.domain.model.store.BizHour;
import com.quicklunch.store.domain.model.store.Store;
import com.quicklunch.store.infra.persist.po.StoreBizHourPO;
import com.quicklunch.store.infra.persist.po.StorePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StorePOConvert {

    @Autowired
    private BizHourPOConvert bizHourPOConvert;

    public StorePO toStorePO(Store store) {
        if (store == null) {
            return null;
        }
        StorePO storePO = new StorePO();
        storePO.setId(store.getId());
        storePO.setName(store.getName());

        storePO.setAddress(store.getAddress());


        storePO.setCityId(store.getCityId());
        storePO.setCityName(store.getCityName());
        storePO.setPhone(store.getPhone());
        storePO.setEmail(store.getEmail());

        storePO.setStatus(store.getStatus().getValue());
        storePO.setOperatingStatus(store.getOperatingStatus().getValue());

        storePO.setCreateAt(store.getCreateAt());
        storePO.setUpdateAt(store.getUpdateAt());

        storePO.setStoreNo(store.getStoreNo());

        storePO.setLongitude(store.getLongitude());
        storePO.setLatitude(store.getLatitude());

        return storePO;
    }

    public List<StoreBizHourPO> toBizHourPO(List<BizHour> bizHours, Long storeId) {
        if (bizHours == null) {
            return null;
        }

        return bizHours.stream()
                .map(bizHour -> bizHourPOConvert.toPO(bizHour, storeId))
                .toList();
    }


    public Store toDO(StorePO storePO, List<StoreBizHourPO> businessHourPOList) {
        if (storePO == null) {
            return null;
        }

        Store store = new Store();
        store.setId(storePO.getId());
        store.setStoreNo(storePO.getStoreNo());
        store.setName(storePO.getName());
        store.setAddress(storePO.getAddress());
        store.setCityId(storePO.getCityId());
        store.setCityName(storePO.getCityName());
        store.setPhone(storePO.getPhone());
        store.setEmail(storePO.getEmail());
        store.setLongitude(storePO.getLongitude());
        store.setLatitude(storePO.getLatitude());


        store.setStatus(EnumUtils.valueOf(StoreStatusEnum.class, storePO.getStatus()));
        store.setOperatingStatus(EnumUtils.valueOf(StoreOperatingStatusEnum.class, storePO.getOperatingStatus()));

        store.setCreateAt(storePO.getCreateAt());
        store.setUpdateAt(storePO.getUpdateAt());

        if (businessHourPOList != null) {
            List<BizHour> bizHours = businessHourPOList.stream()
                    .map(bizHourPOConvert::toDO)
                    .toList();

            store.setBizHourList(bizHours);
        }

        return store;
    }


}
