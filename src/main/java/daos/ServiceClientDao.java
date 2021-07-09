package daos;

import models.ServiceClient;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import utils.HibernateSessionFactoryUtil;
import java.util.List;
@Component("ServiceClientDao")
public class ServiceClientDao {
    public List<ServiceClient> findAll(){
        return (List<ServiceClient>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from ServiceClient").list();

    }
    public void save(ServiceClient serviceClient){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(serviceClient);
        transaction.commit();
        session.close();
    }
    public ServiceClient findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ServiceClient.class,id);
    }
    public void update(ServiceClient serviceClient){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(serviceClient);
        transaction.commit();
        session.close();
    }
}
