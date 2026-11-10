package kh.edu.istad.b02e1restapi.repository;


import kh.edu.istad.b02e1restapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {

    private final List<User> userData;

    public UserRepository() {
        User usr1 = new User(UUID.randomUUID(), "admin", "qwer", "Administrator");
        User usr2 = new User(UUID.randomUUID(), "manager", "qwer", "Manager");
        User usr3 = new User(UUID.randomUUID(), "editor", "qwer", "Editor");
        User usr4 = new User(UUID.randomUUID(), "customer", "qwer", "Chan Dara");
        userData = new ArrayList<>();
        userData.add(usr1);
        userData.add(usr2);
        userData.add(usr3);
        userData.add(usr4);
    }

    public List<User> select() {
        return userData;
    }
    // Insert new user
    public User insert(User user) {
        userData.add(user);
        return user;
    }



}