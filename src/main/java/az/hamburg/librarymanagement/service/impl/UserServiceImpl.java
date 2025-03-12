package az.hamburg.librarymanagement.service.impl;

import az.hamburg.librarymanagement.entity.User;
import az.hamburg.librarymanagement.exception.error.ErrorMessage;
import az.hamburg.librarymanagement.exception.handler.UserNotFoundException;
import az.hamburg.librarymanagement.mappers.UserMapper;
import az.hamburg.librarymanagement.model.request.UserCreateRequest;
import az.hamburg.librarymanagement.model.request.UserUpdateRequest;
import az.hamburg.librarymanagement.model.response.UserCreateResponse;
import az.hamburg.librarymanagement.model.response.UserReadResponse;
import az.hamburg.librarymanagement.model.response.UserUpdateResponse;
import az.hamburg.librarymanagement.repository.UserRepository;
import az.hamburg.librarymanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserCreateResponse create(UserCreateRequest createRequest) {
        User user = userMapper.createRequestToEntity(createRequest);
        userRepository.save(user);
        return userMapper.entityToCreateResponse(user);
    }

    @Override
    public UserReadResponse getId(Long id) {
        User foundedUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(ErrorMessage.USER_NOT_FOUND, HttpStatus.NOT_FOUND.name()));
        return userMapper.entityToReadResponse(foundedUser);
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


}
