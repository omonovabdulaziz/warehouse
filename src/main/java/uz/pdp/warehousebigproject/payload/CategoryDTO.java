package uz.pdp.warehousebigproject.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.warehousebigproject.entity.Category;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private String name;
    private Integer parentCategoryId;
}
