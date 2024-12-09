package pbc.calender_app_project.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbc.calender_app_project.dto.request.CalenderCreateRequestDto;
import pbc.calender_app_project.dto.response.CalenderResponseDto;
import pbc.calender_app_project.dto.request.CalenderUpdateRequestDto;
import pbc.calender_app_project.paging.ResponsePage;
import pbc.calender_app_project.service.CalenderService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/calenders")
public class CalenderController {
    private final CalenderService calenderService;

    public CalenderController(CalenderService calenderService) {
        this.calenderService = calenderService;
    }

    /**
     * 생성 controller
     * @param dto
     * @return
     */
    @PostMapping
    public ResponseEntity<CalenderResponseDto> createCalender(@Valid @RequestBody CalenderCreateRequestDto dto) {

        return new ResponseEntity<>(calenderService.createCalender(dto), HttpStatus.CREATED);
    }

    /**
     * 전체 조회 controller
     * @return
     */
    @GetMapping
    public ResponseEntity<List<CalenderResponseDto>> findAllCalender() {

        return new ResponseEntity<>(calenderService.findAllCalender(), HttpStatus.OK);
    }

    /**
     * 특정 Id 값 조회 controller
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<CalenderResponseDto>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(calenderService.findByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/paged")
    public ResponseEntity<ResponsePage> findCalenders(
            /**
             * page = 페이지 번호, 0번부터 시작
             * size = 한 페이지에 표시할 데이터 수, 한 페이지에 10개의 항목 표시
             */
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return new ResponseEntity<>(calenderService.findCalenders(page, size), HttpStatus.OK);
    }



    /**
     * 수정 controller
     * @param id : calender id
     * @param dto
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<CalenderResponseDto> updateTodoListAndName(@PathVariable Long id, @RequestBody CalenderUpdateRequestDto dto) {

        /**
         * 요청 데이터 값 확인
         */
        log.info("todolist = {}, name = {}, password = {}",dto.getTodolist(), dto.getAuthor().getName(), dto.getPassword());
        return new ResponseEntity<>(calenderService.updateTodoListAndName(id, dto.getTodolist(), dto.getAuthor().getName(), dto.getPassword()), HttpStatus.OK);
    }

    /**
     * 삭제 controller
     * @param id : 작성자 id
     * @param dto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeCalender(@PathVariable Long id, @RequestBody CalenderCreateRequestDto dto) {
        calenderService.removeCalender(id, dto.getPassword());
        return ResponseEntity.ok("정상적으로 삭제되었습니다.");
    }
}
