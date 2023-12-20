package spring.mvc_hibernate_aop.dao;

import spring.mvc_hibernate_aop.entity.Guide;

import java.util.List;

public interface GuideDAO {
    public List <Guide> getAllGuidesFromThisMuseum(int museumId);

    public void saveGuide(Guide guide);

    public Guide findGuide(int guideId);

    public void deleteGuide(int guideId);

}
