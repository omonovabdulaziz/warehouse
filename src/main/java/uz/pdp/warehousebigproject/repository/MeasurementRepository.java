package uz.pdp.warehousebigproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehousebigproject.entity.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement , Integer> {
    boolean existsByName(String name);

}
