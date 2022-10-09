package edu.zjgu.serviceanswer.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 杨俊琛
 * @date 2021/11/16 16:45
 * @description
 */
@Controller
public class GetHtmlController {
    @PostMapping("/gethtml")
    public String getGraphAnswer(){
        return "graph";
    }
}
