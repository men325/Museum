package spring.mvc_hibernate_aop.dao;

import spring.mvc_hibernate_aop.entity.Showpiece;

import java.util.List;

public interface ShowpieceDAO {
    public List <Showpiece> getAllShowpieces(int hallId);

    public void saveShowpiece(Showpiece showpiece);

    public Showpiece findShowpiece(int id);

    public void deleteShowpiece(int id);

}
