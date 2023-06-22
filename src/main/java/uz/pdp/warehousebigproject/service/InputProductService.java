package uz.pdp.warehousebigproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.warehousebigproject.entity.Input;
import uz.pdp.warehousebigproject.entity.InputProduct;
import uz.pdp.warehousebigproject.entity.Product;
import uz.pdp.warehousebigproject.payload.InputProductServiceDTO;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.InputProductRepository;
import uz.pdp.warehousebigproject.repository.InputRepository;
import uz.pdp.warehousebigproject.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;


    //CREATE

    public Result addInputProduct( InputProductServiceDTO inputProductServiceDTO) {
        Optional<Product> optionalProduct = productRepository.findById(inputProductServiceDTO.getProductId());
        if (!optionalProduct.isPresent())
            return new Result("error"  , false);
        Optional<Input> optionalInput = inputRepository.findById(inputProductServiceDTO.getInputId());
        if (!optionalInput.isPresent())
            return new Result("errror"  , false);

        InputProduct inputProduct  = new InputProduct();
        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setInput(optionalInput.get());
        inputProduct.setPrice(inputProductServiceDTO.getPrice());
        inputProduct.setAmount(inputProductServiceDTO.getAmount());
        inputProduct.setExpiredDate(inputProductServiceDTO.getExpiredDate());
        inputProductRepository.save(inputProduct);
        return new Result("saqlandi" , true);
    }


    //READ

    public List<InputProduct> getAllInput() {
        return inputProductRepository.findAll();

    }


    //UPDATE
    public Result updateInputProduct( Integer inputProductId,  InputProductServiceDTO inputProductServiceDTO ) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(inputProductId);
        if (!optionalInputProduct.isPresent())
            return new Result("error" , false);

        InputProduct inputProduct = optionalInputProduct.get();
        inputProduct.setId(inputProductId);
        inputProduct.setPrice(inputProductServiceDTO.getPrice());
        inputProduct.setAmount(inputProductServiceDTO.getAmount());
        inputProduct.setExpiredDate(inputProductServiceDTO.getExpiredDate());
        inputProductRepository.save(inputProduct);
        return new Result("saqlandi " , true);
    }

    //DELETE
    public Result deleteInputProduct( Integer inputProductId) {
        try {
         inputProductRepository.deleteById(inputProductId);
         return new Result("deleted" , true);
        }catch (Exception e){
            e.printStackTrace();
            return new Result("error" , false);
        }

    }


}
