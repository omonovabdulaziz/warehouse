package uz.pdp.warehousebigproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.warehousebigproject.entity.Currency;
import uz.pdp.warehousebigproject.entity.Input;
import uz.pdp.warehousebigproject.entity.Supplier;
import uz.pdp.warehousebigproject.entity.Warehouse;
import uz.pdp.warehousebigproject.payload.InputDTO;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.CurrencyRepository;
import uz.pdp.warehousebigproject.repository.InputRepository;
import uz.pdp.warehousebigproject.repository.SupplierRepository;
import uz.pdp.warehousebigproject.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    //    CREATE
    public Result addInput(InputDTO inputDTO) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDTO.getWarehouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("bunday id li warehouse topilmadi ", false);
        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDTO.getSupplierId());
        if (!optionalSupplier.isPresent())
            return new Result("bunday id li supplier topilmadi", false);
        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDTO.getCurrencyId());
        if (!optionalCurrency.isPresent())
            return new Result("bunday id li currency topilmadi ", false);

        Input input = new Input();
        input.setCode("1");
        input.setCurrency(optionalCurrency.get());
        input.setSupplier(optionalSupplier.get());
        input.setWarehouse(optionalWarehouse.get());
        input.setDate(inputDTO.getDate());
        input.setFactureNumber(inputDTO.getFactureNumber());
        inputRepository.save(input);
        return new Result("saqlandi", true);
    }

    //READ

    public List<Input> getAllInput(){
        return inputRepository.findAll();
    }
    //update
    public Result updateInput(Integer id , InputDTO inputDTO ){
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (!optionalInput.isPresent())
            return  new Result("bunday id li input topilmadi " , false);

        Input input = optionalInput.get();
        input.setDate(inputDTO.getDate());
        input.setId(id);
        input.setCode(inputDTO.getCode());
        input.setSupplier(supplierRepository.findById(inputDTO.getSupplierId()).get());
        input.setCurrency(currencyRepository.findById(inputDTO.getCurrencyId()).get());
        input.setFactureNumber(inputDTO.getFactureNumber());
        inputRepository.save(input);
        return new Result("updated" , true);
    }

    //DELETE
    public Result deleteInput(Integer id){
        try{
            inputRepository.deleteById(id);
            return new Result("deleted" , true);
        }catch (Exception e){
            e.printStackTrace();
            return new Result("eror" , false);
        }


    }
}

