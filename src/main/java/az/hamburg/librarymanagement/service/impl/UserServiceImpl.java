package az.hamburg.librarymanagement.service.impl;

import az.hamburg.librarymanagement.entity.User;
import az.hamburg.librarymanagement.exception.error.ErrorMessage;
import az.hamburg.librarymanagement.exception.handler.UserAlreadyExistsException;
import az.hamburg.librarymanagement.exception.handler.UserNotFoundException;
import az.hamburg.librarymanagement.mappers.UserMapper;
import az.hamburg.librarymanagement.model.request.UserCreateRequest;
import az.hamburg.librarymanagement.model.request.UserRegistrationRequest;
import az.hamburg.librarymanagement.model.request.UserUpdateRequest;
import az.hamburg.librarymanagement.model.response.UserCreateResponse;
import az.hamburg.librarymanagement.model.response.UserReadResponse;
import az.hamburg.librarymanagement.model.response.UserRegistrationResponse;
import az.hamburg.librarymanagement.model.response.UserUpdateResponse;
import az.hamburg.librarymanagement.repository.UserRepository;
import az.hamburg.librarymanagement.service.UserService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserCreateResponse create(UserCreateRequest createRequest) {
        User user = userMapper.createRequestToEntity(createRequest);
        log.info("User Create Request: {}", createRequest);

        User saved = userRepository.save(user);
        log.info("Saved User: {}", saved);

        UserCreateResponse userCreateResponse = userMapper.entityToCreateResponse(user);
        log.info("User create response {}", userCreateResponse);
        return userCreateResponse;
    }

    @Override
    public UserReadResponse getId(Long id) {
        User foundedUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(ErrorMessage.USER_NOT_FOUND, HttpStatus.NOT_FOUND.name()));
        log.info("Founded User : {}", foundedUser);

        UserReadResponse userReadResponse = userMapper.entityToReadResponse(foundedUser);
        log.info("User Read Response {}", userReadResponse);
        return userReadResponse;
    }

    @Override
    public List<UserReadResponse> getAll() {
        List<User> userList = userRepository.findAll();
        return userMapper.listEntityToListReadResponse(userList);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(ErrorMessage.USER_NOT_FOUND, HttpStatus.NOT_FOUND.name()));
        userRepository.deleteById(user.getId());
    }

    @Override
    public UserUpdateResponse update(Long id, UserUpdateRequest updateRequest) {
        User foundedUser = userRepository
                .findById(id).orElseThrow(() -> new UserNotFoundException(ErrorMessage.USER_NOT_FOUND, HttpStatus.NOT_FOUND.name()));
        User savedUser = userMapper.updateRequestToEntity(updateRequest);
        savedUser.setId(foundedUser.getId());
        userRepository.save(savedUser);

        return userMapper.entityToUpdateResponse(savedUser);
    }

    @Override
    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {

        Optional<User> foundUser = userRepository.findByEmailAndPin(request.getEmail(), request.getPin());
        log.info("User founded : {}", foundUser);

        if (foundUser.isPresent()) {
            throw new UserAlreadyExistsException(HttpStatus.BAD_REQUEST.name(), ErrorMessage.USER_ALREADY_EXISTS);
        }

        User user = userMapper.registrationRequestToEntity(request);
        log.info("User Entity : {}", user);

        userRepository.save(user);

        UserRegistrationResponse response = userMapper.entityToRegistrationResponse(user);
        log.info("Registration Response : {}", response);

        return response;
    }

}