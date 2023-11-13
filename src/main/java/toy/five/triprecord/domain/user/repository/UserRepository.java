package toy.five.triprecord.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.five.triprecord.domain.user.dto.request.UserGetRequest;
import toy.five.triprecord.domain.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    public Optional<User> findByEmail(String email);

    public boolean existsByEmail (String email);

//    Optional<Object> findByUsername(String username);
}
