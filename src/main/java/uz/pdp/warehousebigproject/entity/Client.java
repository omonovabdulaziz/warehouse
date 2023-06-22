package uz.pdp.warehousebigproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.warehousebigproject.entity.template.AbsEntity;


@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client extends AbsEntity {
    @Column(unique = true , nullable = false)
    private String phoneNumber;
}
