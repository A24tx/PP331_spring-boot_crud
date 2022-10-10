package com.ax.crud.service;

import com.ax.crud.model.User;
import com.ax.crud.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveUser(User u) {
        repository.save(u);
    }

    @Override
    public void updateUser(User u) {
        Optional<User> fromDB = repository.findById(u.getId());
        if (fromDB.isPresent()) {
            User userFromDB = fromDB.get();
            userFromDB.setAge(u.getAge());
            userFromDB.setCountry(u.getCountry());
            userFromDB.setName(u.getName());
        }
    }

    @Override
    public void removeUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return repository.getReferenceById(id);
    }

}
