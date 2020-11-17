package com.accessment.demo.controller;

import com.accessment.demo.entity.Store;
import com.accessment.demo.exception.StoreNotFoundException;
import com.accessment.demo.payload.StoreUpdateRequest;
import com.accessment.demo.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/stores")
public class StoreController {
  private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

  private final StoreService storeService;

  @Autowired
  public StoreController(StoreService storeService) {
    this.storeService = storeService;
  }

  @GetMapping
  public List<Store> getAllStores() {
    return storeService.findAllStores();
  }

  @PostMapping
  public Store addStore(@RequestBody Store inputStore) {
    return storeService.createStore(inputStore);
  }

  @PatchMapping("/{externalId}")
  public Store updateStore(@PathVariable Long externalId, @RequestBody StoreUpdateRequest storeUpdateRequest) {
    Store store =
        storeService
            .findStoreByExternalId(externalId)
            .orElseThrow(() -> new StoreNotFoundException("The store with this id does not exist"));
    return storeService.updateStore(store, storeUpdateRequest);
  }

  @DeleteMapping("/{externalId}")
    public void deleteStore(@PathVariable Long externalId) {
      storeService.removeStore(externalId);
  }

  @GetMapping("/{externalId}")
  public Store getStoreByExternalId(@PathVariable Long externalId) {
    return  storeService
            .findStoreByExternalId(externalId)
            .orElseThrow(() -> new StoreNotFoundException("The store with this id does not exist"));
  }
}
