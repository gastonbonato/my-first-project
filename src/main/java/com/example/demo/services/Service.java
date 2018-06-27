package com.example.demo.services;

public interface Service<T> {
    
    T create(T object);

    T read(int id);

    T update(T object);

    void delete(int id);
    
}
