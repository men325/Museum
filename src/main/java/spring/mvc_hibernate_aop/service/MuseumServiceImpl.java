package spring.mvc_hibernate_aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc_hibernate_aop.dao.MuseumsDAO;
import spring.mvc_hibernate_aop.entity.Museum;

import java.io.File;
import java.util.List;

@Service
public class MuseumServiceImpl implements MuseumService {

    @Autowired
    private MuseumsDAO museumsDAO;

    @Override
    @Transactional
    public List <Museum> getAllMuseums() {
        return museumsDAO.getAllMuseums();
    }

    @Override
    @Transactional
    public void saveMuseum(Museum museum) {
        museumsDAO.saveMuseum(museum);
    }

    @Override
    @Transactional
    public Museum savePictureToMuseum(File file, Museum museum) {
        return museumsDAO.savePictureToMuseum(file, museum);
    }

    @Override
    @Transactional
    public Museum findMuseum(int id) {
        return museumsDAO.findMuseum(id);
    }

    @Override
    @Transactional
    public void deleteMuseum(int id) {
        museumsDAO.deleteMuseum(id);
    }
}
