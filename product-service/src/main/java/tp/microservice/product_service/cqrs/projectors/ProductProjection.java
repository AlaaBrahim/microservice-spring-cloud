package tp.microservice.product_service.cqrs.projectors;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tp.microservice.product_service.cqrs.queries.GetProductByIdQuery;
import tp.microservice.product_service.entities.Product;
import tp.microservice.product_service.repositories.ProductRepository;

@Component
public class ProductProjection {
    @Autowired
    private ProductRepository productRepository;

    @QueryHandler

    public Product handle(GetProductByIdQuery query) {
        return productRepository.findById(query.getId()).orElse(null);
    }
}