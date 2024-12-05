package pbc.calender_app_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<String> handlerInvalidPasswordException(InvalidPasswordException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundAuthorException.class)
    public ResponseEntity<String> handlerNotFoundAuthorException(NotFoundAuthorException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
