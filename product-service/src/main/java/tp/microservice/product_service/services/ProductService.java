package tp.microservice.product_service.services;

import java.util.List;

import tp.microservice.product_service.entities.Product;

public interface ProductService {
    Product createProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
