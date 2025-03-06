package az.hamburg.librarymanagement.service.impl;
import az.hamburg.librarymanagement.entity.User;
import az.hamburg.librarymanagement.mappers.UserMapper;
import az.hamburg.librarymanagement.model.request.UserCreateRequest;
import az.hamburg.librarymanagement.model.response.UserCreateResponse;
import az.hamburg.librarymanagement.model.response.UserReadResponse;
import az.hamburg.librarymanagement.repository.UserRepository;
import az.hamburg.librarymanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


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
    public UserReadResponse get(Long id) {
        return null;
    }

    @Override
    public List<UserReadResponse> getAll() {
        return List.of();
    }
}
