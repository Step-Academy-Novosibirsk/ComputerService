package services;

import daos.ServiceClientDao;
import models.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("ServiceClientService")
public class ServiceClientService {
    private final ServiceClientDao serviceClientDao;
    public ServiceClientService(@Autowired ServiceClientDao serviceClientDao) {
        this.serviceClientDao = serviceClientDao;
    }
    public List<ServiceClient> findAllClients(){
        return  serviceClientDao.findAll();
    }
    public void saveServiceClient(ServiceClient serviceClient){
        serviceClientDao.save(serviceClient);
    }
    public ServiceClient findServiceClient(int id){
        return serviceClientDao.findById(id);
    }
    public void updateServiceClient(ServiceClient serviceClient){
        serviceClientDao.update(serviceClient);
    }
}
