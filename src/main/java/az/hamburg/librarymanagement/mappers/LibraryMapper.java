package az.hamburg.librarymanagement.mappers;

import az.hamburg.librarymanagement.entity.Book;
import az.hamburg.librarymanagement.entity.Library;
import az.hamburg.librarymanagement.model.request.BookCreateRequest;
import az.hamburg.librarymanagement.model.request.LibraryCreateRequest;
import az.hamburg.librarymanagement.model.response.BookCreateResponse;
import az.hamburg.librarymanagement.model.response.LibraryCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface LibraryMapper {

    Library createRequestToEntity(LibraryCreateRequest createRequest);
    LibraryCreateResponse entityToCreateResponse(Library library);

}
