package uz.pdp.warehousebigproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.Client;
import uz.pdp.warehousebigproject.entity.Currency;
import uz.pdp.warehousebigproject.entity.Output;
import uz.pdp.warehousebigproject.entity.Warehouse;
import uz.pdp.warehousebigproject.payload.OutputDTO;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.ClientRepository;
import uz.pdp.warehousebigproject.repository.CurrencyRepository;
import uz.pdp.warehousebigproject.repository.OutputRepository;
import uz.pdp.warehousebigproject.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;
   @Autowired
    WarehouseRepository warehouseRepository;

   @Autowired
    CurrencyRepository currencyRepository;
   @Autowired
    ClientRepository clientRepository;



    //CREATE
    public Result addOutput( OutputDTO outputDTO) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDTO.getWarehouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("bunday id li wareohuse topilmadi " , false);

        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDTO.getCurrencyId());
        if (!optionalCurrency.isPresent())
          return new Result("bunday id li pul birligi topilmadi" , false);

        Optional<Client> optionalClient = clientRepository.findById(outputDTO.getClientId());
        if (!optionalClient.isPresent())
            return new Result("bunday id li client topilmad i" , false);


        Output output = new Output();
        output.setCurrency(optionalCurrency.get());
        output.setCode("1");
        output.setDate(outputDTO.getDate());
        output.setWarehouse(optionalWarehouse.get());
        output.setFactureNumber(output.getFactureNumber());
        output.setClient(optionalClient.get());
        Output savedOutput = outputRepository.save(output);

        return new Result("saqlandi " , true , savedOutput.getId());

    }


    //READ

    public List<Output> getAllOutput() {
        return outputRepository.findAll();
    }


    //UPDATE
    public Result updateOutput( Integer outputId,  OutputDTO outputDTO) {
        Optional<Output> optionalOutput = outputRepository.findById(outputId);
        if (!optionalOutput.isPresent())
            return new Result("bunday id li output topilmadi" , false );

        Output output = optionalOutput.get();
        output.setId(outputId);
        output.setCode(outputDTO.getCode());
        output.setDate(outputDTO.getDate());
        output.setFactureNumber(outputDTO.getFactureNumber());
        Output savedOutput = outputRepository.save(output);
        return new Result("updated" , true , savedOutput.getId());

    }

    //DELETE
    public Result deleteOutput( Integer outputId){
        try {

            outputRepository.deleteById(outputId);
            return new Result("deleted" , true);

        }catch (Exception e){
            return new Result("error" , false);
        }
    }




}
