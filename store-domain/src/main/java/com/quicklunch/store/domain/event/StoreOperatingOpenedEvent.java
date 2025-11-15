package com.quicklunch.store.domain.event;

import com.quicklunch.store.domain.model.store.Store;

public record StoreOperatingOpenedEvent(String eventId, Store store) {
}
