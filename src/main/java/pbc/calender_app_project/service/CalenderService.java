package pbc.calender_app_project.service;

import pbc.calender_app_project.dto.request.CalenderCreateRequestDto;
import pbc.calender_app_project.dto.response.CalenderResponseDto;
import pbc.calender_app_project.paging.ResponsePage;

import java.util.List;

public interface CalenderService {
    CalenderResponseDto createCalender(CalenderCreateRequestDto dto);

    List<CalenderResponseDto> findAllCalender();

    List<CalenderResponseDto> findByUserId(Long id);

    CalenderResponseDto updateTodoListAndName(Long id, String todoList, String name, String password);

    void removeCalender(Long id, String password);

    ResponsePage findCalenders(int page, int size);
}
