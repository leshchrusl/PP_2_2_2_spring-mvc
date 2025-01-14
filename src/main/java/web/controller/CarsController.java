package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.*;

@Controller
public class CarsController {

    private final ApplicationContext applicationContext;

    @Autowired
    public CarsController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count",
                                      required = false) Integer count,
                          Model model) {

        if (count == null) {
            count = 5;
        }

        model.addAttribute("carsList",  applicationContext
                .getBean(CarServiceImpl.class).getCars(count));
        
        return "cars";
    }

}
