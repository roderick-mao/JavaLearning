package Dao;

public interface IDAO<E> {

    public boolean insert(E e);

    public boolean delete(long id);

    public boolean update(E e);

    public E selectOne(long id);

    public E[] selectAll();
}

