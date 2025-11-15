package com.quicklunch.store.domain.event.order;

public record StoreOrderDoneEvent(String eventId,
                                  String orderId
) {
}
