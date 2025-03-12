package az.hamburg.librarymanagement.exception.handler;


public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message ,String code) {
        super(message);
    }

}
