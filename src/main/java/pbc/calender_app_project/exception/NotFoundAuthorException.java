package pbc.calender_app_project.exception;

/**
 * 작성자 조회 불가 예외
 */
public class NotFoundAuthorException extends RuntimeException{
    public NotFoundAuthorException(String message) {
        super(message);
    }
}
