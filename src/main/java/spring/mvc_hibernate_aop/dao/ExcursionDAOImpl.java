package spring.mvc_hibernate_aop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import spring.mvc_hibernate_aop.data_processing_functions.ControllerDataProcessing;
import spring.mvc_hibernate_aop.entity.Excursion;
import spring.mvc_hibernate_aop.entity.Hall;
import spring.mvc_hibernate_aop.entity.Museum;
import spring.mvc_hibernate_aop.service.GuideService;
import spring.mvc_hibernate_aop.service.HallService;
import spring.mvc_hibernate_aop.service.MuseumService;

import java.util.List;

@Repository
public class ExcursionDAOImpl implements ExcursionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List <Excursion> getAllExcursionsFromMuseum(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query <Excursion> query = session.createQuery("from Excursion where museum.museum_id = :excursion_museum_Id");
        return query.setParameter("excursion_museum_Id", id).list();
    }

    @Override
    public List <Hall> getAllHallsFromMuseum(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query <Hall> query = session.createQuery("from Hall where excursion.id_excursion=:paramExcursionId");
        return query.setParameter("paramExcursionId", id).list();
    }

    @Override
    public List <Excursion> getAllExcursions() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Excursion", Excursion.class).list();
    }

    @Override
    public Excursion findExcursion(int excursionId) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Excursion.class, excursionId);
    }

    @Override
    public void saveExcursion(Excursion excursion) {
        Session session = sessionFactory.getCurrentSession();
        session.merge("Excursion", excursion);
    }

    @Override
    public Excursion getExcursionById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Excursion.class, id);
    }

    @Override
    public void SaveHallsAndMuseumAndGuideToExcursion(BindingResult bindingResult, Excursion excursion, HallService hallService, MuseumService museumService, GuideService guideService) {
        Session session = sessionFactory.getCurrentSession();
        ControllerDataProcessing controllerDataProcessing = new ControllerDataProcessing();
        Excursion excursion1 = controllerDataProcessing.processHallIdsFromCheckboxesAndSaveHallsToExcursion(bindingResult, excursion, hallService, museumService, guideService);
        session.merge("Excursion", excursion1);
    }

    @Override
    public void deleteExcursion(int excursionId) {
        Session session = sessionFactory.getCurrentSession();
        Query <Excursion> query = session.createQuery("delete from Excursion where id_excursion =: excursion_ID");
        query.setParameter("excursion_ID", excursionId).executeUpdate();
    }
}
