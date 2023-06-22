package uz.pdp.warehousebigproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.Input;
import uz.pdp.warehousebigproject.payload.InputDTO;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.service.InputService;

import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {

    @Autowired
    InputService Inputservice;


    //CREATE
    @PostMapping
    public Result addInput(@RequestBody InputDTO inputDTO) {
        Result result = Inputservice.addInput(inputDTO);
        return  result;
    }


    //READ
    @GetMapping
    public List<Input> getAllInput() {
        return Inputservice.getAllInput();
    }

    //UPDATE
    @PutMapping("/byId/{InputId}")
    public Result updateInput(@PathVariable Integer InputId , @RequestBody InputDTO inputDTO ){
        return Inputservice.updateInput(InputId, inputDTO);
    }

    //DELETE
    @DeleteMapping("/byId/{InputId}")
    public Result deleteInput(@PathVariable Integer InputId){
        return Inputservice.deleteInput(InputId);   
    }


}
