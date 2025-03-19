package az.hamburg.librarymanagement.service;

import az.hamburg.librarymanagement.model.request.BookCreateRequest;
import az.hamburg.librarymanagement.model.request.BookUpdateRequest;
import az.hamburg.librarymanagement.model.response.BookCreateResponse;
import az.hamburg.librarymanagement.model.response.BookReadResponse;
import az.hamburg.librarymanagement.model.response.BookUpdateResponse;

import java.util.List;

public interface BookService {

    BookCreateResponse create(Long id ,BookCreateRequest createRequest);

    BookReadResponse getById(Long id);

    List<BookReadResponse> getAll();

    void delete (Long id);

    BookUpdateResponse update(Long id , BookUpdateRequest updateRequest);
}
