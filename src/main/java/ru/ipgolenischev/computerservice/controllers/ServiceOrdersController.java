package ru.ipgolenischev.computerservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ipgolenischev.computerservice.controllers.base.RestControllerBase;
import ru.ipgolenischev.computerservice.models.ServiceOrderModel;
import ru.ipgolenischev.computerservice.services.databaseServices.ServiceOrderService;

@RestController
@RequestMapping("/api/Orders")
public class ServiceOrdersController extends RestControllerBase<ServiceOrderModel> {
    private final ServiceOrderService serviceOrderService;
    public ServiceOrdersController(ServiceOrderService serviceOrderService) {
        super(serviceOrderService);
        this.serviceOrderService = serviceOrderService;
    }
    @GetMapping("/Order/{id}")
    public ServiceOrderModel getOrderById(@PathVariable int id){
        return serviceOrderService.findModelByIdt(id);
    }

    @PutMapping("/Orders/Update/{id}")
    public ResponseEntity updateServiceOrder(@PathVariable int id, @RequestBody ServiceOrderModel serviceOrderModel){
        serviceOrderModel.setId(id);
        serviceOrderService.update(serviceOrderModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
