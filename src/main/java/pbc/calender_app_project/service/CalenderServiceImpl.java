package pbc.calender_app_project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pbc.calender_app_project.dto.CalenderRequestDto;
import pbc.calender_app_project.dto.CalenderResponseDto;
import pbc.calender_app_project.entity.Calender;
import pbc.calender_app_project.repository.CalenderRepository;

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

        Calender calender = new Calender(dto.getTodoList(), dto.getName(), dto.getPassword());
        return calenderRepository.createCalender(calender);
    }

    @Override
    public List<CalenderResponseDto> findAllCalender() {
        return calenderRepository.findAllCalenders().stream()
                .sorted(Comparator.comparing(Calender::getUpdateDate).reversed())
                .map(calender -> new CalenderResponseDto(calender.getUpdateDate(), calender.getName()))
                .toList();
    }

    @Override
    public CalenderResponseDto findById(Long id) {
        Optional<Calender> optionalCalender = calenderRepository.findById(id);

        /**
         * NullPointException 방지
         */
        if (optionalCalender.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 정보가 존재하지 않습니다!");
        }

        return new CalenderResponseDto(optionalCalender.get());
    }

    @Override
    public CalenderResponseDto updateTodoListAndName(Long id, String todoList, String name, String password) {

         // 디버깅용
        log.info("todoList : {}", todoList);
        log.info("name : {}", name);

        if (validationPassword(id, password)) {
            calenderRepository.updateTodoListAndName(id, todoList, name);
            return new CalenderResponseDto(calenderRepository.findById(id).get());
        }

        return null;
    }

    @Override
    public void removeCalender(Long id, String password) {
        if (!validationPassword(id, password)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 맞지 않습니다.");
        }

        calenderRepository.removeCalender(id);
        log.info("정상적으로 삭제되었습니다.");
    }


    /**
     * 비밀번호 검증
     */
    private boolean validationPassword(Long id, String password){
        String calenderPassword = calenderRepository.findById(id).get().getPassword();

        if (!calenderPassword.equals(password)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 맞지 않습니다.");
        }
        return true;
    }

}
