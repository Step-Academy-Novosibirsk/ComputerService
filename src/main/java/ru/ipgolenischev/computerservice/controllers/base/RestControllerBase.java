package ru.ipgolenischev.computerservice.controllers.base;

import ru.ipgolenischev.computerservice.models.base.AbstractServiceUserServiceModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ipgolenischev.computerservice.services.base.AbstractDatabaseService;

import java.util.List;

public abstract class RestControllerBase<T extends AbstractServiceUserServiceModel> {
    private final AbstractDatabaseService<T> databaseService;
    protected RestControllerBase(AbstractDatabaseService<T> databaseService){
        this.databaseService = databaseService;
    }
    @GetMapping("/")
    public List<T> getAll(){
        return databaseService.findAll();
    }
    @PostMapping("/Add")
    public ResponseEntity addClient(@RequestBody T manager){
        databaseService.save(manager);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
