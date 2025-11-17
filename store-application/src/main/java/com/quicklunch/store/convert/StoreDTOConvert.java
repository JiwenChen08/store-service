package com.quicklunch.store.convert;

import com.quicklunch.store.common.utils.EnumUtils;
import com.quicklunch.store.domain.model.enums.DayTypeEnum;
import com.quicklunch.store.domain.model.store.BizHour;
import com.quicklunch.store.domain.model.store.Store;
import com.quicklunch.store.dto.BizHourDTO;
import com.quicklunch.store.dto.NewStoreDTO;
import com.quicklunch.store.dto.StoreDTO;
import jakarta.validation.Valid;
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

    public Store toDO(StoreDTO storeDTO) {
        return null;
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

}
