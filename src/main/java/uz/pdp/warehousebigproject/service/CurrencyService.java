package uz.pdp.warehousebigproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.warehousebigproject.entity.Client;
import uz.pdp.warehousebigproject.entity.Currency;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;


    //CREATE
    public Result addCurrency(Currency currency) {
        boolean b = currencyRepository.existsByName(currency.getName());
        if (b)
            return new Result("bunday pul biriligi qoshilgan " , false);

        currencyRepository.save(currency);
        return new Result("qoshildi" , true);
    }



    //READ
    public List<Currency> getAllCurrency() {
        return currencyRepository.findAll();
    }


    //UPDATE

    public Result updateCurrency( Integer currencyId , Currency currency ){
        Optional<Currency> byId = currencyRepository.findById(currencyId);
        if (!byId.isPresent())
            return new Result("bunday id li currency topilmadi " , false);

        Currency currency1 = byId.get();
        currency1.setName(currency.getName());
        currencyRepository.save(currency1);
        return new Result("updated " , true);
    }

    //DELETE
    public Result deleteCurrencyId( Integer currencyId){
        Optional<Currency> optionalCurrencu = currencyRepository.findById(currencyId);
        if (!optionalCurrencu.isPresent())
            return new Result("error" , false);

        currencyRepository.deleteById(currencyId);
        return new Result("currency deleted " , true);
    }
}
