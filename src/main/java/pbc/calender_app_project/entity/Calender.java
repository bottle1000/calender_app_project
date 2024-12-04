package pbc.calender_app_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Calender {

    private Long id;
    private String todoList;
    private String name;
    private String password;
    private LocalDate writeDate;
    private LocalDate updateDate;

    public Calender(String todoList, String name, String password) {
        this.todoList = todoList;
        this.name = name;
        this.password = password;
    }

    public Calender(Long id, String name, String todoList, LocalDate writeDate, LocalDate updateDate) {
        this.id = id;
        this.name = name;
        this.todoList = todoList;
        this.writeDate = writeDate;
        this.updateDate = updateDate;
    }
}
