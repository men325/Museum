package spring.mvc_hibernate_aop.dao;

import spring.mvc_hibernate_aop.entity.User;

import java.util.List;

public interface UserDAO {
    public List <User> getAllUsersFromThisExcursion(int excursionId);

    public void saveUser(User user);

    public User findUser(int userId);

    public void deleteUser(int userId);
    
}
