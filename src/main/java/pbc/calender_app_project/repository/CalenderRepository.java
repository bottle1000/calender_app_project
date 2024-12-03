package pbc.calender_app_project.repository;

import pbc.calender_app_project.dto.CalenderResponseDto;
import pbc.calender_app_project.dto.UpdateAtAndNameDto;
import pbc.calender_app_project.entity.Calender;

import java.util.List;
import java.util.Optional;

public interface CalenderRepository {

    CalenderResponseDto createCalender(Calender calender);

    List<UpdateAtAndNameDto> findAllCalenders();

    Optional<CalenderResponseDto> findById(Long id);
}
