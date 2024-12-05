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

    public Calender(Long id,String todoList, LocalDate writeDate, LocalDate updateDate) {
        this.id = id;
        this.todoList = todoList;
        this.writeDate = writeDate;
        this.updateDate = updateDate;
    }
}
