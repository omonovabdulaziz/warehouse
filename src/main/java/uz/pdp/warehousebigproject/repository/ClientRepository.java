package uz.pdp.warehousebigproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehousebigproject.entity.Client;

public interface ClientRepository extends JpaRepository<Client , Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
