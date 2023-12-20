package spring.mvc_hibernate_aop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.mvc_hibernate_aop.entity.Museum;

import java.io.File;
import java.util.List;

import static spring.mvc_hibernate_aop.data_processing_functions.ControllerDataProcessing.ProcessingPictureDataAndOperatingWithFiles;

@Repository
public class MuseumsDAOImpl implements MuseumsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List <Museum> getAllMuseums() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Museum", Museum.class).getResultList();
    }

    @Override
    public void saveMuseum(Museum museum) {
        Session session = sessionFactory.getCurrentSession();
        session.merge("Museum", museum);
    }

    @Override
    public Museum savePictureToMuseum(File file, Museum museum) {
        if (file.getName().length() > 1) {
            System.out.println("File exists. Start processing data...");
            museum.setBase64Image(ProcessingPictureDataAndOperatingWithFiles(file, museum));
            System.out.println("Status: Success");
        } else {
            System.out.println("file don`t exists. Nothing to update");
        }
        return museum;
    }

    @Override
    public Museum findMuseum(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Museum.class, id);
    }

    @Override
    public void deleteMuseum(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query <Museum> query = session.createQuery("delete from Museum where museum_id =: museumId");
        query.setParameter("museumId", id).executeUpdate();
    }

}
