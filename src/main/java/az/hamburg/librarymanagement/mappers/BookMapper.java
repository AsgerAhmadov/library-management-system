package az.hamburg.librarymanagement.mappers;

import az.hamburg.librarymanagement.entity.Book;
import az.hamburg.librarymanagement.model.request.BookCreateRequest;
import az.hamburg.librarymanagement.model.response.BookCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface BookMapper {

    Book createRequestToEntity(BookCreateRequest createRequest);

    BookCreateResponse entityToCreateResponse(Book book);
}
