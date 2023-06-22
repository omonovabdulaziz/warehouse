package uz.pdp.warehousebigproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehousebigproject.entity.Product;

public interface ProductRepository extends JpaRepository<Product , Integer> {
    boolean existsByNameAndCategoryId(String name, Integer category_id);
}
