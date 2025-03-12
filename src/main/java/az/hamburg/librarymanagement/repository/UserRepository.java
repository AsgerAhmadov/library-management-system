package az.hamburg.librarymanagement.repository;

import az.hamburg.librarymanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List <User> findAllByPin(String pin);
}
