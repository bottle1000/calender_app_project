package pbc.calender_app_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

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

    public Calender(Long id, String name, String toDoList, LocalDate writeDate, LocalDate updateDate) {
        this.id = id;
        this.name = name;
        this.toDoList = toDoList;
        this.writeDate = writeDate;
        this.updateDate = updateDate;
    }
}
