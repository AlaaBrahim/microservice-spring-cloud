package tp.microservice.product_service.cqrs.handlers;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import tp.microservice.product_service.cqrs.events.ProductCreatedEvent;
import tp.microservice.product_service.entities.Product;
import tp.microservice.product_service.services.ProductService;

@Component
public class ProductEventHandler {

    private final ProductService productService;

    public ProductEventHandler(ProductService productService) {
        this.productService = productService;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        // Create a new product and persist using the service
        Product product = new Product(event.getId(), event.getName(), event.getDescription(), event.getPrice());
        productService.createProduct(product);
        System.out.println("Handled ProductCreatedEvent for product: " + event.getName());
    }
}