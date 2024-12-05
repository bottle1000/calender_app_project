package pbc.calender_app_project.service;

import pbc.calender_app_project.dto.CalenderRequestDto;
import pbc.calender_app_project.dto.CalenderResponseDto;

import java.util.List;

public interface CalenderService {
    CalenderResponseDto createCalender(CalenderRequestDto dto);

    List<CalenderResponseDto> findAllCalender();

    List<CalenderResponseDto> findById(Long id);

    CalenderResponseDto updateTodoListAndName(Long id, String todoList, String name, String password);

    void removeCalender(Long id, String password);
}
