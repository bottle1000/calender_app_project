package pbc.calender_app_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CalenderResponseDto {

    private Long id;
    private String toDoList;
    private String name;
    private LocalDate writeDate;
    private LocalDate updateDate;

    public CalenderResponseDto(Long id, String toDoList, String name) {
        this.id = id;
        this.toDoList = toDoList;
        this.name = name;
    }

    public CalenderResponseDto(LocalDate updatedAt, String name) {
        this.updateDate = updatedAt;
        this.name = name;
    }
}
