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
import spring.mvc_hibernate_aop.entity.Showpiece;
import spring.mvc_hibernate_aop.service.HallService;
import spring.mvc_hibernate_aop.service.ShowpieceService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminShowpieceController {

    @Autowired
    private ShowpieceService showpieceService;

    @Autowired
    private HallService hallService;

    @RequestMapping("/showShowpieces")
    public String getAllShowpiecesOfTheHall(@RequestParam("hallId") int hallId, Model model) {
        List <Showpiece> showpieceList = showpieceService.getShowpieceList(hallId);
        if (showpieceList.size() == 0) {
            return "redirect:/admin/addNewShowpiece?hallId=" + hallId;
        }
        model.addAttribute("ShowpieceList", showpieceList).addAttribute("hallsID", hallId);
        return "admin/admin-showpiece/admin-showpieces";
    }

    @RequestMapping("/addNewShowpiece")
    public String addNewShowpiece(@RequestParam("hallId") int hallId, Model model) {
        List <Hall> hallList = hallService.getAllHalls();
        Hall hall = (hallList.stream().filter(hall1 -> hall1.getHall_id() == hallId)).toList().get(0);
        hallList.remove(hall);
        model.addAttribute("showpiece", new Showpiece()).addAttribute("hallList", hallList).addAttribute("hallToShow", hall);
        return "admin/admin-showpiece/showpiece-add-update";
    }

    @RequestMapping("/saveShowpiece")
    public String saveShowpiece(@Valid @ModelAttribute("showpiece") Showpiece showpiece, BindingResult bindingResult) {
        int hallId = showpiece.getHall().getHall_id();
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/addNewShowpiece?hallId=" + hallId;
        }
        Hall hall = hallService.findHall(hallId);
        showpiece.setHall(hall);
        showpieceService.saveShowpiece(showpiece);
        return "redirect:/admin/showShowpieces?hallId=" + hallId;
    }

    @RequestMapping("/updateShowpiece")
    public String updateHall(@RequestParam("sHallId") int id_hall, @RequestParam("showpieceId") int id, Model model) {
        Showpiece showpiece = showpieceService.findShowpiece(id);
        List <Hall> hallList = hallService.getAllHalls();
        Hall hall1 = (hallList.stream().filter(hall2 -> hall2.getHall_id() == id_hall)).toList().get(0);
        hallList.remove(hall1);
        model.addAttribute("showpiece", showpiece).addAttribute("hallList", hallList).addAttribute("hallToShow", hall1);
        return "admin/admin-showpiece/showpiece-add-update";
    }

    @RequestMapping("/deleteShowpiece")
    public String deleteHall(@RequestParam("hallId") int id_hall, @RequestParam("showpieceId") int id) {
        showpieceService.deleteShowpiece(id);
        return "redirect:/admin/showShowpieces?hallId=" + id_hall;
    }


}
