package uz.pdp.warehousebigproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.warehousebigproject.entity.Category;

import java.util.List;

public interface CategoryRepsitory extends JpaRepository<Category , Integer> {
    boolean existsByName(String name);
    @Query(value = "select * from category where parent_category_id =:id" ,nativeQuery = true )
    List<Category> hullas(@Param("id") Integer id);
}
