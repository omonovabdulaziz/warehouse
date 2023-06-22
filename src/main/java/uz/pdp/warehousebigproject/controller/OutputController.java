package uz.pdp.warehousebigproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.Output;
import uz.pdp.warehousebigproject.payload.OutputDTO;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;


    //CREATE
    @PostMapping
    public Result addOutput(@RequestBody OutputDTO outputDTO) {
        return outputService.addOutput(outputDTO);
    }


    //READ

    @GetMapping
    public List<Output> getAllOutput() {
        return outputService.getAllOutput();
    }


    //UPDATE
    @PutMapping("/byId/{outputId}")
    public Result updateOutput(@PathVariable Integer outputId, @RequestBody OutputDTO outputDTO) {
        return outputService.updateOutput(outputId, outputDTO);
    }

    //DELETE
    @DeleteMapping("/byId/{outputId}")
    public Result deleteOutput(@PathVariable Integer outputId){
        return outputService.deleteOutput(outputId);
    }




}