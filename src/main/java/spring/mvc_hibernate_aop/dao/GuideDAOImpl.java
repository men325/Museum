package spring.mvc_hibernate_aop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.mvc_hibernate_aop.entity.Guide;

import java.util.List;

@Repository
public class GuideDAOImpl implements GuideDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List <Guide> getAllGuidesFromThisMuseum(int museum_id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Guide where museum.museum_id = :museumId", Guide.class).setParameter("museumId", museum_id).list();
    }

    @Override
    public void saveGuide(Guide guide) {
        Session session = sessionFactory.getCurrentSession();
        session.merge("Guide", guide);
    }

    @Override
    public Guide findGuide(int guideId) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Guide.class, guideId);
    }

    @Override
    public void deleteGuide(int guideId) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete Guide where guide_id = :guideID").setParameter("guideID", guideId).executeUpdate();
    }
}
