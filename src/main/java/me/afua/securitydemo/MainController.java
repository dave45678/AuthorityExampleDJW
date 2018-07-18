package me.afua.securitydemo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String showIndex()
    {


        return "index";
    }

    @RequestMapping("/admin")
    public String showAdminPage(Authentication authentication, Model model)
    {
        String msg = "";
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String role = authority.getAuthority();
            msg+= authentication.getName()+", You have "+ role;
        }
        model.addAttribute("msg",msg);
        return "admin";
    }

    @RequestMapping("/teacher")
    public String showTeacherPage()
    {

        return "index";
    }


    @RequestMapping("/adminteacher")
    public String showAdminTeacherPage()
    {

        return "index";
    }



    @RequestMapping("/loggedin")
    public String showLoggedInUserPage()
    {

        return "index";
    }




}


