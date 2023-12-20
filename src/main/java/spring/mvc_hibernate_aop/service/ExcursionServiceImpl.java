package spring.mvc_hibernate_aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import spring.mvc_hibernate_aop.dao.ExcursionDAO;
import spring.mvc_hibernate_aop.entity.Excursion;
import spring.mvc_hibernate_aop.entity.Hall;

import java.util.List;

@Service
public class ExcursionServiceImpl implements ExcursionService {

    @Autowired
    private ExcursionDAO excursionDAO;

    @Override
    @Transactional
    public List <Excursion> getAllExcursionsFromMuseum(int id) {
        return excursionDAO.getAllExcursionsFromMuseum(id);
    }

    @Override
    @Transactional
    public Excursion getExcursionById(int id) {
        return excursionDAO.getExcursionById(id);
    }

    @Override
    @Transactional
    public void processHallIdsFromCheckboxesAndSaveHallsAndMuseumAndGuideToExcursion(BindingResult bindingResult, Excursion Excursion, HallService hallService, MuseumService museumService, GuideService guideService) {
        excursionDAO.SaveHallsAndMuseumAndGuideToExcursion(bindingResult, Excursion, hallService, museumService, guideService);
    }

    @Override
    @Transactional
    public List <Hall> getAllHallsFromMuseum(int id) {
        return excursionDAO.getAllHallsFromMuseum(id);
    }

    @Override
    @Transactional
    public List <Excursion> getAllExcursions() {
        return excursionDAO.getAllExcursions();
    }

    @Override
    @Transactional
    public Excursion findExcursion(int excursionId) {
        return excursionDAO.findExcursion(excursionId);
    }

    @Override
    @Transactional
    public void saveExcursion(Excursion excursion) {
        excursionDAO.saveExcursion(excursion);
    }

    @Override
    @Transactional
    public void deleteExcursion(int excursionId) {
        excursionDAO.deleteExcursion(excursionId);
    }
}
