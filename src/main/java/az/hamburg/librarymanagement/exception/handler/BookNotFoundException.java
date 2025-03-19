package az.hamburg.librarymanagement.exception.handler;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message, String code) {
        super(message);

    }
}
