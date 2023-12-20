package spring.mvc_hibernate_aop.controller.admin;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.mvc_hibernate_aop.entity.Guide;
import spring.mvc_hibernate_aop.entity.Museum;
import spring.mvc_hibernate_aop.service.GuideService;
import spring.mvc_hibernate_aop.service.MuseumService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminGuideController {

    @Autowired
    private GuideService guideService;

    @Autowired
    private MuseumService museumService;

    @RequestMapping("/showGuides")
    public String showAllGuidesOfTheMuseum(@RequestParam("museumId") int id, Model model) {
        List <Guide> guideList = guideService.getAllGuidesFromThisMuseum(id);
        if (guideList.size() == 0) {
            return "redirect:/admin/addNewGuide?museumId=" + id;
        }
        model.addAttribute("guideList", guideList).addAttribute("museumID", id);
        return "admin/admin-guide/admin-guides";
    }

    @RequestMapping("/addNewGuide")
    public String addNewGuide(@RequestParam("museumId") int museum_id, Model model) {
        model.addAttribute("guide", new Guide()).addAttribute("museumId", museum_id);
        return "admin/admin-guide/guide-add-update";
    }

    @RequestMapping("/saveGuide")
    public String saveGuide(@Valid @ModelAttribute("guide") Guide guide, BindingResult bindingResult, @RequestParam("museum.museum_id") int museumId) {
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/addNewGuide?museumId=" + museumId;
        }
        Museum museum = museumService.findMuseum(museumId);
        guide.setMuseum(museum);
        guideService.saveGuide(guide);
        return "redirect:/admin/showGuides?museumId=" + museumId;
    }

    @RequestMapping("/updateGuide")
    public String updateGuide(@RequestParam("guideId") int guide_id, @RequestParam("museumId") int museum_id, Model model) {
        Guide guide = guideService.findGuide(guide_id);
        model.addAttribute("guide", guide).addAttribute("museumId", museum_id);
        return "admin/admin-guide/guide-add-update";
    }

    @RequestMapping("/deleteGuide")
    public String deleteGuide(@RequestParam("guideId") int guide_id, @RequestParam("museumId") int museum_id) {
        guideService.deleteGuide(guide_id);
        return "redirect:/admin/showGuides?museumId=" + museum_id;
    }


}
