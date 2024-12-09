package pbc.calender_app_project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pbc.calender_app_project.dto.entity.CalenderPagedDto;
import pbc.calender_app_project.dto.request.CalenderCreateRequestDto;
import pbc.calender_app_project.dto.response.CalenderResponseDto;
import pbc.calender_app_project.entity.Calender;
import pbc.calender_app_project.exception.InvalidPasswordException;
import pbc.calender_app_project.exception.NotFoundAuthorException;
import pbc.calender_app_project.exception.NotFoundCalenderException;
import pbc.calender_app_project.paging.ResponsePage;
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
    public CalenderResponseDto createCalender(CalenderCreateRequestDto dto) {

        Calender calender = new Calender(dto.getTodoList(), dto.getPassword(),dto.getAuthor());
        return calenderRepository.createCalender(calender);
    }

    /**
     * 업데이트 날짜 내림차순으로 수정 날짜와 이름 조회
     * -> 작성자의 고유 식별자를 통해 전체 일정 조회 코드 수정
     */
    @Override
    public List<CalenderResponseDto> findAllCalender() {
        return calenderRepository.findAllCalenders().stream()
                .map(calender -> new CalenderResponseDto(calender.getTodoList(), calender.getAuthor(),calender.getWriteDate(),calender.getUpdateDate()))
                .toList();
    }

    /**
     * 동일 유저 작성자의 할 일 목록 공개(1건 ~ N건)
     * @param id : Author Id
     * @return
     */
    @Override
    public List<CalenderResponseDto> findByUserId(Long id) {
        List<Calender> calenders = calenderRepository.findById(id);

        /**
         * NullPointException 방지
         */
        if (calenders.isEmpty()) {
            throw new NotFoundAuthorException("작성자를 찾을 수 없습니다.");
        }

       return calenders.stream()
                .map(calender -> new CalenderResponseDto(
                        calender.getId(),
                        calender.getTodoList(),
                        calender.getAuthor()))
                .toList();
    }

    @Override
    public ResponsePage findCalenders(int page, int size) {
        int offset = page * size;
        List<CalenderPagedDto> calenderList = calenderRepository.findCalenders(offset, size);

        return new ResponsePage(calenderList);
    }

    /**
     * 할 일 번호를 받아서 글의 password와 일치하면 할 일 수정과, 작성명 변경 가능
     * @param id : 할 일 번호
     * @param todoList
     * @param name
     * @param password
     * @return
     */
    @Override
    public CalenderResponseDto updateTodoListAndName(Long id, String todoList, String name, String password) {

         // 디버깅용
        log.info("todoList : {}", todoList);
        log.info("name : {}", name);

        /**
         * 비밀번호 검증 중 예외 발생 시 여기서 중단
         */
        validationPassword(id, password);

        /**
         * 업데이트 실행
         */
        calenderRepository.updateTodoListAndName(id, todoList, name);

        /**
         * 전체 할 일을 조회하여 파라미터로 들어온 할 일 번호와 매치시켜 그 할 일만 반환되게
         */
        Calender findCalender = calenderRepository.findAllCalenders().stream()
                .filter(calender -> calender.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundCalenderException("해당 일정이 없습니다."));

        return new CalenderResponseDto(findCalender.getId(), findCalender.getTodoList(), findCalender.getAuthor());
    }

    @Override
    public void removeCalender(Long id, String password) {

        /**
         * 비밀번호 검증 중 예외 발생 시 여기서 중단
         */
        validationPassword(id, password);

        /**
         * 삭제 실행
         */
        calenderRepository.removeCalender(id);
        log.info("정상적으로 삭제되었습니다."); //디버깅용 로그
    }

    /**
     * 비밀번호 검증
     * @param id
     * @param password
     * @return
     */
    private boolean validationPassword(Long id, String password){
        boolean isValid = calenderRepository.findAllCalenders().stream()
                .filter(calender -> calender.getId().equals(id))
                .anyMatch(calender -> calender.getPassword().equals(password));

        if (!isValid) {
            throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
        }
        return true;
    }

}
