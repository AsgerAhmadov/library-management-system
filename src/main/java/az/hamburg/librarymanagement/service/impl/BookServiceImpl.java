package az.hamburg.librarymanagement.service.impl;

import az.hamburg.librarymanagement.entity.Book;
import az.hamburg.librarymanagement.mappers.BookMapper;
import az.hamburg.librarymanagement.model.request.BookCreateRequest;
import az.hamburg.librarymanagement.model.response.BookCreateResponse;
import az.hamburg.librarymanagement.model.response.UserReadResponse;
import az.hamburg.librarymanagement.repository.BookRepository;
import az.hamburg.librarymanagement.service.BookService;
import az.hamburg.librarymanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final UserServiceImpl userServiceImpl;
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    public BookCreateResponse create(Long id ,BookCreateRequest createRequest) {
        UserReadResponse foundedUser = userServiceImpl.getId(id);
        Book book = bookMapper.createRequestToEntity(createRequest);
        book.setId(foundedUser.getId());
        bookRepository.save(book);
        return bookMapper.entityToCreateResponse(book);
    }
}
