package pbc.calender_app_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Calender {

    private Long id;
    private String todoList;
    private String password;
    private LocalDate writeDate;
    private LocalDate updateDate;
    private Author author;

    public Calender(String todoList,String password, Author author) {
        this.todoList = todoList;
        this.password = password;
        this.author = author;
    }
}
