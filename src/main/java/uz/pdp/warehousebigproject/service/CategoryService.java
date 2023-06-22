package uz.pdp.warehousebigproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.warehousebigproject.entity.Category;
import uz.pdp.warehousebigproject.payload.CategoryDTO;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.CategoryRepsitory;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ClassUtils.isPresent;

@Service
public class CategoryService {
    @Autowired
    CategoryRepsitory categoryRepsitory;

    //CREATE
    public Result addCategory(CategoryDTO categoryDTO) {
        boolean b = categoryRepsitory.existsByName(categoryDTO.getName());
        if (b)
            return new Result("bunay nomli category avvaldan mavjud", false);

        Category category = new Category();
        if (categoryDTO.getParentCategoryId() != null) {
            Optional<Category> optionalCategory = categoryRepsitory.findById(categoryDTO.getParentCategoryId());
            if (!optionalCategory.isPresent())
                return new Result("bunday ota categoriya topilmadi (id)", false);

            category.setParentCategory(optionalCategory.get());
        }


        category.setName(categoryDTO.getName());
        categoryRepsitory.save(category);
        return new Result("muvafaqiyatli qoshildi", true);

    }

    //READ all
    public List<Category> getPageCategory() {
        return categoryRepsitory.findAll();
    }
//READ BY ID
    public Category getByIdCategory(Integer id){
        Optional<Category> optionalCategory = categoryRepsitory.findById(id);
        if (!optionalCategory.isPresent())
            return null;

        return optionalCategory.get();
    }
    //update
    public Result updateCategory(CategoryDTO categoryDTO , Integer id){
        Optional<Category> optionalCategory = categoryRepsitory.findById(id);
        if (!optionalCategory.isPresent())
            return new Result("bunday id li category topilmadi" , false);

        boolean b = categoryRepsitory.existsByName(categoryDTO.getName());
        if (b)
            return new Result("bunday nomli category mavjud" , false);
        Category  category = new Category();
        if (categoryDTO.getParentCategoryId() != null){
            Optional<Category> optionalCategory1 = categoryRepsitory.findById(categoryDTO.getParentCategoryId());
            if (!optionalCategory1.isPresent())
                  return new Result("bunday id li ota category topilmadi" , false);

              category.setParentCategory(optionalCategory1.get());
        }
        category.setName(categoryDTO.getName());
        categoryRepsitory.save(category);
        return new Result("yangilandi" , true);
    }

    //DELETE
    public Result deleteCategory( Integer id){
        Optional<Category> optionalCategory = categoryRepsitory.findById(id);
        if (!optionalCategory.isPresent())
            return new Result("bunday id li category yoq" , false);

        List<Category> hullas = categoryRepsitory.hullas(id);
        if (hullas != null)
              return new Result("bu ota kategoriya bolgani uchun o'chirolmaysan" , false);
        categoryRepsitory.deleteById(id);
        return new Result("ochirildi"  ,true);
    }

}
