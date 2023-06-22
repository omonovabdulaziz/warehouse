package uz.pdp.warehousebigproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.warehousebigproject.entity.Warehouse;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;


    //CREATE
    public Result addWarehouse( Warehouse warehouse ) {
        if (warehouseRepository.existsByName(warehouse.getName()))
            return new Result("bunday nomli warehouse qoshilgan adashib ketmasiligingiz uchun boshqa nom kiritng" ,  false);

        warehouseRepository.save(warehouse);
        return new Result("yangi omborxona qohsildi" , true);


    }

    //READ
    public List<Warehouse> getALlWare() {
        return warehouseRepository.findAll();
    }




    //UPDATE

    public Result updateWarehouse( Integer warehouseId , Warehouse warehouse ){
        Optional<Warehouse> byId = warehouseRepository.findById(warehouseId);
        if (!byId.isPresent())
            return new Result("bunday id li warehouse yoq" , false);

        Warehouse warehouse1 = byId.get();
        warehouse1.setName(warehouse.getName());
        warehouseRepository.save(warehouse1);
        return new Result("updated"  , true);
    }

    //DELETE
    public Result deleteWarehouse( Integer warehouseId){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(warehouseId);
        if (!optionalWarehouse.isPresent())
            return new Result("bunday id li warehouse topilmadi " , false);


        warehouseRepository.deleteById(warehouseId);
        return new Result("ushbu warehouse o'chirib tashlandi "  , true);

    }

}
