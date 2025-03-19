package az.hamburg.librarymanagement.service;

import az.hamburg.librarymanagement.model.request.BookCreateRequest;
import az.hamburg.librarymanagement.model.request.LibraryCreateRequest;
import az.hamburg.librarymanagement.model.response.BookCreateResponse;
import az.hamburg.librarymanagement.model.response.LibraryCreateResponse;

public interface LibraryService {

    LibraryCreateResponse create(Long id , LibraryCreateRequest createRequest);

}
