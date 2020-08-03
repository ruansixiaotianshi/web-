package com.southwind.springboottest.controller;

import com.southwind.springboottest.entity.User;
import lombok.val;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

///user/oauth/yuque/  state=123456&response_type=code
@RestController
@RequestMapping("/user/oauth")
public class yuQueController {

    @RequestMapping("/yuque")
    public RedirectView yuque(@RequestParam(name = "state") String state, @RequestParam(name = "response_type") String response_type){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("http://localhost:8181/status=-1");

        RedirectView redirectTarget = new RedirectView();
        redirectTarget.setContextRelative(true);
        redirectTarget.setUrl("http://localhost:8181/status=-1");

//        redirectAttributes.addAttribute("param", "value");
//        redirectAttributes.addFlashAttribute("flashParam", "flashValue");
        return redirectTarget;

    }
}
