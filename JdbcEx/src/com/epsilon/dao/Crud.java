
package com.epsilon.dao;

import java.util.*;

public interface Crud <T>{
    public int insert(T t);
    
    public int delete(int id);
    
    public int update(T t);
    
    public T get(int id);

    public List<T> getAll();
}
