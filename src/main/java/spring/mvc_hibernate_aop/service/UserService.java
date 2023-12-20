package spring.mvc_hibernate_aop.service;

import spring.mvc_hibernate_aop.entity.User;

import java.util.List;

public interface UserService {
    List <User> getAllUsersFromThisExcursion(int excursionId);

    public void saveUser(User user);

    public User findUser(int userId);

    public void deleteUser(int userId);

}
