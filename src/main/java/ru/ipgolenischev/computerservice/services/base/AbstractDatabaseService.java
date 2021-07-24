package ru.ipgolenischev.computerservice.services.base;

import ru.ipgolenischev.computerservice.daos.base.AbstractServiceModelDao;
import ru.ipgolenischev.computerservice.models.base.AbstractServiceModel;
import java.util.List;

public abstract class AbstractDatabaseService<T extends AbstractServiceModel> {
    private final AbstractServiceModelDao<T> abstractServiceModelDao;
    public AbstractDatabaseService(AbstractServiceModelDao<T> abstractServiceModelDao) {
        this.abstractServiceModelDao = abstractServiceModelDao;
    }
    public List<T> findAll(){
        return  abstractServiceModelDao.findAll();
    }
    public void save(T abstractServiceModel){
        abstractServiceModelDao.save(abstractServiceModel);
    }
    public T findModelById(int id){
        return abstractServiceModelDao.findById(id);
    }
    public void update(T abstractServiceModel){
        abstractServiceModelDao.update(abstractServiceModel);
    }
}
