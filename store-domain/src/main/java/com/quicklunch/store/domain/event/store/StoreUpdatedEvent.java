package com.quicklunch.store.domain.event.store;

import com.quicklunch.store.domain.model.store.Store;

public record StoreUpdatedEvent(
        String eventId,
        Store store) {
}
