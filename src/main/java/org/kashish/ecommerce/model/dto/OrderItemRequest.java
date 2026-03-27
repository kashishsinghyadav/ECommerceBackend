package org.kashish.ecommerce.model.dto;

public record OrderItemRequest(
        int productId,
        int quantity
) {
}
