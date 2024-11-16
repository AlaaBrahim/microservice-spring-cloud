package tp.microservice.user_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.microservice.user_service.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
