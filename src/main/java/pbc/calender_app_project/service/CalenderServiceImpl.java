package pbc.calender_app_project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pbc.calender_app_project.dto.CalenderRequestDto;
import pbc.calender_app_project.dto.CalenderResponseDto;
import pbc.calender_app_project.dto.UpdateAtAndNameDto;
import pbc.calender_app_project.entity.Calender;
import pbc.calender_app_project.repository.CalenderRepository;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
public class CalenderServiceImpl implements CalenderService{

    private final CalenderRepository calenderRepository;

    public CalenderServiceImpl(CalenderRepository calenderRepository) {
        this.calenderRepository = calenderRepository;
    }

    @Override
    public CalenderResponseDto createCalender(CalenderRequestDto dto) {

        Calender calender = new Calender(dto.getToDoList(), dto.getName(), dto.getPassword());
        return calenderRepository.createCalender(calender);
    }

    @Override
    public List<UpdateAtAndNameDto> findAllCalender() {
        return calenderRepository.findAllCalenders().stream()
                .sorted(Comparator.comparing(CalenderResponseDto::getUpdateDate).reversed())
                .map(dto -> new UpdateAtAndNameDto(dto.getUpdateDate(), dto.getName()))
                .toList();
    }
}
