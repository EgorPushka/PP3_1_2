package com.example.pp3_1_2.dao;

import com.example.pp3_1_2.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@ComponentScan(value = "web")
public class UserDAOimpl implements UserDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    @Transactional
    public List<User> indexUsers() {
        return manager.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void add(User user) {
        manager.persist(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        manager.remove(manager.contains(user) ? user : manager.merge(user));
    }

    @Override
    @Transactional
    public void edit(User user) {
        manager.merge(user);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return manager.find(User.class,id);
    }

}
