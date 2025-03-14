package az.hamburg.librarymanagement.controller;

import az.hamburg.librarymanagement.model.request.UserCreateRequest;
import az.hamburg.librarymanagement.model.request.UserRegistrationRequest;
import az.hamburg.librarymanagement.model.request.UserUpdateRequest;
import az.hamburg.librarymanagement.model.response.UserCreateResponse;
import az.hamburg.librarymanagement.model.response.UserReadResponse;
import az.hamburg.librarymanagement.model.response.UserRegistrationResponse;
import az.hamburg.librarymanagement.model.response.UserUpdateResponse;
import az.hamburg.librarymanagement.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
@Tag(name = "User Controller API", description = "Managing User Apis")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

    private final UserService userService;

    @PostMapping
    @Operation(summary = "Create a new user", description = "Add a new user to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User Created successfully",
            content = @Content(schema = @Schema(implementation = UserCreateResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public UserCreateResponse create(@RequestBody UserCreateRequest createRequest) {
        return userService.create(createRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserReadResponse getId(@PathVariable Long id) {
        return userService.getId(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UserReadResponse> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserUpdateResponse update(@PathVariable Long id, @RequestBody UserUpdateRequest updateRequest) {
        return userService.update(id, updateRequest);
    }

    @PostMapping("/sing-up")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserRegistrationResponse> signUp(@RequestBody UserRegistrationRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }

}