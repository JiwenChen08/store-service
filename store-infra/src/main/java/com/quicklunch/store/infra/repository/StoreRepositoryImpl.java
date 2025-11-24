package com.quicklunch.store.infra.repository;

import com.quicklunch.store.domain.model.store.Store;
import com.quicklunch.store.domain.repository.StoreRepository;
import com.quicklunch.store.infra.convert.StorePOConvert;
import com.quicklunch.store.infra.persist.po.StoreBizHourPO;
import com.quicklunch.store.infra.persist.po.StorePO;
import com.quicklunch.store.infra.persist.repository.JdbcStoreBizHourRepository;
import com.quicklunch.store.infra.persist.repository.JdbcStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class StoreRepositoryImpl implements StoreRepository {

    @Autowired
    private StorePOConvert storePOConvert;
    @Autowired
    private JdbcStoreRepository jdbcStoreRepository;
    @Autowired
    private JdbcStoreBizHourRepository jdbcStoreBizHourRepository;


    @Override
    @Transactional
    public Store save(Store store) {

        StorePO saved = jdbcStoreRepository.save(storePOConvert.toStorePO(store));

        Long storeId = saved.getId();

        List<StoreBizHourPO> newHourList = storePOConvert.toBizHourPO(store.getBizHourList(), storeId);
        List<StoreBizHourPO> oldHourList = jdbcStoreBizHourRepository.findListByStoreId(storeId);
        updateBizHourList(newHourList, oldHourList);

        List<StoreBizHourPO> savedBizHourPOList = jdbcStoreBizHourRepository.findListByStoreId(saved.getId());
        return storePOConvert.toDO(saved, savedBizHourPOList);
    }

    private void updateBizHourList(List<StoreBizHourPO> newHourList, List<StoreBizHourPO> oldHourList) {
        Set<Integer> dayTypeSet = new HashSet<>();
        Map<Integer, StoreBizHourPO> oldMap = new HashMap<>();
        Map<Integer, StoreBizHourPO> newMap = new HashMap<>();

        for (StoreBizHourPO newPO : newHourList) {
            dayTypeSet.add(newPO.getDayType());
            newMap.put(newPO.getDayType(), newPO);
        }
        for (StoreBizHourPO oldPO : oldHourList) {
            dayTypeSet.add(oldPO.getDayType());
            oldMap.put(oldPO.getDayType(), oldPO);
        }

        List<StoreBizHourPO> updateList = new ArrayList<>();
        List<StoreBizHourPO> addList = new ArrayList<>();
        List<Long> deleteIdList = new ArrayList<>();

        for (Integer dayType : dayTypeSet) {

            StoreBizHourPO oldPO = oldMap.get(dayType);
            StoreBizHourPO newPO = newMap.get(dayType);

            if (newPO == null && oldPO != null) {
                // delete
                deleteIdList.add(oldPO.getId());
            } else if (newPO != null && oldPO == null) {
                // add
                newPO.setCreateAt(LocalDateTime.now());
                newPO.setUpdateAt(LocalDateTime.now());
                addList.add(newPO);
            } else if (newPO != null && oldPO != null) {
                // update
                oldPO.setOpenTime(newPO.getOpenTime());
                oldPO.setCloseTime(newPO.getCloseTime());
                oldPO.setUpdateAt(LocalDateTime.now());
                updateList.add(oldPO);
            }
        }

        if (!updateList.isEmpty()) {
            jdbcStoreBizHourRepository.saveAll(updateList);
        }
        if (!addList.isEmpty()) {
            jdbcStoreBizHourRepository.saveAll(addList);
        }
        if (!deleteIdList.isEmpty()) {
            jdbcStoreBizHourRepository.deleteAllById(deleteIdList);
        }
    }

    @Override
    public Store findById(Long id) {

        Optional<StorePO> storeOptional = jdbcStoreRepository.findById(id);
        if (storeOptional.isEmpty()) {
            return null;
        }

        StorePO storePO = storeOptional.get();
        List<StoreBizHourPO> bHPOList = jdbcStoreBizHourRepository.findListByStoreId(id);

        return storePOConvert.toDO(storePO, bHPOList);
    }

}
