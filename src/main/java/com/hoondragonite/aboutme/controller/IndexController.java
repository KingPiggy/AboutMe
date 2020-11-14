package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model){

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            System.out.println(user.getEmail());
            System.out.println(user.getName());
            System.out.println(user.getPicture());
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @RequestMapping(value = "/template")
    public String moveToSelect(ModelAndView modelAndView){ return "template";}

    @RequestMapping(value = "/login")
    public String moveToLogin(ModelAndView modelAndView){
        return "login";
    }

    @RequestMapping(value = "/privacy")
    public String privacy(Model model){ return "privacy"; }
}