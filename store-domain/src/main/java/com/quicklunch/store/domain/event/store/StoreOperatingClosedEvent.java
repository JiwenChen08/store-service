package com.quicklunch.store.domain.event.store;

import com.quicklunch.store.domain.model.store.Store;

public record StoreOperatingClosedEvent(String eventId, Store store) {

}
