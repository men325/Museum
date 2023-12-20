package spring.mvc_hibernate_aop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.mvc_hibernate_aop.entity.Excursion;
import spring.mvc_hibernate_aop.entity.Hall;
import spring.mvc_hibernate_aop.entity.Museum;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HallDAOImpl implements HallDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private MuseumsDAO museumsDAO;

    @Autowired
    private ExcursionDAO excursionDAO;

    @Override
    public Hall findHall(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Hall.class, id);
    }

    @Override
    public void saveHall(Hall hall) {
        Session session = sessionFactory.getCurrentSession();
        session.merge("Hall", hall);
    }

    @Override
    public void deleteHall(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query <Museum> query = session.createQuery("delete from Hall where hall_id =: hallId");
        query.setParameter("hallId", id).executeUpdate();
    }

    @Override
    public List <Hall> getAllHalls() {
        Session session = sessionFactory.getCurrentSession();
        Query <Hall> query = session.createQuery("from Hall", Hall.class);
        return query.getResultList();
    }

    @Override
    public Hall AddMuseumAndExcursionDataToHall(int museumId, int excursionId, Hall hall) {
        museumId = hall.getMuseum().getMuseum_id();
        Museum museum = museumsDAO.findMuseum(museumId);
        excursionId = hall.getExcursion().getId_excursion();
        Excursion excursion = excursionDAO.findExcursion(excursionId);
        hall.setMuseum(museum);
        hall.setExcursion(excursion);
        return hall;
    }

    @Override
    public List <Hall> getAllHallsOfTheMuseum(int museumId) {
        Session session = sessionFactory.getCurrentSession();
        Query <Hall> query = session.createQuery("from Hall where museum.museum_id = :museum_id");
        return query.setParameter("museum_id", museumId).list();
    }

    @Override
    public List <Hall> getAllFreeHallsOfTheMuseum(int museumId) {
        Session session = sessionFactory.getCurrentSession();
        Query <Hall> query = session.createQuery("from Hall where excursion.id_excursion IS null and museum.museum_id = :museum_id");
        return query.setParameter("museum_id", museumId).list();
    }

    @Override
    public List <Hall> getAllFreeHallsAndWithThisIDExcursionOfTheMuseum(int museumId, int excursionId) {
        Session session = sessionFactory.getCurrentSession();
        Query <Hall> query = session.createQuery("from Hall where excursion.id_excursion = :excursion_id OR excursion.id_excursion IS null and museum.museum_id = :museum_id");

        return query.setParameter("excursion_id", excursionId).setParameter("museum_id", museumId).list();
    }

    @Override
    public List <Hall> getAllHallsWithExcursions(List <Hall> MuseumFullhallList, int excursion_id) {
        List <Hall> ExcursionHallList = new ArrayList <>();
        for (Hall hall : MuseumFullhallList) {
            if (hall.getExcursion() != null) {
                if (hall.getExcursion().getId_excursion() == excursion_id) {
                    ExcursionHallList.add(hall);
                }
            }
        }
        return ExcursionHallList;
    }

    //SELECT * FROM `hall` WHERE `excursion_id` = 64
    @Override
    public List <Hall> getAllHallsWithThisExcursionID(int excursionId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Hall where excursion.id_excursion = :excursion_id", Hall.class).setParameter("excursion_id", excursionId).list();
    }

    @Override
    public void setExcursionIdNUllToThisHall(Hall hall) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Hall set excursion.id_excursion = NULL where hall_id = :hall_Id").setParameter("hall_Id", hall.getHall_id()).executeUpdate();
    }


}
