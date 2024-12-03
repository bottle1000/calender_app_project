package pbc.calender_app_project.repository;

import pbc.calender_app_project.dto.CalenderResponseDto;
import pbc.calender_app_project.entity.Calender;

import java.util.List;

public interface CalenderRepository {

    CalenderResponseDto createCalender(Calender calender);

    List<CalenderResponseDto> findAllCalenders();
}
