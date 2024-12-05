package pbc.calender_app_project.entity;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Author {
    private Long id;
    private String name;
    @Email(message = "이메일 형식이 올바르지 않습니다.")
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
