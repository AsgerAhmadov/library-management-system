package az.hamburg.librarymanagement.service;

import az.hamburg.librarymanagement.model.request.UserCreateRequest;
import az.hamburg.librarymanagement.model.response.UserCreateResponse;
import az.hamburg.librarymanagement.model.response.UserReadResponse;

import java.util.List;

public interface UserService {
    UserCreateResponse create(UserCreateRequest createRequest);

    UserReadResponse get(Long id);

    List<UserReadResponse> getAll();
}
