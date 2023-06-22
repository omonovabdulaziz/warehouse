package uz.pdp.warehousebigproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.warehousebigproject.entity.Client;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;


    //CREATE
    public Result addClient(Client client) {
        boolean b = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
        if (b)
            return new Result("bunday phoneNumberli UserMavjud", false);

        clientRepository.save(client);
        return new Result("succesfully qoshildi", true);
    }

    //READ
    public List<Client> getAllCLient() {
        return clientRepository.findAll();
    }


    //UPDATE
    public Result updateClient(Integer id, Client client) {
        Optional<Client> byId = clientRepository.findById(id);
        if (!byId.isPresent())
            return new Result("bunday id li client yoq " , false);

        Client client1 = byId.get();
        client1.setName(client.getName());
        client1.setId(id);
        client1.setActive(true);
        client1.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(client1);
        return new Result("client updated" , true);
    }
    //DELETE
public Result deleteClient(Integer id){
    Optional<Client> byId = clientRepository.findById(id);
    if (!byId.isPresent())
        return new Result("bunday id li client topilmadi yoki avvaldan o'chirib tashlangan" , false);

    clientRepository.deleteById(id);
    return new Result("deleted"  ,  true);

}
}
