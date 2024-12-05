package pbc.calender_app_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Author {
    private Long id;
    private String name;
    private String email;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Author() {}

    public Author(long id, String name, String email, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
