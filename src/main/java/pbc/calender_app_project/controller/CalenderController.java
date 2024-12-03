package pbc.calender_app_project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pbc.calender_app_project.service.CalenderService;

@RestController
@RequestMapping("/calenders")
public class CalenderController {

    private CalenderService calenderService;

    public CalenderController(CalenderService calenderService) {
        this.calenderService = calenderService;
    }


}
