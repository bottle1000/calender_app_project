package pbc.calender_app_project.dto;

import lombok.Getter;

@Getter
public class UpdateRequestDto {
    private String todolist;
    private AuthorDto author;
    private String password;

    @Getter
    public static class AuthorDto {
        private String name;
    }
}
