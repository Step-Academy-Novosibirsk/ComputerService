package ru.ipgolenischev.computerservice.daos.base;
import ru.ipgolenischev.computerservice.models.base.AbstractServiceModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.ipgolenischev.computerservice.utils.HibernateSessionFactoryUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractServiceModelDao<T extends AbstractServiceModel> {
    public void update(T abstractServiceModel){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(abstractServiceModel);
        transaction.commit();
        session.close();
    }
    public void save(T abstractServiceModel){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(abstractServiceModel);
        transaction.commit();
        session.close();
    }
    public List<T> findAll(){
        String typeName = ((ParameterizedType)(getClass().getGenericSuperclass())).getActualTypeArguments()[0].getTypeName();
        String modelName = typeName.substring(typeName.lastIndexOf('.')+1);
        return (List<T>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from "+ modelName).list();
    }

    public T findById(int id){
        Class result =(Class)(((ParameterizedType)(getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
        return  (T)HibernateSessionFactoryUtil.getSessionFactory().openSession().get(result,id);
    }
}