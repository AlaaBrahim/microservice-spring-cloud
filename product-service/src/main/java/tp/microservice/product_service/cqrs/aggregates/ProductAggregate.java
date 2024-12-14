package tp.microservice.product_service.cqrs.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.NoArgsConstructor;
import tp.microservice.product_service.cqrs.commands.CreateProductCommand;
import tp.microservice.product_service.cqrs.events.ProductCreatedEvent;
import tp.microservice.product_service.entities.Product;
import tp.microservice.product_service.repositories.ProductRepository;
import tp.microservice.product_service.services.ProductServiceImpl;

@NoArgsConstructor
@Aggregate
public class ProductAggregate {

    private ProductServiceImpl service = new ProductServiceImpl();

    @AggregateIdentifier
    private String id;
    private String name;
    private String description;
    private double price;

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        // Publier un événement
        AggregateLifecycle.apply(new ProductCreatedEvent(
                command.getId(),
                command.getName(),
                command.getDescription(),
                command.getPrice()));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.price = event.getPrice();
        // service.createProduct(new Product(event.getId(), event.getName(),
        // event.getDescription(), event.getPrice()));
    }
}
