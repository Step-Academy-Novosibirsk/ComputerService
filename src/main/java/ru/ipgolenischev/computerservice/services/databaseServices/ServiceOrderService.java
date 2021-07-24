package ru.ipgolenischev.computerservice.services.databaseServices;

import org.springframework.stereotype.Service;
import ru.ipgolenischev.computerservice.daos.ServiceOrdersDao;
import ru.ipgolenischev.computerservice.models.ServiceOrderModel;
import ru.ipgolenischev.computerservice.services.base.AbstractDatabaseService;

@Service
public class ServiceOrderService extends AbstractDatabaseService<ServiceOrderModel> {
    public ServiceOrderService(ServiceOrdersDao serviceOrdersDao) {
        super(serviceOrdersDao);
    }
}
