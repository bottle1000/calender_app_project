package pbc.calender_app_project.repository;

import pbc.calender_app_project.dto.CalenderResponseDto;
import pbc.calender_app_project.entity.Calender;

import java.util.List;
import java.util.Optional;

public interface CalenderRepository {

    CalenderResponseDto createCalender(Calender calender);

    List<Calender> findAllCalenders();

    Optional<Calender> findById(Long id);

    int updateTodoListAndName(Long id, String todoList, String name);

    int removeCalender(Long id);
}
