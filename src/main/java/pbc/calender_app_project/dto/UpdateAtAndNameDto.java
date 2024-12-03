package pbc.calender_app_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UpdateAtAndNameDto {
    private LocalDate updateDate;
    private String name;
}
