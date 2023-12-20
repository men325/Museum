package spring.mvc_hibernate_aop.dao;

import spring.mvc_hibernate_aop.entity.Excursion;
import spring.mvc_hibernate_aop.entity.Hall;

import java.util.List;

public interface HallDAO {

    public Hall findHall(int id);

    public List <Hall> getAllHallsOfTheMuseum(int museumId);

    public List <Hall> getAllFreeHallsOfTheMuseum(int museumId);

    public List <Hall> getAllFreeHallsAndWithThisIDExcursionOfTheMuseum(int museumId, int excursionId);

    public List <Hall> getAllHallsWithExcursions(List <Hall> MuseumFullhallList, int excursion_id);

    public void saveHall(Hall hall);

    public void deleteHall(int id);

    public List <Hall> getAllHalls();

    public Hall AddMuseumAndExcursionDataToHall(int museumId, int excursionId, Hall hall);

    public List <Hall> getAllHallsWithThisExcursionID(int excursionId);

    public void setExcursionIdNUllToThisHall(Hall hall);

}
