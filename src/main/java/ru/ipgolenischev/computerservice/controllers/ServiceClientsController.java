package ru.ipgolenischev.computerservice.controllers;
import ru.ipgolenischev.computerservice.models.Users.ServiceClientServiceModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ipgolenischev.computerservice.controllers.base.RestControllerBase;
import ru.ipgolenischev.computerservice.services.databaseServices.ServiceClientService;

@RestController
@RequestMapping("api/Clients")
public class ServiceClientsController extends RestControllerBase<ServiceClientServiceModel> {
    private final ServiceClientService serviceClientService;
    public ServiceClientsController(ServiceClientService serviceClientService) {
        super(serviceClientService);
        this.serviceClientService = serviceClientService;
    }
    @GetMapping("/Client/{id}")
    public ServiceClientServiceModel getClientById(@PathVariable int id){
        return serviceClientService.findModelByIdt(id);
    }
    @PutMapping("Client/Update/{id}")
    public ResponseEntity updateServiceClient(@PathVariable int id,@RequestBody ServiceClientServiceModel serviceClientModel){
        serviceClientModel.setId(id);
        serviceClientService.update(serviceClientModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
