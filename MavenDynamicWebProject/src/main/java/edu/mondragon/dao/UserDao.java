package edu.mondragon.dao;

import java.util.List;

import edu.mondragon.entity.User;


public interface UserDao {
   boolean add(User user);
   List<User> listUsers();
   User loadUser(String username, String password);
}
