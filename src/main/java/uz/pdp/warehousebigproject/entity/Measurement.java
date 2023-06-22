package uz.pdp.warehousebigproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.warehousebigproject.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Measurement extends AbsEntity {

}
