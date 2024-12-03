package pbc.calender_app_project.repository;

import pbc.calender_app_project.dto.CalenderResponseDto;
import pbc.calender_app_project.entity.Calender;

public interface CalenderRepository {

    CalenderResponseDto createCalender(Calender calender);
}
