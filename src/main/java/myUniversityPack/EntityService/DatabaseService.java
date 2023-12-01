package myUniversityPack.EntityService;

import java.util.Collection;

public interface DatabaseService<T> {
    public boolean doSave(T t);
    public boolean remove(T t);
    public T findById(int id);
    public Collection<T> findAll();
}
