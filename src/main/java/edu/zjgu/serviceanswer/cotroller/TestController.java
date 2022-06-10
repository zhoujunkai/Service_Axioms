package edu.zjgu.serviceanswer.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 杨俊琛
 * @date 2021/11/21 18:57
 * @description
 */
@Controller
public class TestController {
    @PostMapping("/test")
    public ModelAndView test(@RequestParam("q") String question){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.getModel().put("name",question);
        return modelAndView;
    }
}
