package Dao;

public interface IDAO<E> {

    public boolean insert(E e);

    public boolean delete(Long id);

    public boolean update(E e);

    public E selectOne(Long id);

    public E[] selectAll();
}

