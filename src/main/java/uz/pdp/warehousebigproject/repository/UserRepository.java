package uz.pdp.warehousebigproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehousebigproject.entity.User;

public interface UserRepository extends JpaRepository<User  , Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
