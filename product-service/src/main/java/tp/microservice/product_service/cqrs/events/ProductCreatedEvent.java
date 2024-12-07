package tp.microservice.product_service.cqrs.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductCreatedEvent {
    private final String id;
    private final String name;
    private final String description;
    private final double price;
}