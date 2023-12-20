package spring.mvc_hibernate_aop.dao;

import org.springframework.validation.BindingResult;
import spring.mvc_hibernate_aop.entity.Excursion;
import spring.mvc_hibernate_aop.entity.Hall;
import spring.mvc_hibernate_aop.service.GuideService;
import spring.mvc_hibernate_aop.service.HallService;
import spring.mvc_hibernate_aop.service.MuseumService;

import java.util.List;

public interface ExcursionDAO {
    public List <Excursion> getAllExcursionsFromMuseum(int id);

    public List <Hall> getAllHallsFromMuseum(int id);

    public List <Excursion> getAllExcursions();

    public Excursion findExcursion(int excursionId);

    public void saveExcursion(Excursion excursion);

    public Excursion getExcursionById(int id);

    public void SaveHallsAndMuseumAndGuideToExcursion(BindingResult bindingResult, Excursion excursion, HallService hallService, MuseumService museumService, GuideService guideService);

    public void deleteExcursion(int excursionId);
    
}
