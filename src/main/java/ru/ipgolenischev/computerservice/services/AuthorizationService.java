package ru.ipgolenischev.computerservice.services;
import org.springframework.stereotype.Service;
import ru.ipgolenischev.computerservice.daos.ServiceClientDao;
import ru.ipgolenischev.computerservice.daos.ServiceManagerDao;
import ru.ipgolenischev.computerservice.models.Users.ServiceClientServiceModel;
import ru.ipgolenischev.computerservice.models.Users.ServiceManagerServiceModel;
import ru.ipgolenischev.computerservice.models.base.AbstractServiceUserServiceModel;

@Service
public class AuthorizationService {
    private final ServiceClientDao serviceClientDao;
    private final ServiceManagerDao serviceManagerDao;
    public AuthorizationService(ServiceManagerDao serviceManagerDao, ServiceClientDao serviceClientDao){
        this.serviceClientDao = serviceClientDao;
        this.serviceManagerDao = serviceManagerDao;
    }

    public AbstractServiceUserServiceModel authorize(String phone, String password){
        ServiceClientServiceModel client = serviceClientDao.findByPhone(phone);
        ServiceManagerServiceModel manager = serviceManagerDao.findByPhone(phone);
        if(client==null && manager==null)
            return null;
        if(client!=null && client.getPassword().equals(password))
            return client;
        if(manager!=null && manager.getPassword().equals(password))
            return manager;
        return null;
    }
}