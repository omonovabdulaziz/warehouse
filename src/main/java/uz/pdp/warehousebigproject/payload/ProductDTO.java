package uz.pdp.warehousebigproject.payload;


import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private Integer categoryId;
    private Integer photoId;
    private Integer measurementId;

}
