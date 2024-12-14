package tp.microservice.product_service.services;

import java.util.List;

import tp.microservice.product_service.entities.Product;

public interface ProductService {
    Product createProduct(Product product);

    Product getProductById(String id);

    List<Product> getAllProducts();

    Product updateProduct(String id, Product product);

    void deleteProduct(String id);
}
