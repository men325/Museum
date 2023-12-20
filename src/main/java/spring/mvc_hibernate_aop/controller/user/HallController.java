package spring.mvc_hibernate_aop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.mvc_hibernate_aop.entity.Hall;
import spring.mvc_hibernate_aop.service.HallService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class HallController {
    @Autowired
    private HallService hallService;

    @RequestMapping("/showHalls")
    public String getManyHalls(@RequestParam("museumId") int id, Model model) {
        System.out.println("museumId: " + id);
        List <Hall> hallList = hallService.getAllHallsInMuseum(id);
        model.addAttribute("museum_Id", id);
        model.addAttribute("hallList", hallList);
        return "user/halls-info";
    }

    @RequestMapping("/showHallsOfExcursion")
    public String getHallsOfExcursion(@RequestParam("excursionId") int exId, @RequestParam("museumId") int mId, Model model){
        System.out.println("excursionId: " + exId);
        List <Hall> hallList = hallService.getAllHallsWithExcursions(hallService.getAllHalls(), exId);
        model.addAttribute("museum_Id", mId);
        model.addAttribute("hallList", hallList);
        return "user/halls-info";
    }
}
