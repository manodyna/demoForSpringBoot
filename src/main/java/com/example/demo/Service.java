package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;

    public void addUser(String name, String email){
        Model m = new Model();
        m.setName(name);
        m.setEmail(email);
        repository.save(m);
    }

    public void removeUser(int id){
        Iterable<Model> m = repository.findAll();
        Iterator<Model> iterator = m.iterator();
        int i =0;
        while (iterator.hasNext()){
            int id1 = iterator.next().getId();
            if (id1==id){
                repository.delete(iterator.next());
            }
            i++;
        }
    }
}
