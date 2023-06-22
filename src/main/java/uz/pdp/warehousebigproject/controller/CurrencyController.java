package uz.pdp.warehousebigproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.Client;
import uz.pdp.warehousebigproject.entity.Currency;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.ClientRepository;
import uz.pdp.warehousebigproject.service.ClientService;
import uz.pdp.warehousebigproject.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    //CREATE
    @PostMapping
    public Result addCurrency(@RequestBody Currency currency) {
        return currencyService.addCurrency(currency);
    }

    //READ
    @GetMapping
    public List<Currency> getAllCurrency() {
        return currencyService.getAllCurrency();
    }


    //UPDATE
    @PutMapping("/byId/{currencyId}")
    public Result updateCurrency(@PathVariable Integer currencyId , @RequestBody Currency currency ){
        return currencyService.updateCurrency(currencyId, currency);
    }

    //DELETE
    @DeleteMapping("/byId/{currencyId}")
    public Result deleteCurrencyId(@PathVariable Integer currencyId){
        return currencyService.deleteCurrencyId(currencyId);
    }

}
