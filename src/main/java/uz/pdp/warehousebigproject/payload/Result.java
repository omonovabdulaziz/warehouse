package uz.pdp.warehousebigproject.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String message;
    private Boolean succes;
    private Object object;

    public Result(String message, Boolean succes) {
        this.message = message;
        this.succes = succes;
    }
}
