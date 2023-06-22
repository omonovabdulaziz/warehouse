package uz.pdp.warehousebigproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehousebigproject.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier , Integer> {
}
