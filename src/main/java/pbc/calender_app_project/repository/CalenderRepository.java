package pbc.calender_app_project.repository;

import pbc.calender_app_project.dto.CalenderResponseDto;
import pbc.calender_app_project.entity.Calender;

import java.util.List;

public interface CalenderRepository {

    CalenderResponseDto createCalender(Calender calender);

    List<Calender> findAllCalenders();

    List<Calender> findById(Long id);

    void updateTodoListAndName(Long id, String todoList, String name);

    int removeCalender(Long id);
}
