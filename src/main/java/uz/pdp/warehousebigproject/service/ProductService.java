package uz.pdp.warehousebigproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.warehousebigproject.entity.*;
import uz.pdp.warehousebigproject.payload.ProductDTO;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepsitory categoryRepsitory;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    //CREATE
    public Result addProduct(ProductDTO productDTO) {
        boolean b = productRepository.existsByNameAndCategoryId(productDTO.getName(), productDTO.getCategoryId());
        if (b)
            return new Result("bunday mahsulot ushbu kateogriyada bor", false);


        Optional<Category> optionalCategory = categoryRepsitory.findById(productDTO.getCategoryId());
        if (!optionalCategory.isPresent())
            return new Result("bunday categoriya mavjud emas", false);
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDTO.getPhotoId());
        if (!optionalAttachment.isPresent())
            return new Result("bunday id li photo mavjud emas", false);

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDTO.getMeasurementId());

        if (!optionalMeasurement.isPresent())
            return new Result("bunday id li measurement topilmadi", false);

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setCode("1"); //todo generatsiya qilish kerak
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        productRepository.save(product);
        return new Result("saqlandi", true);
    }

    //READ
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //update
    public Result updateProduct(Integer id, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent())
            return new Result("bunday id li product yoq", false);

        boolean b = productRepository.existsByNameAndCategoryId(productDTO.getName(), productDTO.getCategoryId());
        if (b)
            return new Result("bunday mahsulot ushbu kateogriyada bor", false);


        Optional<Category> optionalCategory = categoryRepsitory.findById(productDTO.getCategoryId());
        if (!optionalCategory.isPresent())
            return new Result("bunday categoriya mavjud emas", false);
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDTO.getPhotoId());
        if (!optionalAttachment.isPresent())
            return new Result("bunday id li photo mavjud emas", false);

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDTO.getMeasurementId());

        if (!optionalMeasurement.isPresent())
            return new Result("bunday id li measurement topilmadi", false);
        Product product = new Product();
        product.setId(id);
        product.setName(productDTO.getName());
        product.setCode("1"); //todo generatsiya qilish kerak
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        productRepository.save(product);
        return new Result("saqlandi", true);
    }

    //delete
    public Result deleteProduct(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent())
            return new Result("bunday id li product topilmadi ", false);
        Product product = optionalProduct.get();
        productRepository.deleteById(product.getId());
        return new Result("ochirildi" , true);

    }
}
