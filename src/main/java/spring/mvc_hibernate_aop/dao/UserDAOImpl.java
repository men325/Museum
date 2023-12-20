package spring.mvc_hibernate_aop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.mvc_hibernate_aop.entity.Museum;
import spring.mvc_hibernate_aop.entity.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List <User> getAllUsersFromThisExcursion(int excursionId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User where excursion.id_excursion = :excursion_ID", User.class).setParameter("excursion_ID", excursionId).list();
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.merge("User", user);
    }

    @Override
    public User findUser(int userId) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(User.class, userId);
    }

    @Override
    public void deleteUser(int userId) {
        Session session = sessionFactory.getCurrentSession();
        Query <User> query = session.createQuery("delete from User where user_id =: user_ID");
        query.setParameter("user_ID", userId).executeUpdate();
    }
}
