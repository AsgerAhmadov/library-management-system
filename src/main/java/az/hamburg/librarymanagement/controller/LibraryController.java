package az.hamburg.librarymanagement.controller;


import az.hamburg.librarymanagement.model.request.BookCreateRequest;
import az.hamburg.librarymanagement.model.request.LibraryCreateRequest;
import az.hamburg.librarymanagement.model.response.BookCreateResponse;
import az.hamburg.librarymanagement.model.response.LibraryCreateResponse;
import az.hamburg.librarymanagement.service.LibraryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/libraries")
@RequiredArgsConstructor
@Tag(name = "Library Controller API", description = "Managing Library Apis")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class LibraryController {

    private final LibraryService libraryService;

    @PostMapping("/user/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public LibraryCreateResponse create(@PathVariable Long id , @RequestBody LibraryCreateRequest createRequest) {
        return libraryService.create(id, createRequest);

    }

}
