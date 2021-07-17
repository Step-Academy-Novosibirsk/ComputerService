package ru.ipgolenischev.computerservice.utils;

import ru.ipgolenischev.computerservice.models.Users.ServiceClientServiceModel;
import ru.ipgolenischev.computerservice.models.Users.ServiceManagerServiceModel;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;
    private HibernateSessionFactoryUtil(){

    }
    public static SessionFactory getSessionFactory(){
        if(sessionFactory ==null){
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(ServiceClientServiceModel.class);
            configuration.addAnnotatedClass(ServiceManagerServiceModel.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory= configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
