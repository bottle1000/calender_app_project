package pbc.calender_app_project.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pbc.calender_app_project.entity.Calender;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    public CalenderResponseDto(Calender calender) {
        this.id = calender.getId();
        this.name = calender.getName();
        this.toDoList = calender.getTodoList();
        this.writeDate = calender.getWriteDate();
        this.updateDate = calender.getUpdateDate();
    }
}
