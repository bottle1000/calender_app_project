package pbc.calender_app_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Calender {

    private Long id;
    private String toDoList;
    private String name;
    private String password;
    private LocalDate writeDate;
    private LocalDate updateDate;

    public Calender(String toDoList, String name, String password) {
        this.toDoList = toDoList;
        this.name = name;
        this.password = password;
    }
}
