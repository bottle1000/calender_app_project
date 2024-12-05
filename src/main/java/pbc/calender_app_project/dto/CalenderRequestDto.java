package pbc.calender_app_project.dto;

import lombok.Getter;
import pbc.calender_app_project.entity.Author;

import java.time.LocalDate;

@Getter
public class CalenderRequestDto {

    private String todoList;
    private String password;
    private LocalDate writeDate;
    private LocalDate updateDate;
    private Author author;

    public CalenderRequestDto(){}
}
