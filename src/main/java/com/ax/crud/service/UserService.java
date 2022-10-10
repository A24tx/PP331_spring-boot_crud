package com.ax.crud.service;

import com.ax.crud.model.User;


import java.util.List;

public interface UserService {

    void saveUser(User u);

    void updateUser(User u);
    List<User> getUsers();

    User getUserById(Long id);

    void removeUser(Long id);


}
