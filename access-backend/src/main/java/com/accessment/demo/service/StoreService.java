package com.accessment.demo.service;

import com.accessment.demo.entity.Store;
import com.accessment.demo.payload.StoreUpdateRequest;
import com.accessment.demo.repository.SequenceGeneratorDao;
import com.accessment.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    private final StoreRepository storeRepository;
    private final SequenceGeneratorDao sequenceGeneratorDao;

    @Autowired
    public StoreService(StoreRepository storeRepository, SequenceGeneratorDao sequenceGeneratorDao) {
        this.storeRepository = storeRepository;
        this.sequenceGeneratorDao = sequenceGeneratorDao;
    }

    public Store createStore(Store store) {
        store.setExternalId(sequenceGeneratorDao.generateSequence(Store.SEQUENCE_NAME));
        return storeRepository.save(store);
    }

    public Store updateStore(Store store, StoreUpdateRequest storeUpdateRequest) {
        store.setAddress(storeUpdateRequest.getAddress());
        store.setAddress2(storeUpdateRequest.getAddress2());
        store.setCity(storeUpdateRequest.getCity());
        store.setHours(storeUpdateRequest.getHours());
        store.setLocation(storeUpdateRequest.getLocation());
        store.setName(storeUpdateRequest.getName());
        store.setServices(storeUpdateRequest.getServices());
        store.setState(storeUpdateRequest.getState());
        store.setType(storeUpdateRequest.getType());
        store.setZip(storeUpdateRequest.getZip());

        return storeRepository.save(store);
    }

    public void removeStore(Long externalId) {
        storeRepository.deleteByExternalId(externalId);
    }

    public Optional<Store> findStoreByExternalId(Long externalId) {
        return storeRepository.findByExternalId(externalId);
    }

    public List<Store> findAllStores() {
        return storeRepository.findAll();
    }
}
