package uz.pdp.warehousebigproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.Category;
import uz.pdp.warehousebigproject.payload.CategoryDTO;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryCantroller {
    @Autowired
    CategoryService categoryService;
    //CREATE
    @PostMapping
    public Result addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.addCategory(categoryDTO);
    }

    //READ PAGE all
    @GetMapping
    public List<Category> getAllPageCategory() {
        return categoryService.getPageCategory();
    }
    //READPAGEBY ID
    @GetMapping("/byId/{id}")
    public Category getByIdCategory(@PathVariable Integer id){
        return categoryService.getByIdCategory(id);
    }

    //UPDATE
    @PutMapping("/updateId/{id}")
    public Result updateCategory(@PathVariable Integer id , @RequestBody CategoryDTO categoryDTO ){
        return categoryService.updateCategory(categoryDTO, id);
    }

    //DELETE
    @DeleteMapping("/deleteId/{id}")
    public Result deleteCategory(@PathVariable Integer id){
        return categoryService.deleteCategory(id);
    }

}
