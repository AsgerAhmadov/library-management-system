package az.hamburg.librarymanagement.exception;

import az.hamburg.librarymanagement.exception.handler.BookNotFoundException;
import az.hamburg.librarymanagement.exception.handler.UserAlreadyExistsException;
import az.hamburg.librarymanagement.exception.handler.UserNotFoundException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class CustomException  {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ProblemDetail handlerUserNotFound(UserNotFoundException e) {
        return ProblemDetail.forStatusAndDetail(NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(BAD_REQUEST)
    public ProblemDetail handlerUserAlreadyExists(UserAlreadyExistsException e) {
        return ProblemDetail.forStatusAndDetail(BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ProblemDetail handlerBookNotFound(BookNotFoundException e) {
        return ProblemDetail.forStatusAndDetail(NOT_FOUND, e.getMessage());
    }

}