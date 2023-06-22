package uz.pdp.warehousebigproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.Warehouse;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService service ;

    //CREATE
    @PostMapping
    public Result addWarehouse(@RequestBody Warehouse warehouse ) {
        return service.addWarehouse(warehouse);
    }

    //READ
    @GetMapping
    public List<Warehouse> getAllWarehouse() {
        return service.getALlWare();
    }


    //UPDATE
    @PutMapping("/byId/{warehouseId}")
    public Result updateWareohuse(@PathVariable Integer warehouseId , @RequestBody Warehouse warehouse ){
        return service.updateWarehouse(warehouseId, warehouse);
    }

    //DELETE
    @DeleteMapping("/byId/{warehouseId}")
    public Result deleteWarehouse(@PathVariable Integer warehouseId){
        return service.deleteWarehouse(warehouseId);
    }

}
