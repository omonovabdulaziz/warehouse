package uz.pdp.warehousebigproject.payload;


import lombok.Data;

import java.util.Date;

@Data

public class InputProductServiceDTO {
 private Integer productId;
 private Double amount;
 private Double price;
 private Date expiredDate;
 private Integer inputId;
}
