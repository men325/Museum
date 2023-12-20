package spring.mvc_hibernate_aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc_hibernate_aop.dao.ShowpieceDAO;
import spring.mvc_hibernate_aop.entity.Showpiece;

import java.util.List;

@Service
public class ShowpieceServiceImpl implements ShowpieceService {

    @Autowired
    private ShowpieceDAO showpieceDAO;

    @Override
    @Transactional
    public List <Showpiece> getShowpieceList(int hallId) {
        return showpieceDAO.getAllShowpieces(hallId);
    }

    @Override
    @Transactional
    public Showpiece findShowpiece(int id) {
        return showpieceDAO.findShowpiece(id);
    }

    @Override
    @Transactional
    public void saveShowpiece(Showpiece showpiece) {
        showpieceDAO.saveShowpiece(showpiece);
    }

    @Override
    @Transactional
    public void deleteShowpiece(int id) {
        showpieceDAO.deleteShowpiece(id);
    }
}
