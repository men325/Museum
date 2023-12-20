package spring.mvc_hibernate_aop.service;

import spring.mvc_hibernate_aop.entity.Showpiece;

import java.util.List;

public interface ShowpieceService {

    public List <Showpiece> getShowpieceList(int hallId);

    public Showpiece findShowpiece(int id);

    public void saveShowpiece(Showpiece showpiece);

    public void deleteShowpiece(int id);
}
