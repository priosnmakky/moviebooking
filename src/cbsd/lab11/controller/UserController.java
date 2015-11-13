package cbsd.lab11.controller;

import cbsd.lab11.entity.User;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Dto
 * Date: 2/3/13
 * Time: 1:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("user")
@SessionAttributes({"userSession","date"})
public class UserController {

    @ModelAttribute("userSession")
    public User getUserSession( ){


        return new User();
    }

    @ModelAttribute("date")
    public Date getUserDate()
    {
        return Calendar.getInstance().getTime();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("user",new User());
        return "/user/userRegister";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(@ModelAttribute User user, BindingResult bindingResult,Model model,final RedirectAttributes redirectAttributes){
        model.addAttribute("userSession",user);
        redirectAttributes.addFlashAttribute("userSession",user);
        return "redirect:/lecturer/list";
    }

   // @Autowired
    


}
