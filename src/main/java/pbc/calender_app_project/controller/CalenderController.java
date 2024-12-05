package pbc.calender_app_project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbc.calender_app_project.dto.CalenderRequestDto;
import pbc.calender_app_project.dto.CalenderResponseDto;
import pbc.calender_app_project.dto.UpdateRequestDto;
import pbc.calender_app_project.service.CalenderService;

import java.util.List;

@RestController
@RequestMapping("/calenders")
public class CalenderController {

    private static final Logger log = LoggerFactory.getLogger(CalenderController.class);
    private CalenderService calenderService;

    public CalenderController(CalenderService calenderService) {
        this.calenderService = calenderService;
    }

    /**
     * 생성 controller
     * @param dto
     * @return
     */
    @PostMapping
    public ResponseEntity<CalenderResponseDto> createCalender(@RequestBody CalenderRequestDto dto) {

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

        return new ResponseEntity<>(calenderService.findById(id), HttpStatus.OK);
    }

    /**
     * 수정 controller
     * @param id : calender id
     * @param dto
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<CalenderResponseDto> updateTodoListAndName(@PathVariable Long id, @RequestBody UpdateRequestDto dto) {

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
    public ResponseEntity<String> removeCalender(@PathVariable Long id, @RequestBody CalenderRequestDto dto) {
        calenderService.removeCalender(id, dto.getPassword());
        return ResponseEntity.ok("정상적으로 삭제되었습니다.");
    }
}
