package uz.pdp.warehousebigproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.warehousebigproject.entity.Supplier;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;


    //CREATE
    public Result addSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
        return new Result("saqlandi", true);
    }


    //READ
    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    //UPDATE
    public Result updateSupplier(Integer supplierId, Supplier supplier) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(supplierId);
        if (!optionalSupplier.isPresent())
            return new Result("bunday id li supplier topilmadi", false);

        Supplier supplier1 = optionalSupplier.get();
        supplier1.setPhoneNumber(supplier.getPhoneNumber());
        supplier1.setName(supplier.getName());
        supplier1.setId(supplierId);
        supplierRepository.save(supplier1);
        return new Result("updated", true);
    }


    //DELETE
    public Result deleteSupplier(Integer supplierId) {
        try {
            supplierRepository.deleteById(supplierId);
            return new Result("deleted" , true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("error", false);
        }
    }


}
