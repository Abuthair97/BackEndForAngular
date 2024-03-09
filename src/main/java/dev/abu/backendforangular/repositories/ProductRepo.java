package dev.abu.backendforangular.repositories;

import dev.abu.backendforangular.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {

}
