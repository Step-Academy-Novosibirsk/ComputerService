package ru.ipgolenischev.computerservice.controllers;
import daos.ServiceClientDao;
import models.ServiceClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ServiceClientService;
import java.util.List;
@RestController
@RequestMapping("api/Clients")
public class ServiceClientsController {
    private final ServiceClientService serviceClientService = new ServiceClientService(new ServiceClientDao());
    @GetMapping("/")
    public List<ServiceClient> getAllClients(){
        return serviceClientService.findAllClients();
    }
    @PostMapping("/Add")
    public ResponseEntity addClient(@RequestBody ServiceClient client){
        serviceClientService.saveServiceClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/Client/{id}")
    public ServiceClient getClientById(@PathVariable int id){
        return serviceClientService.findServiceClient(id);
    }
    @PutMapping("Client/Update/{id}")
    public ResponseEntity updateServiceClient(@PathVariable int id,@RequestBody ServiceClient serviceClient){
        serviceClient.setId(id);
        serviceClientService.updateServiceClient(serviceClient);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
