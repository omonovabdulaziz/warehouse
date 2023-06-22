package uz.pdp.warehousebigproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.Measurement;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;

    //CREATE
    @PostMapping
    public Result addMeasurementController(@RequestBody Measurement measurement) {
        Result result = measurementService.addMeasuremeentService(measurement);
        return result;
    }

    //READ ALL
    @GetMapping
    public List<Measurement> getAllMeasurement() {
        return measurementService.getAllMeasurement();
    }

    //READ
    @GetMapping("/byId/{id}")
    public Measurement getById(@PathVariable Integer id) {
        return measurementService.getById(id);
    }
    //UPDATE
    @PutMapping("/updateId/{id}")
    public Result updateMeasurement(@PathVariable Integer id , @RequestBody Measurement measurement){
        return measurementService.updateMeasurement(id, measurement);
    }
 //DELETE
    @DeleteMapping("/deleteId/{id}")
    public Result deleteMeasurement(@PathVariable Integer id){
        return measurementService.deleteMeasurement(id);
    }
}
