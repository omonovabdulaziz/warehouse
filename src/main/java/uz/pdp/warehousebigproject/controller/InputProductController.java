package uz.pdp.warehousebigproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.InputProduct;
import uz.pdp.warehousebigproject.payload.InputProductServiceDTO;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.service.InputProductService;

import java.util.List;

@RestController
@RequestMapping("/inputProduct")
public class InputProductController {
    @Autowired
    InputProductService inputProductService;

    //CREATE

    @PostMapping
    public Result addInputProduct(@RequestBody InputProductServiceDTO inputProductServiceDTO) {
        return inputProductService.addInputProduct(inputProductServiceDTO);
    }


    //READ
    @GetMapping
    public List<InputProduct> getAllInput() {
        return inputProductService.getAllInput();
    }


    //UPDATE
    @PutMapping("/byId/{inputProductId}")
    public Result updateInputProduct(@PathVariable Integer inputProductId, @RequestBody InputProductServiceDTO inputProductServiceDTO ) {
        return inputProductService.updateInputProduct(inputProductId, inputProductServiceDTO);
    }

    //DELETE
    @DeleteMapping("/byId/{inputProductId}")
    public Result deleteInputProduct(@PathVariable Integer inputProductId) {
        return inputProductService.deleteInputProduct(inputProductId);
    }

}
