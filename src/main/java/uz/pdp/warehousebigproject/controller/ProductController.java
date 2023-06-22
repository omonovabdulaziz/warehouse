package uz.pdp.warehousebigproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.Product;
import uz.pdp.warehousebigproject.payload.ProductDTO;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    //CREATE
    @PostMapping
    public Result addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    //READ
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    //UPDATE
    @PutMapping("/byId/{id}")
    public Result updateProducts(@PathVariable Integer id , @RequestBody ProductDTO productDTO ){
        return productService.updateProduct(id, productDTO);
    }


    //DELETE
    @DeleteMapping("/byId/{id}")
    public Result deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }


}
