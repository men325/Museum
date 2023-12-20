package spring.mvc_hibernate_aop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc_hibernate_aop.entity.Museum;
import spring.mvc_hibernate_aop.entity.Showpiece;

import java.util.List;

@Repository
public class ShowpieceDAOImpl implements ShowpieceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List <Showpiece> getAllShowpieces(int hallId) {
        Session session = sessionFactory.getCurrentSession();
        Query <Showpiece> query = session.createQuery("from Showpiece where hall.hall_id = :hall_id", Showpiece.class);
        return query.setParameter("hall_id", hallId).getResultList();
    }

    @Override
    public void saveShowpiece(Showpiece showpiece) {
        Session session = sessionFactory.getCurrentSession();
        session.merge("Showpiece", showpiece);
    }

    @Override
    public Showpiece findShowpiece(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Showpiece.class, id);
    }

    @Override
    public void deleteShowpiece(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query <Showpiece> query = session.createQuery("delete from Showpiece where showpiece_id =: showpieceId");
        query.setParameter("showpieceId", id).executeUpdate();
    }


}
