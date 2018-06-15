package com.example.demo.DataAccesObject;

public interface DAOInterface<T> {

   T persist(T object);

   T retrieve(Object id);

   T update(T obeject);

   void delete(Object id);

}
