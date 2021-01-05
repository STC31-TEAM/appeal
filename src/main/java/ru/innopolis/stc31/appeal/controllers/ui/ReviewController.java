package ru.innopolis.stc31.appeal.controllers.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("title", "Appeal application");
        return "index";
    }
}
