package ru.ipgolenischev.computerservice.controllers;
import org.hibernate.annotations.NotFound;
import ru.ipgolenischev.computerservice.models.ServiceOrderModel;
import ru.ipgolenischev.computerservice.models.Users.ServiceClientServiceModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ipgolenischev.computerservice.controllers.base.RestControllerBase;
import ru.ipgolenischev.computerservice.services.databaseServices.ServiceClientService;

import java.util.List;

@RestController
@RequestMapping("api/Clients")
public class ServiceClientsController extends RestControllerBase<ServiceClientServiceModel> {
    private final ServiceClientService serviceClientService;
    public ServiceClientsController(ServiceClientService serviceClientService) {
        super(serviceClientService);
        this.serviceClientService = serviceClientService;
    }
    @NotFound
    @GetMapping("/Client/{id}")
    public ResponseEntity<ServiceClientServiceModel> getClientById(@PathVariable int id){
        ServiceClientServiceModel client = serviceClientService.findModelById(id);
        if(client==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(client);

    }
    @NotFound
    @PutMapping("Client/Update/{id}")
    public ResponseEntity<ServiceClientServiceModel> updateServiceClient(@PathVariable int id,@RequestBody ServiceClientServiceModel serviceClientModel){
        ServiceClientServiceModel client = serviceClientService.findModelById(id);
        if(client==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        serviceClientModel.setId(id);
        serviceClientService.update(serviceClientModel);
        return ResponseEntity.status(HttpStatus.OK).body(serviceClientModel);
    }
    @GetMapping("/Client/{id}/Orders")
    public ResponseEntity<List<ServiceOrderModel>> getClientOrders(@PathVariable int id){
        ServiceClientServiceModel client = serviceClientService.findModelById(id);
        if(client==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(serviceClientService.getClientOrders(id));
    }
}
