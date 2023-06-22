package uz.pdp.warehousebigproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.Supplier;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    //CREATE
    @PostMapping
    public Result addSupplier(@RequestBody Supplier supplier) {
        return supplierService.addSupplier(supplier);
    }

    //READ
    @GetMapping
    public List<Supplier> getAllSupplier() {
        return supplierService.getAllSupplier();
    }


    //UPDATE
    @PutMapping("/byId/{supplierId}")
    public Result updateSupplier(@PathVariable Integer supplierId , @RequestBody Supplier supplier ){
        return supplierService.updateSupplier(supplierId, supplier);
    }

    //DELETE
    @DeleteMapping("/byId/{supplierId}")
    public Result deleteSupplier(@PathVariable Integer supplierId){
        return supplierService.deleteSupplier(supplierId);
    }

}

