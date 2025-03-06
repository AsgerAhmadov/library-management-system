package az.hamburg.librarymanagement.mappers;

import az.hamburg.librarymanagement.entity.User;
import az.hamburg.librarymanagement.model.request.UserCreateRequest;
import az.hamburg.librarymanagement.model.response.UserCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,
unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface UserMapper {

    User createRequestToEntity(UserCreateRequest createRequest);

    UserCreateResponse entityToCreateResponse(User user);

}
