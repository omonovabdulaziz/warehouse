package uz.pdp.warehousebigproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.warehousebigproject.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Supplier extends AbsEntity {
    @Column(unique = true , nullable = false)
    private String phoneNumber;
}
