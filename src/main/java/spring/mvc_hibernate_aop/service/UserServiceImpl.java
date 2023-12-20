package spring.mvc_hibernate_aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc_hibernate_aop.dao.UserDAO;
import spring.mvc_hibernate_aop.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List <User> getAllUsersFromThisExcursion(int excursionId) {
        return userDAO.getAllUsersFromThisExcursion(excursionId);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User findUser(int userId) {
        return userDAO.findUser(userId);
    }

    @Override
    @Transactional
    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }
}
