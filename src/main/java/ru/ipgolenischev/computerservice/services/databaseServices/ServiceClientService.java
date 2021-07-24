package ru.ipgolenischev.computerservice.services.databaseServices;

import ru.ipgolenischev.computerservice.daos.ServiceClientDao;
import ru.ipgolenischev.computerservice.models.ServiceOrderModel;
import ru.ipgolenischev.computerservice.models.Users.ServiceClientServiceModel;
import org.springframework.stereotype.Service;
import ru.ipgolenischev.computerservice.services.base.AbstractDatabaseService;

import java.util.List;

@Service
public class ServiceClientService extends AbstractDatabaseService<ServiceClientServiceModel> {
    public ServiceClientService(ServiceClientDao serviceClientDao) {
        super(serviceClientDao);
    }
    public List<ServiceOrderModel> getClientOrders(int clientId){
        return this.findModelById(clientId).getOrders();
    }
}
