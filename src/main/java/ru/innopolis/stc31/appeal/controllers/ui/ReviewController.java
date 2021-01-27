package ru.innopolis.stc31.appeal.controllers.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * UI controller for review page
 */
@Controller
public class ReviewController {

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("messagePart", "Appeal application");
        return "index";
    }
}
