package pbc.calender_app_project.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CalenderPagedDto {
    private Long id;
    private String todoList;
    private AuthorPagedDto authorPagedDto;
}
