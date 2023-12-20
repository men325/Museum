package spring.mvc_hibernate_aop.service;

import spring.mvc_hibernate_aop.entity.Museum;

import java.io.File;
import java.util.List;

public interface MuseumService {
    List<Museum> getAllMuseums();

    void saveMuseum(Museum museum);

    Museum savePictureToMuseum(File file, Museum museum);

    Museum findMuseum(int id);

    void deleteMuseum(int id);
}
