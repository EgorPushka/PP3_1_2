package com.example.pp3_1_2.dao;


import com.example.pp3_1_2.models.User;

import java.util.List;

public interface UserDAO {
    List<User> indexUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);

}
