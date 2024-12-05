package pbc.calender_app_project.exception;


/**
 * 비밀번호 불일치 예외
 */
public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String message) {
        super("비밀번호가 일치하지 않습니다!");
    }
}
