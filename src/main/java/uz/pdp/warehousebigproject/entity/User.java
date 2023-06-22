package uz.pdp.warehousebigproject.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String password;
    private boolean active = true;
    @ManyToMany
   private Set<Warehouse> warehouses;

}
