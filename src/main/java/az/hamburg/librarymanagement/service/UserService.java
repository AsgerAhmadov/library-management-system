package az.hamburg.librarymanagement.service;

import az.hamburg.librarymanagement.model.request.UserCreateRequest;
import az.hamburg.librarymanagement.model.request.UserLoginRequest;
import az.hamburg.librarymanagement.model.request.UserRegistrationRequest;
import az.hamburg.librarymanagement.model.request.UserUpdateRequest;
import az.hamburg.librarymanagement.model.response.UserCreateResponse;
import az.hamburg.librarymanagement.model.response.UserReadResponse;
import az.hamburg.librarymanagement.model.response.UserRegistrationResponse;
import az.hamburg.librarymanagement.model.response.UserUpdateResponse;

import java.util.List;

public interface UserService {

    UserCreateResponse create(UserCreateRequest createRequest);

    UserReadResponse getId(Long id);

    List<UserReadResponse> getAll();

    void delete (Long id);

    UserUpdateResponse update(Long id , UserUpdateRequest updateRequest);

    UserRegistrationResponse registerUser(UserRegistrationRequest request);

    String loginUser(UserLoginRequest request);

}