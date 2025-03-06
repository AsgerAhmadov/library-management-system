package az.hamburg.librarymanagement.controller;

import az.hamburg.librarymanagement.model.request.UserCreateRequest;
import az.hamburg.librarymanagement.model.response.UserCreateResponse;
import az.hamburg.librarymanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreateResponse create(@RequestBody UserCreateRequest createRequest) {
        return userService.create(createRequest);
    }
}
