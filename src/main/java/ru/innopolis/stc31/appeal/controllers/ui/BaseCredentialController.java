package ru.innopolis.stc31.appeal.controllers.ui;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Basic UI controller with credentials attached
 */
public class BaseCredentialController {

    @ModelAttribute
    public void addAttributes(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean isAnonymous = principal.toString().equals("anonymousUser");

        model.addAttribute("isAnonymous", isAnonymous);

        if (!isAnonymous) {
            model.addAttribute("authUser", principal);
        }

        System.out.println(isAnonymous);
    }
}
