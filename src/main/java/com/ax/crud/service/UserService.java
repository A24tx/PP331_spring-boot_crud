package com.ax.crud.service;

import com.ax.crud.model.User;


import java.util.List;

public abstract class UserService {

    public abstract void saveUser(User u);

    public abstract List<User> getUsers();

    public abstract User getUserById(Long id);

    public abstract void removeUser(Long id);


}
