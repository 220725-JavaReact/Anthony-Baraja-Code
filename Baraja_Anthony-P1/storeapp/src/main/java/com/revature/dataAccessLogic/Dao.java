package com.revature.dataAccessLogic;

import java.util.List;

/**
 * Generic Dao interface that provide basic CRUD method template for data access logic.
 * @author Anthony Baraja
 *
 * @param <T>
 */
public interface Dao<T> {
    T get(int id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
}
