package informatyka.Beta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Transfer {

    @RequestMapping("/transfer")
    public String wireTransfer(){

        return "transfer";
    }
}
