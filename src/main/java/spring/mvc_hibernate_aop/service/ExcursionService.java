package spring.mvc_hibernate_aop.service;

import org.springframework.validation.BindingResult;
import spring.mvc_hibernate_aop.entity.Excursion;
import spring.mvc_hibernate_aop.entity.Hall;

import java.util.List;

public interface ExcursionService {
    public List <Excursion> getAllExcursionsFromMuseum(int id);

    public Excursion getExcursionById(int id);

    public void processHallIdsFromCheckboxesAndSaveHallsAndMuseumAndGuideToExcursion(BindingResult bindingResult, Excursion Excursion, HallService hallService, MuseumService museumService, GuideService guideService);

    public List <Hall> getAllHallsFromMuseum(int id);

    public List <Excursion> getAllExcursions();

    public Excursion findExcursion(int excursionId);

    public void saveExcursion(Excursion excursion);

    public void deleteExcursion(int excursionId);
}
