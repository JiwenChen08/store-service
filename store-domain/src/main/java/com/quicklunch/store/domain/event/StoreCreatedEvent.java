package com.quicklunch.store.domain.event;

import com.quicklunch.store.domain.model.store.Store;

public record StoreCreatedEvent(String eventId, Store store) {
}

