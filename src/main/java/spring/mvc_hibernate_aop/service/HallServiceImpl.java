package spring.mvc_hibernate_aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc_hibernate_aop.dao.HallDAO;
import spring.mvc_hibernate_aop.entity.Hall;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallDAO hallDAO;

    @Override
    @Transactional
    public Hall findHall(int id) {
        return hallDAO.findHall(id);
    }


    @Override
    @Transactional
    public void saveHall(Hall hall) {
        hallDAO.saveHall(hall);
    }

    @Override
    @Transactional
    public void deleteHall(int id) {
        hallDAO.deleteHall(id);
    }

    @Override
    @Transactional
    public List <Hall> getAllHalls() {
        return hallDAO.getAllHalls();
    }

    @Override
    @Transactional
    public List <Hall> getAllHallsInMuseum(int museum_id) {
        return hallDAO.getAllHallsOfTheMuseum(museum_id);
    }

    @Override
    @Transactional
    public List <Hall> getAllFreeHallsOfTheMuseum(int museumId) {
        return hallDAO.getAllFreeHallsOfTheMuseum(museumId);
    }

    @Override
    @Transactional
    public List <Hall> getAllFreeHallsAndWithThisIDExcursionOfTheMuseum(int museumId, int excursionId) {
        return hallDAO.getAllFreeHallsAndWithThisIDExcursionOfTheMuseum(museumId, excursionId);
    }

    @Override
    @Transactional
    public List <Hall> getAllHallsWithExcursions(List <Hall> MuseumFullhallList, int excursion_id) {
        return hallDAO.getAllHallsWithExcursions(MuseumFullhallList, excursion_id);
    }

    @Override
    @Transactional
    public List <Hall> getAllHallsWithThisExcursionID(int excursion_id) {
        return hallDAO.getAllHallsWithThisExcursionID(excursion_id);
    }

    @Override
    @Transactional
    public Hall addMuseumAndExcursionDataToHall(int museumId, int excursionId, Hall hall) {
        return hallDAO.AddMuseumAndExcursionDataToHall(museumId, excursionId, hall);
    }

    @Override
    @Transactional
    public void setExcursionIdNUllToThisHall(Hall hall) {
        hallDAO.setExcursionIdNUllToThisHall(hall);
    }
}
