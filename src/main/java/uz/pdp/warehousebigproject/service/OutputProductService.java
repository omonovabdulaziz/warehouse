package uz.pdp.warehousebigproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.OutputProduct;
import uz.pdp.warehousebigproject.entity.Product;
import uz.pdp.warehousebigproject.payload.OutputProductDTO;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.OutputProductRepository;
import uz.pdp.warehousebigproject.repository.OutputRepository;
import uz.pdp.warehousebigproject.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OutputRepository outputRepository;


    //CREATE
    public Result addOuputProduct(OutputProductDTO outputProductDTO) {
        Optional<Product> optionalProduct = productRepository.findById(outputProductDTO.getProductId());
        if (!optionalProduct.isPresent())
            return new Result("error", false);
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(outputProductDTO.getOutputId());
        if (!optionalOutputProduct.isPresent())
            return new Result("error" , false);

        OutputProduct product = new OutputProduct();
        product.setProduct(optionalProduct.get());
        product.setOutput(optionalOutputProduct.get().getOutput());
        product.setPrice(outputProductDTO.getPrice());
        product.setAmount(outputProductDTO.getAmount());
        OutputProduct savedOutputProduct = outputProductRepository.save(product);
        return new Result("saved" , true , savedOutputProduct.getId());

    }


    //READ

    public List<OutputProduct> getAllProduct() {
        return outputProductRepository.findAll();
    }

    //UPDATE
    public Result updateoutputProduct(Integer ouputProductId, OutputProductDTO outputProductDTO) {
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(ouputProductId);
        if (!optionalOutputProduct.isPresent())
            return new Result("error" , false);

        OutputProduct product = optionalOutputProduct.get();
        product.setId(ouputProductId);
        product.setPrice(outputProductDTO.getPrice());
        product.setAmount(outputProductDTO.getAmount());
        outputProductRepository.save(product);
        return new Result("updated" , true);
    }

    //DELETE
    public Result deleteOutputProduct(Integer outputProductId) {
try {
    outputProductRepository.deleteById(outputProductId);
    return new Result("deleted" , true);
}catch (Exception e ){
    e.printStackTrace();
    return new Result("error"  , false);
}
    }


}
