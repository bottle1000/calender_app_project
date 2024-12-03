package pbc.calender_app_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CalenderResponseDto {

    private Long id;
    private String toDoList;
    private String name;
    private String password;
    private LocalDateTime writeDate;
    private LocalDateTime updateDate;

    public CalenderResponseDto(Long id, String toDoList, String name, String password) {
        this.id = id;
        this.toDoList = toDoList;
        this.name = name;
        this.password = password;
    }
}
