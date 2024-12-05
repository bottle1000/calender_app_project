package pbc.calender_app_project.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import pbc.calender_app_project.entity.Author;

import java.time.LocalDate;

@Getter
public class CalenderRequestDto {

    @Size(message = "할 일은 200자 이내로 입력해주세요.", max = 200)
    private String todoList;
    @NotNull(message = "비밀번호는 필수로 입력해주세요.")
    private String password;
    private LocalDate writeDate;
    private LocalDate updateDate;
    @Valid
    private Author author;

    public CalenderRequestDto(){}
}
