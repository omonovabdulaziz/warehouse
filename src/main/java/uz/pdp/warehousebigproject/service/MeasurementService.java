package uz.pdp.warehousebigproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import uz.pdp.warehousebigproject.entity.Measurement;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;
    //CREATE
    public Result addMeasuremeentService(Measurement measurement){
        boolean existByName = measurementRepository.existsByName(measurement.getName());
        if (existByName)
            return new Result("this measurement already exists" , false);

        measurementRepository.save(measurement);
        return new Result("succesfully added" , true);
    }
    //READ ALL
    public List<Measurement> getAllMeasurement(){
        return measurementRepository.findAll();
    }

    //READ BY ID
    public Measurement getById(Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent())
            return null;

        return optionalMeasurement.get();
    }
    //UPDATE
    public Result updateMeasurement(Integer id , Measurement measurement){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent())
            return new Result("bunday id li measurement yoq"  , false);

        boolean existName = measurementRepository.existsByName(measurement.getName());
        if (existName)
            return new Result("bunday measurement oldindan qoshilgan" , false);


        Measurement measurement1 = optionalMeasurement.get();
        measurement1.setActive(true);
        measurement1.setName(measurement.getName());
        measurement1.setId(id);
        measurementRepository.save(measurement1);
        return new Result("yangilandi" , true);

    }


    //DELETE
    public Result deleteMeasurement(Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent())
            return new Result("bunday id li measurement topilmadi"  , false);

        measurementRepository.deleteById(id);
        return new Result("o'chirildi" , true);
    }
}
