package pbc.calender_app_project.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pbc.calender_app_project.entity.Author;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalenderResponseDto {

    private Long id;
    private String todoList;
    private LocalDate writeDate;
    private LocalDate updateDate;
    private Author author;

    public CalenderResponseDto(Long id, String toDoList, Author author) {
        this.id = id;
        this.todoList = toDoList;
        this.author = author;
    }

    public CalenderResponseDto(String todoList, Author author, LocalDate writeDate, LocalDate updateDate) {
        this.todoList = todoList;
        this.author = author;
    }
}
