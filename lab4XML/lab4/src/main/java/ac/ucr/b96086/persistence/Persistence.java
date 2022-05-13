package ac.ucr.b96086.persistence;


import java.util.List;

public interface Persistence<E> {

    E save(E value );
    List<E> findAll();


}
