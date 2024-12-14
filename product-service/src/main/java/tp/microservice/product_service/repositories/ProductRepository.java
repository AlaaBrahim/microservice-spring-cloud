package tp.microservice.product_service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.microservice.product_service.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findById(String id);
}