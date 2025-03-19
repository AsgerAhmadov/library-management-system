package az.hamburg.librarymanagement.exception.handler;

public class UnAuthorizationUserException extends RuntimeException {

    public  UnAuthorizationUserException(String message ,  String code) {
        super(message);
    }
}
