package ru.ipgolenischev.computerservice.daos;

import org.springframework.stereotype.Component;
import ru.ipgolenischev.computerservice.daos.base.AbstractServiceModelDao;
import ru.ipgolenischev.computerservice.models.ServiceOrderModel;
import ru.ipgolenischev.computerservice.models.Users.ServiceClientServiceModel;


@Component
public class ServiceOrdersDao extends AbstractServiceModelDao<ServiceOrderModel> {
    private final ServiceClientDao serviceClientDao;
    public ServiceOrdersDao(ServiceClientDao serviceClientDao){
        this.serviceClientDao = serviceClientDao;
    }
    @Override
    public void save(ServiceOrderModel abstractServiceModel) {
        ServiceClientServiceModel clientServiceModel = serviceClientDao.findById(abstractServiceModel.getClient().getId());
        if(clientServiceModel!=null)
            abstractServiceModel.setClient(clientServiceModel);
        else
            serviceClientDao.save(abstractServiceModel.getClient());
        super.save(abstractServiceModel);
    }
}
