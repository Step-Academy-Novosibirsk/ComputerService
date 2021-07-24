package ru.ipgolenischev.computerservice.controllers;

import ru.ipgolenischev.computerservice.controllers.base.RestControllerBase;
import ru.ipgolenischev.computerservice.models.Users.ServiceManagerServiceModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ipgolenischev.computerservice.services.databaseServices.ServiceManagerService;

@RestController
@RequestMapping("/api/Managers")
public class ServiceManagerController extends RestControllerBase<ServiceManagerServiceModel> {
    private final ServiceManagerService serviceManagerService;

    protected ServiceManagerController(ServiceManagerService serviceManagerService) {
        super(serviceManagerService);
        this.serviceManagerService = serviceManagerService;
    }
    @GetMapping("/Manager/{id}")
    public ServiceManagerServiceModel getClientById(@PathVariable int id){
        return serviceManagerService.findModelById(id);
    }
    @PutMapping("Manager/Update/{id}")
    public ResponseEntity updateServiceClient(@PathVariable int id,@RequestBody ServiceManagerServiceModel serviceManagerModel){
        serviceManagerModel.setId(id);
        serviceManagerService.update(serviceManagerModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
