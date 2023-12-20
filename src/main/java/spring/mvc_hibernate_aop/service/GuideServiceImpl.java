package spring.mvc_hibernate_aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc_hibernate_aop.dao.GuideDAO;
import spring.mvc_hibernate_aop.entity.Guide;

import java.util.List;

@Service
public class GuideServiceImpl implements GuideService {

    @Autowired
    private GuideDAO guideDAO;

    @Override
    @Transactional
    public List <Guide> getAllGuidesFromThisMuseum(int museumId) {
        return guideDAO.getAllGuidesFromThisMuseum(museumId);
    }

    @Override
    @Transactional
    public void saveGuide(Guide guide) {
        guideDAO.saveGuide(guide);
    }

    @Override
    @Transactional
    public Guide findGuide(int guideId) {
        return guideDAO.findGuide(guideId);
    }

    @Override
    @Transactional
    public void deleteGuide(int guideId) {
        guideDAO.deleteGuide(guideId);
    }
}
