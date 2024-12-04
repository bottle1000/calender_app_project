package pbc.calender_app_project.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CalenderRequestDto {

    private String todoList;
    private String name;
    private String password;
    private LocalDateTime writeDate;
    private LocalDateTime updateDate;
}
