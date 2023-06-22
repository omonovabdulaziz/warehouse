package uz.pdp.warehousebigproject.entity;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.warehousebigproject.entity.template.AbsEntity;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Currency extends AbsEntity {
}
