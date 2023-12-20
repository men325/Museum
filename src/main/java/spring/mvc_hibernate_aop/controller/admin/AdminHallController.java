package spring.mvc_hibernate_aop.controller.admin;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.mvc_hibernate_aop.entity.Hall;
import spring.mvc_hibernate_aop.entity.Museum;
import spring.mvc_hibernate_aop.service.ExcursionService;
import spring.mvc_hibernate_aop.service.HallService;
import spring.mvc_hibernate_aop.service.MuseumService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHallController {

    @Autowired
    private HallService hallService;

    @Autowired
    private MuseumService museumService;

    @RequestMapping("/showHalls")
    public String showAllHallsOfTheMuseum(@RequestParam("museumId") int id, Model model) {
        List <Hall> hallList = hallService.getAllHallsInMuseum(id);
        if (hallList.size() == 0) {
            return "redirect:/admin/addNewHall?museumId=" + id;
        }
        model.addAttribute("hallList", hallList).addAttribute("museumID", id);
        return "admin/admin-hall/admin-halls";
    }

    @RequestMapping("/addNewHall")
    public String addNewHall(@RequestParam("museumId") int id, Model model) {
        List <Museum> museumList = museumService.getAllMuseums();
        Museum museum = (museumList.stream().filter(museum2 -> museum2.getMuseum_id() == id)).toList().get(0);
        museumList.remove(museum);
        model.addAttribute("hall", new Hall()).addAttribute("museumList", museumList).addAttribute("museumToShow", museum);
        return "admin/admin-hall/hall-add-update";
    }

    @RequestMapping("/saveHall")
    public String saveHall(@Valid  @ModelAttribute("hall") Hall hall, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "redirect:/admin/addNewHall?museumId=" + hall.getMuseum().getMuseum_id();
        }else {
            Hall hallWithMuseumAndExcursionData = hallService.addMuseumAndExcursionDataToHall(hall.getMuseum().getMuseum_id(), hall.getExcursion().getId_excursion(), hall);
            hallService.saveHall(hallWithMuseumAndExcursionData);
            return "redirect:/admin/showHalls?museumId=" + hall.getMuseum().getMuseum_id();
        }
    }

    @RequestMapping("/updateHall")
    public String updateHall(@RequestParam("hMuseumId") int id_mus, @RequestParam("hallId") int id, Model model) {
        Hall hall = hallService.findHall(id);
        List <Museum> museumList = museumService.getAllMuseums();
        Museum museum = (museumList.stream().filter(museum2 -> museum2.getMuseum_id() == id_mus)).toList().get(0);
        museumList.remove(museum);
        model.addAttribute("hall", hall).addAttribute("museumList", museumList).addAttribute("museumToShow", museum);
        return "admin/admin-hall/hall-add-update";
    }

    @RequestMapping("/deleteHall")
    public String deleteHall(@RequestParam("hMuseumId") int id_mus, @RequestParam("hallId") int id) {
        hallService.deleteHall(id);
        return "redirect:/admin/showHalls?museumId=" + id_mus;
    }


}
