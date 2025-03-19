package az.hamburg.librarymanagement.service.impl;

import az.hamburg.librarymanagement.entity.Book;
import az.hamburg.librarymanagement.exception.error.ErrorMessage;
import az.hamburg.librarymanagement.exception.handler.BookNotFoundException;
import az.hamburg.librarymanagement.mappers.BookMapper;
import az.hamburg.librarymanagement.model.request.BookCreateRequest;
import az.hamburg.librarymanagement.model.request.BookUpdateRequest;
import az.hamburg.librarymanagement.model.response.BookCreateResponse;
import az.hamburg.librarymanagement.model.response.BookReadResponse;
import az.hamburg.librarymanagement.model.response.BookUpdateResponse;
import az.hamburg.librarymanagement.model.response.UserReadResponse;
import az.hamburg.librarymanagement.repository.BookRepository;
import az.hamburg.librarymanagement.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public BookReadResponse getById(Long id) {
        Book foundedBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(ErrorMessage.BOOK_NOT_FOUND, HttpStatus.NOT_FOUND.name()));
        log.info("Founded Book : {}", foundedBook);
        BookReadResponse bookReadResponse = bookMapper.entityToReadResponse(foundedBook);
        log.info("Book Read Response {}", bookReadResponse);
        return bookReadResponse;
    }

    @Override
    public List<BookReadResponse> getAll() {

        List<Book> bookList = bookRepository.findAll();
        return bookMapper.listEntityToListReadResponse(bookList);
    }

    @Override
    public void delete(Long id) {
        UserReadResponse foundedUser = userServiceImpl.getId(id);
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(ErrorMessage.BOOK_NOT_FOUND, HttpStatus.NOT_FOUND.name()));
        book.setId(foundedUser.getId());
        bookRepository.deleteById(book.getId());
    }

    @Override
    public BookUpdateResponse update(Long id, BookUpdateRequest updateRequest) {
//        UserReadResponse foundedUser = userServiceImpl.getId(id);
        Book foundedBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(ErrorMessage.BOOK_NOT_FOUND, HttpStatus.NOT_FOUND.name()));
        Book savedBook = bookMapper.updateRequestToEntity(updateRequest);
        savedBook.setId(foundedBook.getId());
        bookRepository.save(savedBook);
        return bookMapper.entityToUpdateResponse(savedBook);


    }

}
