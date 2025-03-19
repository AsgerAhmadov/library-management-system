package az.hamburg.librarymanagement.service.impl;

import az.hamburg.librarymanagement.entity.Library;
import az.hamburg.librarymanagement.mappers.BookMapper;
import az.hamburg.librarymanagement.mappers.LibraryMapper;
import az.hamburg.librarymanagement.model.request.LibraryCreateRequest;
import az.hamburg.librarymanagement.model.response.LibraryCreateResponse;
import az.hamburg.librarymanagement.model.response.UserReadResponse;
import az.hamburg.librarymanagement.repository.BookRepository;
import az.hamburg.librarymanagement.repository.LibraryRepository;
import az.hamburg.librarymanagement.service.LibraryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;
    private final UserServiceImpl userServiceImpl;
    private final BookMapper bookMapper;

    @Override
    public LibraryCreateResponse create(Long id, LibraryCreateRequest createRequest) {

        UserReadResponse foundedUser = userServiceImpl.getId(id);
        Library library = libraryMapper.createRequestToEntity(createRequest);
        library.setId(foundedUser.getId());
        libraryRepository.save(library);
        LibraryCreateResponse libraryCreateResponse = libraryMapper.entityToCreateResponse(library);
        log.info("Created library: " + libraryCreateResponse);
        return libraryCreateResponse;

    }
}
