package az.hamburg.librarymanagement.service;

import az.hamburg.librarymanagement.model.request.BookCreateRequest;
import az.hamburg.librarymanagement.model.response.BookCreateResponse;

public interface BookService {

    BookCreateResponse create(Long id ,BookCreateRequest createRequest);
}
