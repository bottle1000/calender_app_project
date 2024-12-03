package pbc.calender_app_project.service;

import pbc.calender_app_project.dto.CalenderRequestDto;
import pbc.calender_app_project.dto.CalenderResponseDto;

public interface CalenderService {
    CalenderResponseDto createCalender(CalenderRequestDto dto);
}
