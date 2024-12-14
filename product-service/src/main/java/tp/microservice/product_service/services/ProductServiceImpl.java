package tp.microservice.product_service.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.microservice.product_service.entities.Product;
import tp.microservice.product_service.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        LOGGER.info("Creating new product: {}", product.getName());
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(String id) {
        LOGGER.info("Fetching product with ID: {}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
    }

    @Override
    public List<Product> getAllProducts() {
        LOGGER.info("Fetching all products");
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(String id, Product product) {
        LOGGER.info("Updating product with ID: {}", id);
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(String id) {
        LOGGER.info("Deleting product with ID: {}", id);
        productRepository.deleteById(id);
    }
}