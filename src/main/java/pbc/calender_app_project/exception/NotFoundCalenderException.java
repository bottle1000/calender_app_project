package pbc.calender_app_project.exception;

/**
 * 일정을 찾을 수 없는 예외
 */
public class NotFoundCalenderException extends RuntimeException{

    public NotFoundCalenderException(String message) {
        super(message);
    }
}
