package pe.com.tcs.api.exchangerate.common.exception;

public class DBException extends BaseException{
    private static final long serialVersionUID = 1L;

    public DBException(String code, String message, Exception exception) {
        super(code, message, exception);
    }

    public DBException(String code, String message) {
        super(code, message);
    }

    public DBException(String message, Exception exception) {
        super(message, exception);
    }

    public DBException(String code, String message, String messageDeveloper, Exception exception, int status) {
        super(code, message, messageDeveloper, exception, status);
    }

    public DBException(Exception exception) {
        super(exception);
    }

    public DBException(String message) {
        super(message);
    }

    public DBException(String code, String message, String messageDeveloper, Exception exception) {
        super(code, message, messageDeveloper, exception, 0);
    }
}
