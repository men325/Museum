package spring.mvc_hibernate_aop.controller.admin;

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
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExcursionService excursionService;

    @RequestMapping("/showUsers")
    public String showAllUsersOfTheExcursion(@RequestParam("excursionId") int excursionId, Model model) {
        List <User> userList = userService.getAllUsersFromThisExcursion(excursionId);
        if (userList.size() == 0) {
            return "redirect:/admin/addNewUser?excursionId=" + excursionId;
        }
        model.addAttribute("userList", userList).addAttribute("excursionID", excursionId);
        return "admin/admin-user/admin-user";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(@RequestParam("excursionId") int excursionId, Model model) {
        model.addAttribute("user", new User()).addAttribute("excursionID", excursionId);
        return "admin/admin-user/user-add-update";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, @RequestParam("excursion.id_excursion") int excursionId) {
        if ((bindingResult.hasErrors())) {
            return "redirect:/admin/addNewUser?excursionId=" + excursionId;
        }
        Excursion excursion = excursionService.findExcursion(excursionId);
        user.setExcursion(excursion);
        userService.saveUser(user);
        return "redirect:/admin/showUsers?excursionId=" + excursionId;
    }


    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int user_id, @RequestParam("excursionId") int excursionId, Model model) {
        User user = userService.findUser(user_id);

        model.addAttribute("user", user).addAttribute("excursionId", excursionId);
        return "admin/admin-user/user-add-update";
    }

    @RequestMapping("sendMailToUser")
    public String sendMailToUser(@RequestParam("userId") int user_id, @RequestParam("excursionId") int excursionId, Model model) {
        User user = userService.findUser(user_id);
        Excursion excursion = excursionService.findExcursion(excursionId);
        MailSender.sendEmail(user, excursion);
        model.addAttribute("user", user).addAttribute("excursionId", excursionId);
        return "redirect:/admin/showUsers?excursionId=" + excursionId;
    }

    @RequestMapping("/deleteUser")
    public String deleteHall(@RequestParam("excursionId") int excursion_ID, @RequestParam("userId") int user_id) {
        userService.deleteUser(user_id);
        return "redirect:/admin/showUsers?excursionId=" + excursion_ID;
    }

}
