package pbc.calender_app_project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbc.calender_app_project.dto.CalenderRequestDto;
import pbc.calender_app_project.dto.CalenderResponseDto;
import pbc.calender_app_project.service.CalenderService;

import java.util.List;

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

    @GetMapping
    public List<CalenderResponseDto> findAllCalender() {

        return calenderService.findAllCalender();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalenderResponseDto> findById(@PathVariable Long id) {

        return new ResponseEntity<>(calenderService.findById(id), HttpStatus.OK);
    }

}
