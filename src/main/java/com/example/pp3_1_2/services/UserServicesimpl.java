package com.example.pp3_1_2.services;

import com.example.pp3_1_2.dao.UserDAO;
import com.example.pp3_1_2.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServicesimpl implements UserServices {

    private final UserDAO userDAO;

    public UserServicesimpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> indexUsers() {
        return userDAO.indexUsers();
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

}
