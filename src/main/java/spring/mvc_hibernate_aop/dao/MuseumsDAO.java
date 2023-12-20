package spring.mvc_hibernate_aop.dao;

import spring.mvc_hibernate_aop.entity.Museum;

import java.io.File;
import java.util.List;

public interface MuseumsDAO {
    public List <Museum> getAllMuseums();

    public void saveMuseum(Museum museum);

    public Museum savePictureToMuseum(File file, Museum museum);

    public Museum findMuseum(int id);

    public void deleteMuseum(int id);

}
