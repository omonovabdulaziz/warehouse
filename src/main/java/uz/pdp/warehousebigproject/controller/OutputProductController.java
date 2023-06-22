package uz.pdp.warehousebigproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.OutputProduct;
import uz.pdp.warehousebigproject.payload.OutputProductDTO;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.OutputRepository;
import uz.pdp.warehousebigproject.repository.ProductRepository;
import uz.pdp.warehousebigproject.service.OutputProductService;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {
    @Autowired
    OutputProductService outputProductService;



    //CREATE
    @PostMapping
    public Result addOuputProduct(@RequestBody OutputProductDTO outputProductDTO) {
        return outputProductService.addOuputProduct(outputProductDTO);
    }


    //READ
    @GetMapping
    public List<OutputProduct> getAllProduct() {
        return outputProductService.getAllProduct();
    }

    //UPDATE
    @PutMapping("/byId/{ouputProductId}")
    public Result updateoutputProduct(@PathVariable Integer ouputProductId , @RequestBody OutputProductDTO outputProductDTO ){
        return outputProductService.updateoutputProduct(ouputProductId, outputProductDTO);
    }

    //DELETE
    @DeleteMapping("/byId/{outputProductId}")
    public Result deleteOutputProduct(@PathVariable Integer outputProductId){
        return outputProductService.deleteOutputProduct(outputProductId);
    }
}
