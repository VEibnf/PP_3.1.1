package kata.spring.boot.PP_311.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
    @GetMapping(value = "/")
    public String showStartPage() {
        return "index";
    }
}
