package ru.ipgolenischev.computerservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ipgolenischev.computerservice.controllers.base.RestControllerBase;
import ru.ipgolenischev.computerservice.models.ServiceOrderModel;
import ru.ipgolenischev.computerservice.services.databaseServices.ServiceOrderService;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

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
        return serviceOrderService.findModelById(id);
    }

    @PutMapping("/Orders/Update/{id}")
    public ResponseEntity updateServiceOrder(@PathVariable int id, @RequestBody ServiceOrderModel serviceOrderModel){
        serviceOrderModel.setId(id);
        serviceOrderModel.setStartDate(Date.from(Instant.from(LocalDate.now())));
        serviceOrderService.update(serviceOrderModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
