package pbc.calender_app_project.exception;

/**
 * 페이징 결과 빈 배열을 반환할 시 예외
 */
public class PageOutOfRangeException extends RuntimeException {
    public PageOutOfRangeException(String message) {
        super(message);
    }
}
