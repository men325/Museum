package spring.mvc_hibernate_aop.controller.admin;

import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.mvc_hibernate_aop.entity.Excursion;
import spring.mvc_hibernate_aop.entity.Guide;
import spring.mvc_hibernate_aop.entity.Hall;
import spring.mvc_hibernate_aop.service.ExcursionService;
import spring.mvc_hibernate_aop.service.GuideService;
import spring.mvc_hibernate_aop.service.HallService;
import spring.mvc_hibernate_aop.service.MuseumService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminExcursionController extends HttpServlet {

    @Autowired
    private ExcursionService excursionService;

    @Autowired
    private MuseumService museumService;

    @Autowired
    private HallService hallService;

    @Autowired
    private GuideService guideService;

    //    * * * * * * * * SHOW ALL EXCURSIONS * * * * * * * *    //
    @RequestMapping("/showExcursions")
    public String showAllExcursions(@RequestParam("museumId") int id, Model model) {
        List <Excursion> excursionListFromMuseum = excursionService.getAllExcursionsFromMuseum(id);
        if (excursionListFromMuseum.size() == 0) {
            model.addAttribute("museumId", id);
            return "redirect:/admin/addNewExcursion?museumId=" + id;
        }
        model.addAttribute("excursionListForMuseum", excursionListFromMuseum);
        return "admin/admin-excursion/admin-excursions";
    }

    //    * * * * * * * * GET ALL HALLS EXCURSION WITH EXCURSION * * * * * * * *    //
    @RequestMapping("/showExcursionHallsInMuseum")
    public String showExcursionHallsInMuseum(@ModelAttribute("excursion") Excursion excursion, @RequestParam("excursionId") int excursion_id, @RequestParam("museumId") int id, Model model) {
        List <Hall> MuseumFullhallList = hallService.getAllHallsInMuseum(id);
        List <Hall> ExcursionHallList = hallService.getAllHallsWithExcursions(MuseumFullhallList, excursion_id);
        model.addAttribute("hallList", ExcursionHallList).addAttribute("fullHallList", MuseumFullhallList).addAttribute("museumID", id);
        return "admin/admin-excursion/admin-excursion-halls";
    }

    //    * * * * * * * * GET GUIDE WITH THIS EXCURSION * * * * * * * *    //
    @RequestMapping("/showGuideInExcusrion")
    public String showGuideInExcusrion(@ModelAttribute("excursion") Excursion excursion, @RequestParam("excursionId") int excursion_id, @RequestParam("museumId") int id, Model model) {
        Excursion excursion1 = excursionService.findExcursion(excursion_id);
        Guide guide = guideService.findGuide(excursion1.getGuide().getGuide_id());
        model.addAttribute("guide", guide).addAttribute("museumID", id);
        return "admin/admin-excursion/admin-excursion-guide";
    }

    //    * * * * * * * * ADD EXCURSION WITH HALL * * * * * * * *    //
    @RequestMapping("/addNewExcursion")
    public String addNewExcursion(@RequestParam("museumId") int museumId, Model model) {
        List <Hall> MuseumFullhallList = hallService.getAllFreeHallsOfTheMuseum(museumId);
        List <Guide> guideList = guideService.getAllGuidesFromThisMuseum(museumId);
        model.addAttribute("excursion", new Excursion()).addAttribute("fullHallsListInMuseum", MuseumFullhallList).addAttribute("museumToShow", museumId).addAttribute("fullGuideList", guideList);
        return "admin/admin-excursion/excursion-add-update";
    }

    //   * * * * * * * * SAVE EXCURSION * * * * * * * *    //
    @RequestMapping(value = "/saveExcursion")
    public String saveExcursion(@ModelAttribute("excursion") Excursion excursion, BindingResult bindingResult) {
        excursionService.processHallIdsFromCheckboxesAndSaveHallsAndMuseumAndGuideToExcursion(bindingResult, excursion, hallService, museumService, guideService);
        return "redirect:/admin/showExcursions?museumId=" + excursion.getMuseum().getMuseum_id();
    }

    //    * * * * * * * * UPDATE EXCURSION WITH HALL * * * * * * * *    //
    @RequestMapping("/updateExcursion")
    private String updateExcursion(@RequestParam("museumId") int mus_id, @RequestParam("excursionId") int excursion_id, Model model) {
        Excursion excursion = excursionService.findExcursion(excursion_id);
        List <Hall> MuseumFullhallList = hallService.getAllFreeHallsAndWithThisIDExcursionOfTheMuseum(mus_id, excursion_id);
        List <Guide> guideList = guideService.getAllGuidesFromThisMuseum(mus_id);
        model.addAttribute("excursion", excursion).addAttribute("fullHallsListInMuseum", MuseumFullhallList).addAttribute("fullGuideList", guideList);
        return "admin/admin-excursion/excursion-add-update";
    }

    @RequestMapping("/deleteExcursion")
    public String deleteHall(@RequestParam("museumId") int id_mus, @RequestParam("excursionId") int excursion_id) {
        excursionService.deleteExcursion(excursion_id);
        return "redirect:/admin/showExcursions?museumId=" + id_mus;
    }


}



