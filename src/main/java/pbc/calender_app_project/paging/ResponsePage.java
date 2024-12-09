package pbc.calender_app_project.paging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pbc.calender_app_project.dto.entity.CalenderPagedDto;
import java.util.List;

@Getter
@AllArgsConstructor
public class ResponsePage {
    private List<CalenderPagedDto> data;
}
