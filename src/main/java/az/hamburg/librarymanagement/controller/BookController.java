package az.hamburg.librarymanagement.controller;

import az.hamburg.librarymanagement.entity.Book;
import az.hamburg.librarymanagement.model.request.BookCreateRequest;
import az.hamburg.librarymanagement.model.response.BookCreateResponse;
import az.hamburg.librarymanagement.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/books")
@RequiredArgsConstructor
@Tag(name = "Book Controller API", description = "Managing Book Apis")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class BookController {

    private final BookService bookService;

    @PostMapping("/user/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public BookCreateResponse create(@PathVariable Long id ,@RequestBody BookCreateRequest createRequest) {
        return bookService.create(id , createRequest);
    }

}
