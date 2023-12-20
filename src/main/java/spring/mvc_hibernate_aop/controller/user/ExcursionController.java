package spring.mvc_hibernate_aop.controller.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.mvc_hibernate_aop.data_processing_functions.MailSender;
import spring.mvc_hibernate_aop.entity.Excursion;
import spring.mvc_hibernate_aop.entity.User;
import spring.mvc_hibernate_aop.service.ExcursionService;
import spring.mvc_hibernate_aop.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class ExcursionController {
    @Autowired
    private ExcursionService excursionService;
    @Autowired
    private UserService userService;

    @RequestMapping("/showExcursions")
    public String showAllExcursions(@RequestParam("museumId") int id, Model model) {
        List <Excursion> excursionListFromMuseum = excursionService.getAllExcursionsFromMuseum(id);
        model.addAttribute("museum_Id", id);
        model.addAttribute("excursionListForMuseum", excursionListFromMuseum);
        return "user/excursions-info";
    }

    @RequestMapping("/aboutExcursion")
    public String aboutExcursion(@RequestParam("excursionId") int id, Model model) {
        Excursion excursion = excursionService.getExcursionById(id);
        model.addAttribute("excursion", excursion);
        model.addAttribute("user", new User());
        return "user/about-excursion";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        int excursionId = user.getExcursion().getId_excursion();
        if (bindingResult.hasErrors()) {
            return "redirect:/user/aboutExcursion?excursionId=" + excursionId;
        }
        Excursion excursion = excursionService.findExcursion(excursionId);
        if (excursion.getExcursion_age_access() > user.getUser_age()) {
            model.addAttribute("error", "alert(\"Sorry, but your age has not been verified, you must be over " + excursion.getExcursion_age_access() + " years old\");");
            model.addAttribute("excursion", excursion);
            model.addAttribute("user", new User());
            return "user/about-excursion";
        }
        user.setExcursion(excursion);
        userService.saveUser(user);
        MailSender.sendEmail(user, excursion);
        model.addAttribute("message", "alert(\"Ticket successfully booked, check your e-mail for details.\");");
        return "user/main";
    }
}
