package ru.ipgolenischev.computerservice.services.databaseServices;

import org.springframework.stereotype.Service;
import ru.ipgolenischev.computerservice.daos.ServiceManagerDao;
import ru.ipgolenischev.computerservice.models.Users.ServiceManagerServiceModel;
import ru.ipgolenischev.computerservice.services.base.AbstractDatabaseService;
@Service
public class ServiceManagerService extends AbstractDatabaseService<ServiceManagerServiceModel> {

    public ServiceManagerService(ServiceManagerDao serviceManagerDao) {
        super(serviceManagerDao);
    }
}
