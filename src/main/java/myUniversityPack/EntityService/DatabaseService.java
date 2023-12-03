package myUniversityPack.EntityService;

import java.util.Collection;

public interface DatabaseService<T> {
    public boolean doSave(T t);
    public boolean remove(T t);
    default T findById(int id){return null;}
    public T findById(String matricola);
    public Collection<T> findAll();
}
