package az.hamburg.librarymanagement.controller;

import az.hamburg.librarymanagement.entity.Book;
import az.hamburg.librarymanagement.model.request.BookCreateRequest;
import az.hamburg.librarymanagement.model.request.BookUpdateRequest;
import az.hamburg.librarymanagement.model.response.BookCreateResponse;
import az.hamburg.librarymanagement.model.response.BookReadResponse;
import az.hamburg.librarymanagement.model.response.BookUpdateResponse;
import az.hamburg.librarymanagement.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookReadResponse getById(@PathVariable Long id){
        return bookService.getById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<BookReadResponse> getAll(){
        return bookService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        bookService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookUpdateResponse update(@PathVariable Long id, @RequestBody BookUpdateRequest updateRequest) {
        return bookService.update(id , updateRequest);
    }

}
