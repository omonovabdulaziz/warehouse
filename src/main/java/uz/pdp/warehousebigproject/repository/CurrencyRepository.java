package uz.pdp.warehousebigproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehousebigproject.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency , Integer> {
boolean existsByName(String name);
}
