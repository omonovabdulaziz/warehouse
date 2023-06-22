package uz.pdp.warehousebigproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.warehousebigproject.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category extends AbsEntity {
    @ManyToOne
    private Category parentCategory;
    
}
