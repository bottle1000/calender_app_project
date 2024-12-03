package pbc.calender_app_project.service;

import org.springframework.http.HttpStatusCode;
import pbc.calender_app_project.dto.CalenderRequestDto;
import pbc.calender_app_project.dto.CalenderResponseDto;
import pbc.calender_app_project.dto.UpdateAtAndNameDto;

import java.util.List;

public interface CalenderService {
    CalenderResponseDto createCalender(CalenderRequestDto dto);

    List<UpdateAtAndNameDto> findAllCalender();

    CalenderResponseDto findById(Long id);
}
