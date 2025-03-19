package az.hamburg.librarymanagement.mappers;

import az.hamburg.librarymanagement.entity.Book;

import az.hamburg.librarymanagement.model.request.BookCreateRequest;
import az.hamburg.librarymanagement.model.request.BookUpdateRequest;
import az.hamburg.librarymanagement.model.response.BookCreateResponse;
import az.hamburg.librarymanagement.model.response.BookReadResponse;
import az.hamburg.librarymanagement.model.response.BookUpdateResponse;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface BookMapper {

    Book createRequestToEntity(BookCreateRequest createRequest);

    BookCreateResponse entityToCreateResponse(Book book);

    BookReadResponse entityToReadResponse(Book book);

    List<BookReadResponse> listEntityToListReadResponse(List<Book> books);

    Book updateRequestToEntity(BookUpdateRequest updateRequest);

    BookUpdateResponse entityToUpdateResponse(Book book);
}
