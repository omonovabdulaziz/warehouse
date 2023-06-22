package uz.pdp.warehousebigproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehousebigproject.entity.Client;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.ClientRepository;
import uz.pdp.warehousebigproject.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    //CREATE
    @PostMapping
    public Result addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    //READ
    @GetMapping
    public List<Client> getAllClient() {
        return clientService.getAllCLient();
    }


    //UPDATE
    @PutMapping("/byId/{clientId}")
    public Result updateClient(@PathVariable Integer clientId , @RequestBody Client client){
        return clientService.updateClient(clientId, client);
    }

    //DELETE
    @DeleteMapping("/byId/{clientId}")
    public Result deleteClient(@PathVariable Integer clientId){
        return clientService.deleteClient(clientId);
    }

}
