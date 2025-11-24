package com.quicklunch.store.convert;

import com.quicklunch.store.common.utils.EnumUtils;
import com.quicklunch.store.common.utils.SetterUtils;
import com.quicklunch.store.domain.model.enums.DayTypeEnum;
import com.quicklunch.store.domain.model.enums.StoreOperatingStatusEnum;
import com.quicklunch.store.domain.model.enums.StoreStatusEnum;
import com.quicklunch.store.domain.model.store.BizHour;
import com.quicklunch.store.domain.model.store.Store;
import com.quicklunch.store.dto.store.BizHourDTO;
import com.quicklunch.store.dto.store.NewStoreDTO;
import com.quicklunch.store.dto.store.StoreDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreDTOConvert {


    public StoreDTO toDTO(Store store) {
        if (store == null) {
            return null;
        }
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(store.getId());
        storeDTO.setStoreNo(store.getStoreNo());
        storeDTO.setName(store.getName());

        storeDTO.setCityId(store.getCityId());
        storeDTO.setCityName(store.getCityName());

        storeDTO.setAddress(store.getAddress());
        storeDTO.setPhone(store.getPhone());
        storeDTO.setEmail(store.getEmail());
        storeDTO.setLongitude(store.getLongitude());
        storeDTO.setLatitude(store.getLatitude());

        storeDTO.setStatus(EnumUtils.toValue(store.getStatus()));
        storeDTO.setOperatingStatus(EnumUtils.toValue(store.getOperatingStatus()));

        storeDTO.setCreateAt(store.getCreateAt());
        storeDTO.setUpdateAt(store.getUpdateAt());

        storeDTO.setBizHourList(toBizHourDTOList(store.getBizHourList()));
        return storeDTO;
    }

    private List<BizHourDTO> toBizHourDTOList(List<BizHour> bizHourList) {
        if (bizHourList == null) return null;

        return bizHourList.stream()
                .map(bizHour -> {
                            BizHourDTO dto = new BizHourDTO();
                            dto.setDayType(EnumUtils.toValue(bizHour.getDayType()));
                            dto.setDayName(EnumUtils.toDesc(bizHour.getDayType()));
                            dto.setOpenTime(bizHour.getOpenTime());
                            dto.setCloseTime(bizHour.getCloseTime());
                            return dto;
                        }
                ).toList();
    }

    public List<BizHour> toBizHourDOList(List<BizHourDTO> bizHourDTOList) {
        if (bizHourDTOList == null) return null;

        return bizHourDTOList.stream()
                .map(bizHourDTO -> {
                    BizHour bizHour = new BizHour();

                    bizHour.setDayType(EnumUtils.valueOf(DayTypeEnum.class, bizHourDTO.getDayType()));
                    bizHour.setOpenTime(bizHourDTO.getOpenTime());
                    bizHour.setCloseTime(bizHourDTO.getCloseTime());

                    return bizHour;
                }).toList();
    }


    public Store fromNewStoreDTO(NewStoreDTO newStoreDTO, String storeNo) {
        Store store = new Store();

        store.setStoreNo(storeNo);
        store.setName(newStoreDTO.getName());
        store.setAddress(newStoreDTO.getAddress());
        store.setCityName(newStoreDTO.getCityName());
        store.setPhone(newStoreDTO.getPhone());
        store.setEmail(newStoreDTO.getEmail());

        List<BizHour> bizHourDOList = toBizHourDOList(newStoreDTO.getBizHourList());
        store.setBizHourList(bizHourDOList);
        return store;
    }


    public void updateFields(Store store, StoreDTO storeDTO) {

        SetterUtils.setIfPresent(storeDTO.getStoreNo(), store::setStoreNo);
        SetterUtils.setIfPresent(storeDTO.getName(), store::setName);
        SetterUtils.setIfPresent(storeDTO.getAddress(), store::setAddress);
        SetterUtils.setIfPresent(storeDTO.getCityId(), store::setCityId);
        SetterUtils.setIfPresent(storeDTO.getCityName(), store::setCityName);
        SetterUtils.setIfPresent(storeDTO.getPhone(), store::setPhone);
        SetterUtils.setIfPresent(storeDTO.getEmail(), store::setEmail);
        SetterUtils.setIfPresent(storeDTO.getLongitude(), store::setLongitude);
        SetterUtils.setIfPresent(storeDTO.getLatitude(), store::setLatitude);

        SetterUtils.setIfPresent(storeDTO.getStatus(), status -> {
            store.setStatus(EnumUtils.valueOf(StoreStatusEnum.class, status));
        });

        SetterUtils.setIfPresent(storeDTO.getOperatingStatus(), opStatus -> {
            store.setOperatingStatus(EnumUtils.valueOf(StoreOperatingStatusEnum.class, opStatus));
        });

        SetterUtils.setIfPresent(storeDTO.getBizHourList(), list -> {
            store.setBizHourList(toBizHourDOList(list));
        });

    }
}
