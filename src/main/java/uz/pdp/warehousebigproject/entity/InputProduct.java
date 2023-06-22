package uz.pdp.warehousebigproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.warehousebigproject.entity.Input;
import uz.pdp.warehousebigproject.entity.Product;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InputProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Product product;
    @Column(nullable = false)
    private Double amount;
    private Double price;
    private Date expiredDate;
    @ManyToOne
    private Input input;



}
