package com.example.services;

import com.example.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserServices {
    List<User> indexUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);

}
