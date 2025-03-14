package az.hamburg.librarymanagement.mappers;

import az.hamburg.librarymanagement.entity.User;
import az.hamburg.librarymanagement.model.request.UserCreateRequest;
import az.hamburg.librarymanagement.model.request.UserRegistrationRequest;
import az.hamburg.librarymanagement.model.request.UserUpdateRequest;
import az.hamburg.librarymanagement.model.response.UserCreateResponse;
import az.hamburg.librarymanagement.model.response.UserReadResponse;
import az.hamburg.librarymanagement.model.response.UserRegistrationResponse;
import az.hamburg.librarymanagement.model.response.UserUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,
unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface UserMapper {

    User createRequestToEntity(UserCreateRequest createRequest);

    UserCreateResponse entityToCreateResponse(User user);

    UserReadResponse entityToReadResponse(User user);

    List<UserReadResponse> listEntityToListReadResponse(List<User> users);

    User updateRequestToEntity(UserUpdateRequest updateRequest);

    UserUpdateResponse entityToUpdateResponse(User user);

    User registrationRequestToEntity(UserRegistrationRequest registration);

    UserRegistrationResponse entityToRegistrationResponse(User user);

}