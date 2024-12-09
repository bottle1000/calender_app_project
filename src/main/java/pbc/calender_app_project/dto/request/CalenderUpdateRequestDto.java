package pbc.calender_app_project.dto.request;

import lombok.Getter;

@Getter
public class CalenderUpdateRequestDto {
    private String todolist;
    private AuthorDto author;
    private String password;

    @Getter
    public static class AuthorDto {
        private String name;
    }
}
