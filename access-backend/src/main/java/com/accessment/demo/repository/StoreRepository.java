package com.accessment.demo.repository;

import com.accessment.demo.entity.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends MongoRepository<Store, String> {
    Optional<Store> findByExternalId(Long externalId);

    void deleteByExternalId(Long externalId);
}
