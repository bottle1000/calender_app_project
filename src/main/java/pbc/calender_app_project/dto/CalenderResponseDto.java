package pbc.calender_app_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CalenderResponseDto {

    private String toDoList;
    private String name;
    private String password;
    private LocalDateTime writeDate;
    private LocalDateTime updateDate;

}
