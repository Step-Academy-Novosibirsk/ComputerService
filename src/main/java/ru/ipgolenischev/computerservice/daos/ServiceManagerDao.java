package ru.ipgolenischev.computerservice.daos;
import org.springframework.stereotype.Component;
import ru.ipgolenischev.computerservice.daos.base.AbstractServiceModelDao;
import ru.ipgolenischev.computerservice.models.Users.ServiceManagerServiceModel;

import java.util.List;

@Component
public class ServiceManagerDao extends AbstractServiceModelDao<ServiceManagerServiceModel> {
    public ServiceManagerServiceModel findByPhone(String phone){
        List<ServiceManagerServiceModel> clients = findAll();
        for(ServiceManagerServiceModel serviceClientServiceModel : clients){
            if(serviceClientServiceModel.getPhone().equals(phone))
                return serviceClientServiceModel;
        }
        return null;
    }

}
