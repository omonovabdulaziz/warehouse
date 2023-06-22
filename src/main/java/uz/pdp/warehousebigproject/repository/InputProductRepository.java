package uz.pdp.warehousebigproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehousebigproject.controller.InputProductController;
import uz.pdp.warehousebigproject.entity.InputProduct;

public interface InputProductRepository extends JpaRepository<InputProduct, Integer> {

}
