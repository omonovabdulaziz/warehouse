package uz.pdp.warehousebigproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class Product extends AbsEntity {
    @ManyToOne(optional = false)
    private Category category;
    @OneToOne
    private Attachment photo;

    private String code;
    @ManyToOne(optional = false)
    private Measurement measurement;
}
