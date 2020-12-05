package ru.innopolis.stc31.appeal;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.stc31.appeal.model.User;

/**
 * First controller for testing work spring-boot
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @RequestMapping(value = "/second_page", method = { RequestMethod.GET, RequestMethod.POST })
    public String page2() {
        return "This is page2 in spring-boot application!";
    }
    
    @RequestMapping(value = "/save_user", method = { RequestMethod.PUT })
    public void saveUser(@RequestBody User user) {
        // save model
    }
}
