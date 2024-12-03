package pbc.calender_app_project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pbc.calender_app_project.dto.CalenderRequestDto;
import pbc.calender_app_project.dto.CalenderResponseDto;
import pbc.calender_app_project.service.CalenderService;

@RestController
@RequestMapping("/calenders")
public class CalenderController {

    private CalenderService calenderService;

    public CalenderController(CalenderService calenderService) {
        this.calenderService = calenderService;
    }

    @PostMapping
    public ResponseEntity<CalenderResponseDto> createCalender(@RequestBody CalenderRequestDto dto) {

        return new ResponseEntity<>(calenderService.createCalender(dto), HttpStatus.CREATED);
    }

}
