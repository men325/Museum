package spring.mvc_hibernate_aop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvc_hibernate_aop.entity.Museum;
import spring.mvc_hibernate_aop.service.MuseumService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class MuseumController {

    @Autowired
    private MuseumService museumService;

    @RequestMapping("/")
    public String mainPage(Model model) {
        return "user/main";
    }

    @RequestMapping("/allMuseums")
    public String showAllMuseums(Model model) {
        List <Museum> museumList = museumService.getAllMuseums();
        model.addAttribute("allMuseums", museumList);
        return "user/museums-info";
    }

}
