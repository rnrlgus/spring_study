package googoo.startspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test_controller {

    @GetMapping("hello")
    public String  hello(Model model) {
        model.addAttribute("data", "hello");

        return "hello";
    }

}
