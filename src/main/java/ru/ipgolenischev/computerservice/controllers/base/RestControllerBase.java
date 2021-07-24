package ru.ipgolenischev.computerservice.controllers.base;

import ru.ipgolenischev.computerservice.models.base.AbstractServiceModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ipgolenischev.computerservice.services.base.AbstractDatabaseService;

import java.util.List;

public abstract class RestControllerBase<T extends AbstractServiceModel> {
    private final AbstractDatabaseService<T> databaseService;
    protected RestControllerBase(AbstractDatabaseService<T> databaseService){
        this.databaseService = databaseService;
    }
    @GetMapping("/")
    public List<T> getAll(){
        List<T> result = databaseService.findAll();
        return result;
    }
    @PostMapping("/Add")
    public ResponseEntity add(@RequestBody T model){
        databaseService.save(model);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
