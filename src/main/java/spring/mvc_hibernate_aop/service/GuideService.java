package spring.mvc_hibernate_aop.service;

import spring.mvc_hibernate_aop.entity.Guide;

import java.util.List;

public interface GuideService {
    public List <Guide> getAllGuidesFromThisMuseum(int museumId);

    public void saveGuide(Guide guide);

    public Guide findGuide(int guideId);

    public void deleteGuide(int guideId);

}
