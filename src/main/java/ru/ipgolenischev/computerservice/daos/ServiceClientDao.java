package ru.ipgolenischev.computerservice.daos;
import ru.ipgolenischev.computerservice.daos.base.AbstractServiceModelDao;
import ru.ipgolenischev.computerservice.models.Users.ServiceClientServiceModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceClientDao extends AbstractServiceModelDao<ServiceClientServiceModel> {
    public ServiceClientServiceModel findByPhone(String phone){
        List<ServiceClientServiceModel> clients = findAll();
        for(ServiceClientServiceModel serviceClientServiceModel : clients){
            if(serviceClientServiceModel.getPhone().equals(phone))
                return serviceClientServiceModel;
        }
        return null;
    }

}
