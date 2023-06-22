package uz.pdp.warehousebigproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehousebigproject.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse , Integer> {
    boolean existsByName(String name);

}
