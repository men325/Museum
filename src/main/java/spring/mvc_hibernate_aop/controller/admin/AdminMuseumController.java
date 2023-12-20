package spring.mvc_hibernate_aop.controller.admin;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.mvc_hibernate_aop.entity.Museum;
import spring.mvc_hibernate_aop.service.MuseumService;


import java.io.File;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminMuseumController {

    @Autowired
    private MuseumService museumService;

    @RequestMapping("/")
    public String showAllMuseums(Model model) {
        List <Museum> museumList = museumService.getAllMuseums();
        model.addAttribute("adminAllMuseums", museumList);
        return "admin/admin-museum/admin-museum";
    }

    @RequestMapping("/addNewMuseum")
    public String addNewMuseum(Model model) {
        model.addAttribute("museum", new Museum());
        return "admin/admin-museum/museum-add-update";
    }

    @RequestMapping("/saveMuseum")
    public String saveMuseum(@Valid  @ModelAttribute("museum") Museum museum, BindingResult bindingResult, @RequestParam("file") File file) {
        if(bindingResult.hasErrors()){
            return "admin/admin-museum/museum-add-update";
        }else {
            Museum museumWithPicture = museumService.savePictureToMuseum(file, museum);
            museumService.saveMuseum(museumWithPicture);
            return "redirect:/admin/";
        }
    }

    @RequestMapping("/updateMuseum")
    public String updateMuseum(@RequestParam("museumId") int id, Model model) {
        Museum museum = museumService.findMuseum(id);
        model.addAttribute("museum", museum).addAttribute("fileFromController", museum.getBase64Image());
        return "admin/admin-museum/museum-add-update";
    }

    @RequestMapping("/deleteMuseum")
    public String deleteMuseum(@RequestParam("museumId") int id, Model model) {
        museumService.deleteMuseum(id);
        return "redirect:/admin/";
    }

}

