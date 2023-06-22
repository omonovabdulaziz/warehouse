package uz.pdp.warehousebigproject.payload;


import lombok.Data;

import java.sql.Timestamp;

@Data

public class OutputDTO {
    private Timestamp date;
    private Integer warehouseId;
    private Integer currencyId;
    private String factureNumber;
    private String code;
    private Integer clientId;


}
