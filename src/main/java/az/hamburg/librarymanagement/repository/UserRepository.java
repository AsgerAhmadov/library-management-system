package az.hamburg.librarymanagement.repository;

import az.hamburg.librarymanagement.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndPin(String email, String pin);

    Optional<User> findByEmailAndPassword(String email, String password);

    // select * from user where email = ? AND pin = ?;

}