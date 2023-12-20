package spring.mvc_hibernate_aop.service;

import spring.mvc_hibernate_aop.entity.Excursion;
import spring.mvc_hibernate_aop.entity.Hall;

import java.util.List;

public interface HallService {

    public Hall findHall(int id);

    public List <Hall> getAllHalls();

    public List <Hall> getAllHallsInMuseum(int museum_id);

    public List <Hall> getAllFreeHallsOfTheMuseum(int museumId);

    public List <Hall> getAllFreeHallsAndWithThisIDExcursionOfTheMuseum(int museumId, int excursionId);

    public List <Hall> getAllHallsWithExcursions(List <Hall> MuseumFullhallList, int excursion_id);

    public List <Hall> getAllHallsWithThisExcursionID(int excursion_id);

    public void saveHall(Hall hall);

    public void deleteHall(int id);

    public Hall addMuseumAndExcursionDataToHall(int museumId, int excursionId, Hall hall);

    public void setExcursionIdNUllToThisHall(Hall hall);

}
